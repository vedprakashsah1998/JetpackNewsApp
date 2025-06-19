package com.nsj.samplenewsapp.data.dto

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class NewsDto(
    val articles: List<ArticleDto>,
    val status: String,
    val totalResults: Int
):Parcelable

@Keep
@Parcelize
data class ArticleDto(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
):Parcelable

@Keep
@Parcelize
data class Source(
    val id: String,
    val name: String
): Parcelable
