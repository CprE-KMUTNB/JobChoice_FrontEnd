package com.example.jobchoice.api;

import java.util.List;

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

    @GET("user/get/{email}")
    Call<ProfileGet> profilepushGet(@Path("email") String email);

    @GET("/user/get/post/workerfinding/count")
    Call<GetPostCount> workerfindingpostcountGet();

    @GET("/user/get/post/jobfinding/count")
    Call<GetPostCount> jobfindingpostcountGet();

    @GET("/user/get/post/workerfinding")
    Call<List<WokerFindingSearchBox>> workerfindingsearchGet();

    @GET("/user/get/post/jobfinding")
    Call<List<JobFindingSearchBox>> jobfindingsearchGet();

    @DELETE("user/delete/{email}")
    Call<Void> userpushDelete(@Path("email") String email);

    @DELETE("user/post/delete/{email}/{title}")
    Call<Void> userpushPostDelete(@Path("email") String email,@Path("title") String title);

    @POST("user/update/{id}")
    Call<EditProfilePut> editprofilepushPut(@Path("id") String id, @Body EditProfilePut editProfilePatch);

}
