package com.example.jobchoice.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SimpleAPI {

    @POST("user/login")
    Call<Post> pushPost(@Body Post post);
}
