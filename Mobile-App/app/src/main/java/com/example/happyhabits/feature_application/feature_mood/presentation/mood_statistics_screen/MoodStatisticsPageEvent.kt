package com.example.happyhabits.feature_application.feature_mood.presentation.mood_statistics_screen

 sealed class MoodStatisticsPageEvent {
     data class SendStatistics(val indexOfFriend: Int): MoodStatisticsPageEvent()
 }