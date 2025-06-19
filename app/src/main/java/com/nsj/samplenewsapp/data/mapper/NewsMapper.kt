package com.nsj.samplenewsapp.data.mapper

import com.nsj.samplenewsapp.data.dto.ArticleDto
import com.nsj.samplenewsapp.data.entity.NewsEntity
import com.nsj.samplenewsapp.domain.model.NewsArticle

fun NewsEntity.toDomain(): NewsArticle {
    return NewsArticle(
        title = title,
        description = description,
        url = url,
        imageUrl = imageUrl,
        publishedAt = publishedAt
    )
}
fun ArticleDto.toEntity(): NewsEntity = NewsEntity(
    url = url,
    title = title,
    description = description,
    imageUrl = urlToImage,
    publishedAt = publishedAt
)