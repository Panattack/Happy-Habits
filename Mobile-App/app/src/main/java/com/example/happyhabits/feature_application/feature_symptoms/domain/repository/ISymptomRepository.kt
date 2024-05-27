package com.example.happyhabits.feature_application.feature_symptoms.domain.repository

import java.time.LocalDate

interface ISymptomRepository {
    suspend fun addSymptomHabit(userId: String, date: LocalDate, name: String, notes: String)
}