package com.example.jobchoice.api


import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
       val request = chain.request().newBuilder()
           .addHeader("Content-Type","application/json").build()
           //.addHeader("ETag", "W/${"1e8-Uck+3PNKZVwQnRH9sF8UnMOMYKM"}").build()
        //.addHeader("X-platform","Android")
        //.addHeader("X-Auth-Token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzQ0NDA5NGMwYjRjYzBjYTBkYWVmMTIiLCJmaXJzdE5hbWUiOiJNYWtrcmFwb25nIiwibGFzdE5hbWUiOiJTb21ib29uIiwiaWF0IjoxNjY1NDE4OTg3fQ.goo4HkLYH9Jwsi1tdafTirD3SbaTzn92YB3QmKvJwuk").build()
        return chain.proceed(request)
    }
}