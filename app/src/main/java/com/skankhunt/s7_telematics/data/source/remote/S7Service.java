package com.skankhunt.s7_telematics.data.source.remote;

import android.text.TextUtils;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wupengcong on 2018/6/4.
 */

public class S7Service {

    private S7Service(){

    }

    public static S7Api createS7Service(final String token){

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("http://gank.io");

        //token不为空的话，添加token信息来请求
        if(!TextUtils.isEmpty(token)){
            OkHttpClient httpClient =
                    new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request();
                            request.newBuilder()
                                    .addHeader("token",token)
                                    .addHeader("requestId",token+"流水号")
                                    .build();
                            return chain.proceed(request);
                        }
                    })
                    .build();
            builder.client(httpClient);
        }
        return builder.build().create(S7Api.class);
    }
}
