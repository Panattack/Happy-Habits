package com.example.happyhabits.feature_application.feature_food.presentation.statistics_food

import com.example.happyhabits.feature_application.feature_chat.domain.model.FriendGroup
import com.example.happyhabits.feature_application.feature_food.domain.model.Macros
import com.example.happyhabits.feature_application.feature_food.domain.model.SpecificFood

data class FoodStatisticsState (
    val dateSelected: String = "mm/dd/yy",
    val totalCalories:Float=0f,
    val totalProtein:Float=1f,
    val totalCarbs:Float=1f,
    val totalFats:Float=1f,
    val totalFiber:Float=1f,
    val foodForInfo: SpecificFood =  SpecificFood("","", "", 0f,1f,1f,1f,1f,0f,"whole"),
    val foodForInfoMacros: Macros = Macros(1f,1f,1f,1f,4f),
    val foodList: List<SpecificFood> = listOf(),
    val clientsList: List<FriendGroup> = emptyList()
)