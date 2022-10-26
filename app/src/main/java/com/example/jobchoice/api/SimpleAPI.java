package com.example.jobchoice.api;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface SimpleAPI {

    @POST("user/login")
    Call<LoginPost> loginpushPost(@Body LoginPost loginpost);

    @POST("user/register")
    Call<RegisterPost> registerpushPost(@Body RegisterPost registerpost);

    @POST("user/post")
    Call<WorkerFindingPost> workerFindingpushPost(@Body WorkerFindingPost workerFindingPost);

    @POST("user/post2")
    Call<JobFindingPost> jobFindingpushPost(@Body JobFindingPost jobFindingPost);


    @GET("user/get/{id}")
    Call<ProfileGet> profilepushGet(@Path("id") String id);

    @DELETE("user/delete/{id}")
    Call<Void> userpushDelete(@Path("id") String id);

    @POST("user/update/{id}")
    Call<EditProfilePut> editprofilepushPut(@Path("id") String id, @Body EditProfilePut editProfilePatch);
}
