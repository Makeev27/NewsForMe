package com.android.example.newsforme.Retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static Retrofit ourinstance ;
    public static Retrofit getInstance (){
        if (ourinstance == null){
            ourinstance = new Retrofit.Builder()
                    .baseUrl("https://newsapi.org/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return ourinstance;
    }
}
