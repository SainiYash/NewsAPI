package com.example.newsapi.data.model.api

import com.example.newsapi.BuildConfig
import com.example.newsapi.data.model.APIResponse

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIServices {

    @GET("v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country")
        country:String,
        @Query("page")
        page:Int,
        @Query("apiKey")
        apiKey:String = BuildConfig.API_KEY
    ): Response<APIResponse>
}