package com.nsj.samplenewsapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nsj.samplenewsapp.data.dao.NewsDao
import com.nsj.samplenewsapp.data.entity.NewsEntity

@Database(entities = [NewsEntity::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}