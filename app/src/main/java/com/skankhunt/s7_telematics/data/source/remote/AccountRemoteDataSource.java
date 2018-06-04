package com.skankhunt.s7_telematics.data.source.remote;

import com.google.common.base.Optional;
import com.skankhunt.s7_telematics.data.User;
import com.skankhunt.s7_telematics.data.source.AccountDataSource;

import io.reactivex.Flowable;

/**
 * Created by wupengcong on 2018/5/31.
 */

/**
 * Account的实时数据来源
 */
public class AccountRemoteDataSource implements AccountDataSource {

    public static AccountRemoteDataSource INSTANCE;

    private AccountRemoteDataSource(){

    }

    public static AccountRemoteDataSource getInstance(){
        if(INSTANCE==null){
            INSTANCE =  new AccountRemoteDataSource();

        }
        return INSTANCE;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public Flowable<Optional<User>> getUser(String username) {
        return null;
    }

    @Override
    public void deleteAllUser() {

    }

    @Override
    public Flowable<NewEntity> getNews(String category, int count, int page) {
        return S7Service.createS7Service("")
                .getNews(category,count,page);
    }


}
