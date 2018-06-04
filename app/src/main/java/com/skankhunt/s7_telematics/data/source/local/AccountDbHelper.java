package com.skankhunt.s7_telematics.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wupengcong on 2018/5/31.
 */

public class AccountDbHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "Account.db";

    private static final String TEXT_TYPE = " TEXT";

    private static final String BOOLEAN_TYPE = " INTEGER";

    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + AccountPersistenceContract.UserEntry.TABLE_NAME + " (" +
                    AccountPersistenceContract.UserEntry.COLUMN_NAME_USERNAME + TEXT_TYPE + " PRIMARY KEY," +
                    AccountPersistenceContract.UserEntry.COLUMN_NAME_PASSWORD + TEXT_TYPE + COMMA_SEP +
                    AccountPersistenceContract.UserEntry.COLUMN_NAME_CARNUM + TEXT_TYPE + COMMA_SEP +
                    AccountPersistenceContract.UserEntry.COLUMN_NAME_PHONENUM+ TEXT_TYPE +
                    " )";

    public AccountDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //创建表
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
