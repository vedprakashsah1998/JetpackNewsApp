package com.nsj.samplenewsapp.data.repositoryImpl

import com.nsj.samplenewsapp.data.mapper.toDomain
import com.nsj.samplenewsapp.data.network.NewsApiService
import com.nsj.samplenewsapp.domain.model.NewsArticle
import com.nsj.samplenewsapp.domain.repository.NewsRepoSources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepoSourcesImpl(
    private val api: NewsApiService
) : NewsRepoSources {
    override suspend fun getTopSourceHeadLines(sourcesId: String): List<NewsArticle> {
        return withContext(Dispatchers.IO) {
            try {
                val remoteArticles = api.getTopHeadlinesWithSources(sources = sourcesId)
                remoteArticles.articles.map { it.toDomain() }

            } catch (e: Exception) {
                emptyList()
            }
        }
    }

}