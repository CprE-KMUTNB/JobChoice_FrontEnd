package com.example.jobchoice.network.repository

import com.example.jobchoice.api.RetrofitInstance
import com.example.jobchoice.network.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(auth: String): Response<Post> {
        return RetrofitInstance.api.getPost(auth)
    }

    suspend fun getPost2(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPosts(userId: Int, sort: String, order: String): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPosts(userId, sort, order)
    }

    suspend fun getCustomPosts2(userId: Int, options: Map<String, String>): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPosts2(userId, options)
    }

    suspend fun pushPost(email: String,password: String): Response<Post> {
        return RetrofitInstance.api.pushPost(email,password)
    }

    suspend fun pushPost2(userId: Int, id: Int, title: String, body: String): Response<Post> {
        return RetrofitInstance.api.pushPost2(userId, id, title, body)
    }

}