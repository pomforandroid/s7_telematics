package com.skankhunt.s7_telematics.data.source.remote;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by wupengcong on 2018/6/4.
 */

public interface S7Api {

    @GET("/api/data/{category}/{count}/{page}")
    Flowable<NewEntity> getNews(@Path("category") String category,@Path("count")  int count ,@Path("page")int page
                                );
}
