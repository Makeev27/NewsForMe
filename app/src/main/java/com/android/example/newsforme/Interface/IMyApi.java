package com.android.example.newsforme.Interface;

import com.android.example.newsforme.Data.Json_Data;
import io.reactivex.Observable;


import retrofit2.http.GET;

public interface IMyApi {

    //Sport
    @GET("top-headlines?pagesize=50&sources=bbc-sport&apiKey=b4812378f7824e55bcd9dd2222cd10a9")
    Observable<Json_Data>  getSportNews() ;

    //Science
    @GET("top-headlines?pagesize=50&country=us&category=science&apiKey=b4812378f7824e55bcd9dd2222cd10a9")
    Observable<Json_Data> getScienceNews();

    //World
    @GET("top-headlines?pagesize=50&category=general&country=us&apiKey=b4812378f7824e55bcd9dd2222cd10a9")
    Observable<Json_Data> getWorldNews();

    //VideoGames!!!!!!
    @GET("everything?pagesize=50&language=en&sources=reddit-r-all&apiKey=c42bec27c79e4d1e9a2767b843263c95")
    Observable<Json_Data> getGamesNews();

    //Наука
    @GET("top-headlines?pagesize=50&country=ru&category=science&apiKey=c42bec27c79e4d1e9a2767b843263c95")
    Observable<Json_Data> getScienceNewsRu();

    //Спорт
    @GET("top-headlines?pagesize=50&country=ru&category=sport&apiKey=c42bec27c79e4d1e9a2767b843263c95")
    Observable<Json_Data> getSportNewsRu();

    //Мир
    @GET("top-headlines?pagesize=50&country=ru&category=general&apiKey=c42bec27c79e4d1e9a2767b843263c95")
    Observable<Json_Data> getWorldNewsRu();

    //Sources
    @GET("sources?apiKey=c42bec27c79e4d1e9a2767b843263c95")
    Observable<Json_Data> getNewsSources();


}
