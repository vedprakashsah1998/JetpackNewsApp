package com.nsj.samplenewsapp.data.network

import com.nsj.samplenewsapp.data.dto.NewsDto
import com.nsj.samplenewsapp.utils.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String="us",
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("pageSize") pageSize: Int = 100
    ): NewsDto

    @GET("v2/top-headlines")
    suspend fun getTopHeadlinesWithSources(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("pageSize") pageSize: Int = 100,
        @Query("sources") sources: String
    ): NewsDto
}