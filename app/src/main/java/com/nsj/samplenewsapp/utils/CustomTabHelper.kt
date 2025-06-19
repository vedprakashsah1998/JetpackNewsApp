package com.nsj.samplenewsapp.utils

import android.content.Context
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import com.nsj.samplenewsapp.R
import com.nsj.samplenewsapp.ui.theme.isDarkThemeActive

object CustomTabHelper {
    fun openCustomTab(context: Context, url: String) {
        val toolbarColor = ContextCompat.getColor(context, if (isDarkThemeActive.value) R.color.black else R.color.white)

        val colorParams = CustomTabColorSchemeParams.Builder()
            .setToolbarColor(toolbarColor)
            .build()

        val customTabsIntent = CustomTabsIntent.Builder()
            .setDefaultColorSchemeParams(colorParams)
            .setShowTitle(true)
            .build()

        customTabsIntent.launchUrl(context, url.toUri())
    }
}