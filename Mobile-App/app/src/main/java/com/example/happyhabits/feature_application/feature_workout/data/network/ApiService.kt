package com.example.happyhabits.feature_application.feature_workout.data.network

import com.example.happyhabits.feature_application.feature_workout.data.model.ExercisesWorkoutForm
import com.example.happyhabits.feature_application.feature_workout.data.model.FastActivityForm
import com.example.happyhabits.feature_application.feature_workout.data.model.WeightsForm
import com.example.happyhabits.feature_application.feature_workout.domain.model.ExercisesWorkout
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/Workout/FastActivity/addHabit")
    suspend fun addFastActivity(@Body fastActivityForm: FastActivityForm): Response<String?>

    @POST("api/Workout/Weights/addHabit")
    suspend fun addWeightsActivity(@Body weightsForm: WeightsForm): Response<String>

    @POST("api/Workout/ExerciseWorkout/addHabit")
    suspend fun addExerciseWorkoutActivity(@Body exercisesWorkoutForm: ExercisesWorkoutForm): Response<String>
}
