package com.skankhunt.s7_telematics.data.source;

import android.support.annotation.NonNull;

import com.google.common.base.Optional;
import com.skankhunt.s7_telematics.data.User;
import com.skankhunt.s7_telematics.data.source.remote.NewEntity;


import io.reactivex.Flowable;

/**
 * Created by wupengcong on 2018/5/31.
 */

public interface AccountDataSource {

    void saveUser(User user);


    Flowable<Optional<User>> getUser(String username);

    void deleteAllUser();

    Flowable<NewEntity> getNews(String category,int count,int page);
}
