package com.example.onlineoffice.controller;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnection {

    private static final String BASE_URL = "https://dev-vkhvorostov.mlmsoft.com";

    static Retrofit retrofit;
    static {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static RetrofitConnection instance;

    private RetrofitConnection(){}

    public static RetrofitConnection getInstance(){
        if (instance == null){
            instance = new RetrofitConnection();
        }
        return instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }


}
