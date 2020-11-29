package com.itgenius.ministock.api;

import com.itgenius.ministock.model.RegisterResponse;
import com.itgenius.ministock.model.UsersResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestAPI {
    // เรียกฟังก์ชันลงทะเบียน
    @FormUrlEncoded
    @POST("users")
    Call<RegisterResponse> register(
            @Field("userid") int userid,
            @Field("username") String username,
            @Field("password") String password,
            @Field("firstname") String firstname,
            @Field("lastname") String lastname,
            @Field("status") int status
    );

    @GET("users")
//    Call<UsersResponse> getUsers();
    Call<List<UsersResponse>> getUsers();

}
