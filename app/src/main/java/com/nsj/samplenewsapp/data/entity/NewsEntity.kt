package com.nsj.samplenewsapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewsEntity(
    @PrimaryKey val url: String,
    val title: String,
    val description: String?,
    val imageUrl: String?,
    val publishedAt: String,
    val content: String?,
    val fullHtmlBody: String?
)