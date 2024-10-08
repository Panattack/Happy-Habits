﻿using System.Text.Json.Serialization;

namespace Happy_Habits_App.Forms
{
    public class ExercisesWorkoutStatistics(double averageDuration, List<string> topExercises, int totalWorkouts, int averageExercisesPerWorkout)
    {
        [JsonPropertyName("averageDuration")]
        public double AverageDuration { get; set; } = averageDuration;
        [JsonPropertyName("topExercises")]
        public List<string> TopExercises { get; set; } = topExercises;
        [JsonPropertyName("totalWorkouts")]
        public int TotalWorkouts { get; set; } = totalWorkouts;
        [JsonPropertyName("averageExercisePerWorkout")]
        public int AverageExercisesPerWorkout { get; set; } = averageExercisesPerWorkout;
    }
}
