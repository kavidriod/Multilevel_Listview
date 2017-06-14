package com.example.kavitha.multilevel_listview.helper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by Kavitha on 08-06-2017.
 */

public class Api {


    private static Retrofit retrofit = null;

public static  Retrofit getRetrofit(){
    if (retrofit == null){
         retrofit = new Retrofit.Builder()
                .baseUrl("http://api.androidhive.info/songs/")
        .addConverterFactory(GsonConverterFactory.create())
                .build();


    }
    return retrofit;
}

}
