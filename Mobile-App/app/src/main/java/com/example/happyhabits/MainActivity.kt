package com.example.happyhabits


import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.happyhabits.feature_application.feature_chat.presentation.choose_friend_group.FriendInboxScreen
import com.example.happyhabits.feature_application.feature_chat.presentation.friend_chat.ChatScreen
import com.example.happyhabits.feature_application.feature_mood.presentation.mood_screen.MoodPageView
import com.example.happyhabits.feature_application.feature_toilet.presentation.toilet_screen.ToiletPageView
import com.example.happyhabits.feature_application.presentation.util.Screen
import com.example.happyhabits.feature_application.feature_workout.presentation.workout_pop_up_screen.WorkoutPopUpView
import com.example.happyhabits.feature_application.feature_food.presentation.food_screen.FoodPageView
import com.example.happyhabits.feature_application.feature_food.presentation.food_search_screen.FoodSearchView
import com.example.happyhabits.feature_application.feature_food.presentation.food_details_screen.FoodDetailsView
import com.example.happyhabits.feature_application.feature_workout.presentation.workout_screen.WorkoutPageView
import com.example.happyhabits.feature_application.feauture_sleep.presentation.sleep_screen.SleepPageView
import com.example.happyhabits.feature_application.feature_profile.presentation.profile_page.ProfileView
import com.example.happyhabits.feature_application.feature_medication.presentation.medication_screen.MedicationPageView
import com.example.happyhabits.feature_application.feature_mood.presentation.mood_statistics_screen.MoodStatisticsPageView
import com.example.happyhabits.feature_application.feature_workout.presentation.workout_statistics_screen.WorkoutStatisticsPageView
import com.example.happyhabits.feature_application.feature_workout.presentation.workout_pop_up_statistics_screen.WorkoutPopUpStatisticsView

