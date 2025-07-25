package com.nsj.samplenewsapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.nsj.samplenewsapp.data.entity.NewsEntity

@Dao
interface NewsDao {

    @Query("SELECT * FROM NewsEntity")
    suspend fun getAllArticles(): List<NewsEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertArticle(article: NewsEntity)

    @Upsert
    suspend fun upsertArticles(articles: List<NewsEntity>)

    @Query("SELECT url FROM NewsEntity WHERE url IS NOT NULL")
    suspend fun getAllArticleUrls(): List<String>

    @Query("DELETE FROM NewsEntity")
    suspend fun clearAll()
}