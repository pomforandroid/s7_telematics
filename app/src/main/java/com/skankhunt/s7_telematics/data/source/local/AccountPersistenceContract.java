package com.skankhunt.s7_telematics.data.source.local;

import android.provider.BaseColumns;

/**
 * Created by wupengcong on 2018/5/31.
 */

public final class AccountPersistenceContract {

    /**
     * 防止有人不小心实例化了
     * 提供个空的构造方法
     */
    public AccountPersistenceContract() {
    }

    /**
     * 内部类定义表的字段，表名
     */
    public static abstract  class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_CARNUM = "carnum";
        public static final String COLUMN_NAME_PHONENUM = "phonenum";

    }
}
