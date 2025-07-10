package com.nsj.samplenewsapp.data.repositoryImpl

import com.nsj.samplenewsapp.data.dao.NewsDao
import com.nsj.samplenewsapp.data.mapper.toDomain
import com.nsj.samplenewsapp.data.mapper.toEntity
import com.nsj.samplenewsapp.data.network.NewsApiService
import com.nsj.samplenewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepositoryImpl(
    private val api: NewsApiService,
    private val dao: NewsDao
) : NewsRepository {
    override suspend fun getTopHeadlines() = withContext(Dispatchers.IO) {
        try {
            val remoteArticles = api.getTopHeadlines().articles
            val remoteEntities = remoteArticles.map { it.toEntity() }

            val existingUrls = dao.getAllArticleUrls().toSet()

            if (existingUrls.isEmpty()) {
                // DB empty: insert all one-by-one
                remoteEntities.forEach { dao.insertArticle(it) }
            } else {
                // Insert only new ones one-by-one
                remoteEntities.forEach { entity ->
                    if (entity.url !in existingUrls) {
                        dao.insertArticle(entity)
                    }
                }
            }

        } catch (e: Exception) {
            // Optional: log or handle network error
        }

        // Always return from DB
        dao.getAllArticles().map { it.toDomain() }

    }
}