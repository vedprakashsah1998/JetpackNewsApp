package com.nsj.samplenewsapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nsj.samplenewsapp.data.entity.NewsEntity

@Dao
interface NewsDao {

    @Query("SELECT * FROM NewsEntity")
    suspend fun getAllArticles(): List<NewsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles: List<NewsEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertArticle(article: NewsEntity)

    @Query("SELECT url FROM NewsEntity WHERE url IS NOT NULL")
    suspend fun getAllArticleUrls(): List<String>

    @Query("DELETE FROM NewsEntity")
    suspend fun clearAll()
}