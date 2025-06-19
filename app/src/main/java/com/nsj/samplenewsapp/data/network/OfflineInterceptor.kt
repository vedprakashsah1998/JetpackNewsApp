package com.nsj.samplenewsapp.data.network

import android.content.Context
import com.nsj.samplenewsapp.utils.isNetworkAvailable
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class OfflineInterceptor @Inject constructor(@ApplicationContext val context: Context) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var originalRequest = chain.request()
        if (!context.isNetworkAvailable()) {
            originalRequest = originalRequest.newBuilder()
                .cacheControl(CacheControl.FORCE_CACHE)
                .build()
        }
        return chain.proceed(originalRequest)
    }

}