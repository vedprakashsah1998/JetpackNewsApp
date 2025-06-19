package com.nsj.samplenewsapp.domain.repository

interface AnalyticsService {
    fun logEvent(eventName: String)
}