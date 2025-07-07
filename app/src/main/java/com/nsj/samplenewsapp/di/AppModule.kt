package com.nsj.samplenewsapp.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.Strictness
import com.nsj.samplenewsapp.data.dao.NewsDao
import com.nsj.samplenewsapp.data.database.NewsDatabase
import com.nsj.samplenewsapp.data.network.NewsApiService
import com.nsj.samplenewsapp.data.network.OfflineInterceptor
import com.nsj.samplenewsapp.data.repositoryImpl.NewsRepositoryImpl
import com.nsj.samplenewsapp.domain.repository.NewsRepository
import com.nsj.samplenewsapp.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun providesCache(@ApplicationContext appContext: Context): Cache {
        val cacheSize = 10 * 1024 * 1024
        val cacheDir = File(appContext.cacheDir, "http-cache")
        return Cache(cacheDir, cacheSize.toLong())
    }


    @Provides
    @Singleton
    fun getGson(): Gson = GsonBuilder().serializeNulls().setStrictness(Strictness.LENIENT).create()


    @Singleton
    @Provides
    fun providesOfflineInterceptor(@ApplicationContext appContext: Context) =
        OfflineInterceptor(appContext)

    @Singleton
    @Provides
    fun providesOkHttpClient(
        interceptor: HttpLoggingInterceptor,
        offlineInterceptor: OfflineInterceptor,
        cache: Cache
    ) =
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(offlineInterceptor)
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .cache(cache)
            .build()


    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).client(client)
            .addConverterFactory(GsonConverterFactory.create(gson)).build()

    @Singleton
    @Provides
    fun providesRetroApi(retrofit: Retrofit): NewsApiService =
        retrofit.create(NewsApiService::class.java)

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): NewsDatabase {
        return Room.databaseBuilder(
            context,
            NewsDatabase::class.java,
            "news_db"
        ).build()
    }

    @Provides
    fun provideNewsDao(db: NewsDatabase): NewsDao = db.newsDao()

    @Provides
    fun provideNewsRepository(
        api: NewsApiService,
        dao: NewsDao
    ): NewsRepository {
        return NewsRepositoryImpl(api, dao)
    }
}