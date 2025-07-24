package com.nsj.samplenewsapp.presentation

import android.os.Build
import android.os.Bundle
import android.view.Surface.CHANGE_FRAME_RATE_ONLY_IF_SEAMLESS
import android.view.Surface.FRAME_RATE_COMPATIBILITY_FIXED_SOURCE
import android.view.SurfaceControl
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.nsj.samplenewsapp.presentation.viewmodels.NewsViewModel
import com.nsj.samplenewsapp.utils.AppNavHost
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    var transaction: SurfaceControl.Transaction = SurfaceControl.Transaction()

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val surfaceControl = SurfaceControl.Builder()
            .setName("MySurfaceControl")
            .setBufferSize(100, 100)
            .setFormat(android.graphics.PixelFormat.RGBA_8888)
            .build()
        transaction.setFrameRate(surfaceControl,
            120F,
            FRAME_RATE_COMPATIBILITY_FIXED_SOURCE,
            CHANGE_FRAME_RATE_ONLY_IF_SEAMLESS)
        transaction.apply()

        setContent {

            val viewmodel by viewModels<NewsViewModel>()
            AppNavHost(newsViewModel = viewmodel)

        }
    }
}


