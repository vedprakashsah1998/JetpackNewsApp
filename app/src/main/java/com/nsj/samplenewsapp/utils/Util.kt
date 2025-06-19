package com.nsj.samplenewsapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build

fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val networkCapabilitiesInfo =
            connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

        networkCapabilitiesInfo.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                networkCapabilitiesInfo.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
    } else {
        val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
        networkInfo != null && networkInfo.isConnected
    }
}

