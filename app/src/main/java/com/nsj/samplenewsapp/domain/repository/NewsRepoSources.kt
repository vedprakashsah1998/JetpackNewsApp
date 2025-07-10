package com.nsj.samplenewsapp.domain.repository

import com.nsj.samplenewsapp.domain.model.NewsArticle

interface NewsRepoSources {
    suspend fun getTopSourceHeadLines(sourcesId:String): List<NewsArticle>
}