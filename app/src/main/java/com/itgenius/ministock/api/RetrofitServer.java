package com.itgenius.ministock.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServer {

    private static Retrofit retrofit;

    public static Retrofit getClient() {

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
//                    .baseUrl("http://192.168.1.19:9000/jastecapi/api/v1/")
//                    .baseUrl("https://warm-dusk-16069.herokuapp.com/api/v1/")
                    .baseUrl("http://192.168.43.118:8080/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;

    }

}
