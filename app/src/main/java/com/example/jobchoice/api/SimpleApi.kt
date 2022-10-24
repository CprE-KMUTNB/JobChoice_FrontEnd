package com.example.jobchoice.api

import com.example.jobchoice.network.model.Post
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {
    @GET("posts/1")
    suspend fun getPost(@Header("Auth") auth: String): Response<Post>

    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number: Int
    ): Response<Post>

    @GET("posts")
    suspend fun getCustomPosts(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<Post>>

    @GET("posts")
    suspend fun getCustomPosts2(
        @Query("userId") userId: Int,
        @QueryMap options: Map<String, String>
    ): Response<List<Post>>

    @POST("/user/login")
    @FormUrlEncoded
    suspend fun pushPost(
        @Field("email") email : String,
        @Field("password") password : String,
    ): Response<Post>


    @POST("posts")
    @FormUrlEncoded
    suspend fun pushPost2(
        @Field("userId") userId: Int,
        @Field("id") id: Int,
        @Field("title") title: String,
        @Field("body") body: String
    ): Response<Post>

}