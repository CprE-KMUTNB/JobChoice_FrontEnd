package com.example.jobchoice.api;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface SimpleAPI {

    @POST("user/login")
    Call<LoginPost> loginpushPost(@Body LoginPost loginpost);

    @POST("user/register")
    Call<RegisterPost> registerpushPost(@Body RegisterPost registerpost);

    @GET("user/profile/")
    Call<ProfileGet> profilepushGet();

    @DELETE("user/delete/{id}")
    Call<Void> userpushDelete(@Path("id") String id);

    @POST("user/update/{id}")
    Call<EditProfilePut> editprofilepushPut(@Path("id") String id, @Body EditProfilePut editProfilePatch);
}