import com.example.happyhabits.feature_application.feauture_sleep.presentation.sleep_statistics_screen.SleepStatisticsPageView
import com.example.happyhabits.feature_application.feature_statistics.statistics_screen.StatisticsPageView
import com.example.happyhabits.feature_application.feature_food.presentation.statistics_food.FoodStatisticsPageView
import com.example.happyhabits.feature_application.feature_symptoms.presentation.symptoms_statistics_screen.SymptomsStatisticsPageView
import com.example.happyhabits.feature_application.feature_symptoms.presentation.syptoms_screen.SymptomsPageView
import android.content.Intent
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.happyhabits.feature_authentication.presentation.choose_role.ChooseRoleView
import com.example.happyhabits.feature_authentication.presentation.login.SignInView
import com.example.happyhabits.feature_authentication.presentation.sign_up_user.SignUpUserView
import com.example.happyhabits.feature_authentication.presentation.splash_screen.SplashScreen
import com.example.happyhabits.feature_authentication.presentation.get_started.GetStartedView
import com.example.happyhabits.feature_application.home_page.HomePageView
import com.example.happyhabits.ui.theme.HappyHabitsTheme
import com.example.happyhabits.feature_application.home_page.HomePageView
import com.example.happyhabits.ui.theme.HappyHabitsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyHabitsTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = com.example.happyhabits.feature_authentication.presentation.util.Screen.SplashScreen.route){
                        composable(
                            route = com.example.happyhabits.feature_authentication.presentation.util.Screen.SplashScreen.route
                        ){
                            SplashScreen(navController = navController)
                        }
                        composable(
                            route = com.example.happyhabits.feature_authentication.presentation.util.Screen.GetStartedScreen.route
                        ) {
                            GetStartedView(navController = navController)
                        }
                        composable(
                            route = com.example.happyhabits.feature_authentication.presentation.util.Screen.LoginScreen.route
                        ) {
                            SignInView(navController = navController)
                        }
                        composable(
                            route = com.example.happyhabits.feature_authentication.presentation.util.Screen.AddUserScreen.route +
                                    "?type={type}",
                            arguments = listOf(
                                navArgument(
                                    name = "type"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = 0
                                }
                            )
                        ) {
                            SignUpUserView(navController = navController)
                        }
                        composable(
                            route = com.example.happyhabits.feature_authentication.presentation.util.Screen.ChooseRoleScreen.route
                        ) {
                            ChooseRoleView(navController = navController)
                        }
//                        composable(
//                            route = com.example.happyhabits.feature_authentication.presentation.util.Screen.HomePageScreen.route
//                        ){
//                            val context = LocalContext.current
//                            context.startActivity(Intent(context, MainActivity::class.java))
//                        }
                        composable(
                            route = Screen.HomePageScreen.route
                        ){
                            HomePageView(navController = navController)
                        }
                        composable(
                            route = Screen.WorkoutPageScreen.route
                        ){
                            WorkoutPageView(navController = navController)
                        }
                        composable(
                            route = Screen.ToiletPageScreen.route
                        ){
                            ToiletPageView(navController = navController)
                        }
                        composable(
                            route = Screen.WorkoutPopUpScreen.route
                        ){
                            WorkoutPopUpView(navController = navController)
                        }
                        composable(
                            route = Screen.WorkoutPopUpScreen.route +
                                    "?type={type}",
                            arguments = listOf(
                                navArgument(
                                    name = "type"
                                ) {
                                    type = NavType.StringType
                                    defaultValue = ""
                                }
                            )
                        ) {
                            WorkoutPopUpView(navController = navController)
                        }
                        composable(
                            route = Screen.SleepPageScreen.route
                        ){
                            SleepPageView(navController = navController)
                        }
                        composable(
                            route = Screen.ProfilePageScreen.route
                        ){
                            ProfileView(navController = navController)//navController = navController)
                        }
                        composable(
                            route = Screen.MoodPageScreen.route
                        ){
                            MoodPageView(navController = navController)
                        }
                        composable(
                            route = Screen.MedicationPageScreen.route
                        ){
                            MedicationPageView(navController = navController)
                        }
                        composable(
                            route = Screen.SymptomsPageScreen.route
                        ){
                            SymptomsPageView(navController = navController)
                        }
                        composable(
                            route = Screen.InboxPageScreen.route
                        ){
                            FriendInboxScreen(navController)
                        }
                        composable(
                            route = Screen.ChatPageScreen.route + "?friendUsername={friendUsername}?groupId={groupId}",
                            arguments = listOf(
                                navArgument("friendUsername") { type = NavType.StringType },
                                navArgument("groupId") { type = NavType.StringType }
                            )
                        ){
                            ChatScreen(navController)
                        }
                        composable(
                            route = Screen.StatisticsPageScreen.route
                        ){
                            StatisticsPageView(navController = navController)
                        }
                        composable(
                            route= Screen.SleepStatisticsPageScreen.route
                        ){
                            SleepStatisticsPageView(navController = navController)
                        }
                        composable(
                            route=Screen.MoodStatisticsPageScreen.route
                        ){
                            MoodStatisticsPageView(navController = navController)
                        }
                        composable(
                            route = Screen.SymptomsStatisticsPageSceen.route
                        )
                        {
                            SymptomsStatisticsPageView(navController =  navController)
                        }
                        composable(
                            route = Screen.FoodPageScreen.route+"?specificFood={specificFood}",
                            arguments= listOf(
                                navArgument("specificFood") {
                                    type = NavType.StringType
                                    defaultValue = ""
                                    nullable=true}
                            )
                        ){
                            FoodPageView(navController = navController)
                        }
                        composable(
                            route = Screen.FoodSearchScreen.route + "?searchedFood={searchedFood}&meal={meal}&specificFood={specificFood}",
                            arguments = listOf(
                                navArgument(
                                    name = "searchedFood"
                                ) {
                                    type = NavType.StringType
                                    defaultValue = ""
                                },
                                navArgument(
                                    name = "meal"
                                ) {
                                    type = NavType.StringType
                                    defaultValue = ""
                                    nullable=true
                                },
                                navArgument("specificFood") {
                                    type = NavType.StringType
                                    defaultValue = ""
                                    nullable=true
                                }
                            )
                        ) {
                            FoodSearchView(navController = navController)
                        }
                        composable(
                            route = Screen.FoodDetailsScreen.route + "?searchedFood={searchedFood}&meal={meal}",
                            arguments = listOf(
                                navArgument("searchedFood") {
                                    type = NavType.StringType
                                    defaultValue = ""
                                },
                                navArgument("meal") {
                                    type = NavType.StringType
                                    defaultValue = ""
                                }
                            )
                        ) {
                            FoodDetailsView(navController = navController)
                        }
                        composable(
                            route = Screen.FoodStatisticsScreen.route
                        ){
                            FoodStatisticsPageView(navController = navController)
                        }
                        composable(
                            route = Screen.WorkoutStatisticsPageScreen.route
                        ){
                            WorkoutStatisticsPageView(
                                navController = navController
                            )
                        }
                        composable(
                            route = Screen.WorkoutStatisticsPopUpScreen.route+ "?type={type}",
                            arguments = listOf(
                                navArgument("type") {
                                    type = NavType.StringType
                                    defaultValue = ""
                                }
                            )
                        ) {
                            WorkoutPopUpStatisticsView(
                                navController = navController)
                        }
                    }
                }
            }
        }
    }
}