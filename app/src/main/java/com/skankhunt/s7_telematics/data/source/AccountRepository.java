package com.skankhunt.s7_telematics.data.source;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.common.base.Optional;
import com.skankhunt.s7_telematics.data.User;
import com.skankhunt.s7_telematics.data.source.local.AccountLocalDataSource;
import com.skankhunt.s7_telematics.data.source.remote.AccountRemoteDataSource;
import com.skankhunt.s7_telematics.data.source.remote.NewEntity;

import io.reactivex.Flowable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by wupengcong on 2018/5/31.
 */

public class AccountRepository implements AccountDataSource {


    @Nullable
    private static AccountRepository INSTANCE = null;

    //本地数据源
    private final AccountLocalDataSource mAccountLocalDataSource;
    private final AccountRemoteDataSource mAccountRemoteDataSource;


    private AccountRepository(AccountRemoteDataSource accountRemoteDataSource,AccountLocalDataSource accountLocalDataSource) {
        mAccountLocalDataSource = checkNotNull(accountLocalDataSource);
        mAccountRemoteDataSource = checkNotNull(accountRemoteDataSource);

    }

    public static AccountRepository getInstance(@NonNull AccountRemoteDataSource accountRemoteDataSource, @NonNull AccountLocalDataSource accountLocalDataSource ){
        if(INSTANCE==null){
            INSTANCE = new AccountRepository(accountRemoteDataSource,accountLocalDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void saveUser(User user) {
        mAccountLocalDataSource.saveUser(user);

    }

    @Override
    public Flowable<Optional<User>> getUser(String username) {
        return mAccountLocalDataSource.getUser(username);
    }

    @Override
    public void deleteAllUser() {

        mAccountLocalDataSource.deleteAllUser();
    }

    @Override
    public Flowable<NewEntity> getNews(String category, int count, int page) {
        return mAccountRemoteDataSource.getNews(category,count,page);
    }
}
