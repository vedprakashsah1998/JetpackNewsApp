package com.nsj.samplenewsapp.data.network

import com.nsj.samplenewsapp.domain.repository.AnalyticsService
import javax.inject.Inject


class FirebaseAnalyticsService @Inject constructor() : AnalyticsService {
    override fun logEvent(eventName: String) {
        println("Logging event: $eventName")
    }
}
