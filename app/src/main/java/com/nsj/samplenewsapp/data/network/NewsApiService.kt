package com.nsj.samplenewsapp.data.network

import com.nsj.samplenewsapp.data.dto.NewsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String,
        @Query("pageSize") pageSize: Int = 100
    ): NewsDto
}