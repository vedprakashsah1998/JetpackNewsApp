package com.nsj.samplenewsapp.domain.model

import android.os.Build
import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import java.util.TimeZone

@Keep
@Parcelize
data class NewsArticle(
    val title: String,
    val description: String?,
    val url: String,
    val imageUrl: String?,
    val publishedAt: String
): Parcelable {
    val formattedDate: String
        get() = try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val zonedDateTime = ZonedDateTime.parse(publishedAt)
                val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.getDefault())
                zonedDateTime.format(formatter)
            } else {
                // Fallback for API < 26
                val isoFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
                isoFormat.timeZone = TimeZone.getTimeZone("UTC")
                val date = isoFormat.parse(publishedAt)

                val outputFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                outputFormat.format(date ?: Date())
            }
        } catch (e: Exception) {
            "" // or "Unknown"
        }
}