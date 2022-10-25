package com.example.jobchoice.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface SimpleAPI {

    @POST("user/login")
    Call<LoginPost> loginpushPost(@Body LoginPost loginpost);

    @POST("user/register")
    Call<RegisterPost> registerpushPost(@Body RegisterPost registerpost);

    @GET("user/profile")
    Call<ProfileGet> profilepushGet(@Body ProfileGet profileGet);

    @PUT("user/editprofile")
    Call<EditProfilePut> editprofilepushPut(@Body EditProfilePut editProfilePatch);
}
