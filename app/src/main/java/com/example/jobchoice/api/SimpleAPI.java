package com.example.jobchoice.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SimpleAPI {

    @POST("user/login")
    Call<LoginPost> loginpushPost(@Body LoginPost loginpost);

    @POST("user/register")
    Call<RegisterPost> registerpushPost(@Body RegisterPost registerpost);
}
