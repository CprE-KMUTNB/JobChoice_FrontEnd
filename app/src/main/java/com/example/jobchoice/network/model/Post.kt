package com.example.jobchoice.network.model
import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val email: String,
    val password: String

)