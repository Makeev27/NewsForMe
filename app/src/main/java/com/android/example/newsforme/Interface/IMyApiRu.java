package com.android.example.newsforme.Interface;

import com.android.example.newsforme.Data.Json_Data;
import io.reactivex.Observable;


import retrofit2.http.GET;

public interface IMyApiRu {

    //Спорт
    @GET("top-headlines?country=ru&category=sport&apiKey=b4812378f7824e55bcd9dd2222cd10a9")
    Observable<Json_Data>  getSportNews_ru() ;

    //Наука
    @GET("top-headlines?country=ru&category=science&apiKey=b4812378f7824e55bcd9dd2222cd10a9")
    Observable<Json_Data> getScienceNews_ru();
}
