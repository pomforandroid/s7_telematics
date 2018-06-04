package com.skankhunt.s7_telematics.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.google.common.base.Optional;
import com.skankhunt.s7_telematics.data.User;
import com.skankhunt.s7_telematics.data.source.AccountDataSource;
import com.skankhunt.s7_telematics.data.source.remote.NewEntity;
import com.skankhunt.s7_telematics.util.schedulers.BaseSchedulerProvider;
import com.squareup.sqlbrite2.BriteDatabase;
import com.squareup.sqlbrite2.SqlBrite;


import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by wupengcong on 2018/5/31.
 */

/**
 * Account的本地数据来源，缓存
 */
public class AccountLocalDataSource implements AccountDataSource{

    private static AccountLocalDataSource INSTANCE;

    @NonNull
    private final BriteDatabase mDatabaseHelper;

    private Function<Cursor,User>  mUserMapperFunction;

    private AccountLocalDataSource(Context context, BaseSchedulerProvider schedulerProvider){

        checkNotNull(context, "context cannot be null");
        checkNotNull(schedulerProvider, "scheduleProvider cannot be null");
        AccountDbHelper accountDbHelper = new AccountDbHelper(context);
        SqlBrite sqlBrite = new SqlBrite.Builder().build();
        mDatabaseHelper = sqlBrite.wrapDatabaseHelper(accountDbHelper,schedulerProvider.io());

        mUserMapperFunction = new Function<Cursor, User>() {
            @Override
            public User apply(Cursor cursor) throws Exception {
                return getUser(cursor);
            }
        };

    }

    public static AccountLocalDataSource getInstance(Context context, BaseSchedulerProvider schedulerProvider){
        if (INSTANCE == null) {
            INSTANCE = new AccountLocalDataSource(context, schedulerProvider);
        }
        return INSTANCE;
    }



    @Override
    public void saveUser(User user) {
        checkNotNull(user);
        ContentValues values = new ContentValues();
        values.put(AccountPersistenceContract.UserEntry.COLUMN_NAME_USERNAME,user.getUsername());
        values.put(AccountPersistenceContract.UserEntry.COLUMN_NAME_CARNUM,user.getCarnum());
        values.put(AccountPersistenceContract.UserEntry.COLUMN_NAME_PASSWORD,user.getPassword());
        values.put(AccountPersistenceContract.UserEntry.COLUMN_NAME_PHONENUM,user.getPhonenum());

        mDatabaseHelper.insert(AccountPersistenceContract.UserEntry.TABLE_NAME,values, SQLiteDatabase.CONFLICT_REPLACE);


    }

    @Override
    public Flowable<Optional<User>> getUser(String username) {
        String[] projection = {
                AccountPersistenceContract.UserEntry.COLUMN_NAME_USERNAME,
                AccountPersistenceContract.UserEntry.COLUMN_NAME_CARNUM,
                AccountPersistenceContract.UserEntry.COLUMN_NAME_PASSWORD,
                AccountPersistenceContract.UserEntry.COLUMN_NAME_PHONENUM
        };

        String sql = String.format("SELECT %s FROM %s WHERE %s LIKE ?",
                TextUtils.join(",", projection), AccountPersistenceContract.UserEntry.TABLE_NAME, AccountPersistenceContract.UserEntry.COLUMN_NAME_USERNAME);

        return mDatabaseHelper.createQuery(AccountPersistenceContract.UserEntry.TABLE_NAME, sql, username)
                //.mapToOneOrDefault(cursor -> Optional.of(mUserMapperFunction.apply(cursor)), Optional.<User>absent())
//                .mapToOneOrDefault(new Function<Cursor, User>() {
//
//                    @Override
//                    public User apply(Cursor cursor) throws Exception {
//                        return Optional.of(mUserMapperFunction.apply(cursor));
//                    }
//                })
                .mapToOneOrDefault(new Function<Cursor, Optional<User>>() {
                    @Override
                    public Optional<User> apply(Cursor cursor) throws Exception {
                        return Optional.of(mUserMapperFunction.apply(cursor));
                    }
                }, Optional.<User>absent())
                .toFlowable(BackpressureStrategy.BUFFER);
    }

    @Override
    public void deleteAllUser() {
        mDatabaseHelper.delete(AccountPersistenceContract.UserEntry.TABLE_NAME, null);
    }

    @Override
    public Flowable<NewEntity> getNews(String category, int count, int page) {
        return null;
    }


    @NonNull
    private User getUser(@NonNull Cursor c) {
        String username = c.getString(c.getColumnIndexOrThrow(AccountPersistenceContract.UserEntry.COLUMN_NAME_USERNAME));
        String password = c.getString(c.getColumnIndexOrThrow(AccountPersistenceContract.UserEntry.COLUMN_NAME_PASSWORD));
        String carnum = c.getString(c.getColumnIndexOrThrow(AccountPersistenceContract.UserEntry.COLUMN_NAME_CARNUM));
        String phonenum = c.getString(c.getColumnIndexOrThrow(AccountPersistenceContract.UserEntry.COLUMN_NAME_PHONENUM));

        return new User(username, password, carnum, phonenum);
    }


}
