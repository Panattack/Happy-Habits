package com.example.happyhabits.feature_application.feauture_sleep.domain.use_case

data class SleepUseCases (
    val addSleepHabit: AddSleepHabit,
    val updateSleepGoal: UpdateSleepGoal,
    val calcSleepStatistics: CalcSleepStatistics
)