package com.nsj.samplenewsapp.domain.repository

import com.nsj.samplenewsapp.domain.model.NewsArticle

interface NewsRepository {
    suspend fun getTopHeadlines(country: String): List<NewsArticle>
}