package com.example.happyhabits.feature_application.home_page

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.happyhabits.R
import com.example.happyhabits.core.domain.model.Type
import com.example.happyhabits.feature_application.feature_workout.presentation.workout_pop_up_screen.WorkoutPopUpEvent
import com.example.happyhabits.feature_application.presentation.util.BottomNavBar
import com.example.happyhabits.feature_application.presentation.util.BottomNavBarDoctor

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import com.example.happyhabits.feature_application.presentation.util.Screen



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomePageView(
    navController: NavController,
    viewModel: HomePageViewmodel = hiltViewModel()
){
    val context = LocalContext.current

    val state by viewModel.state

    var newNotification = true

    val streakCount by remember {
        mutableStateOf(state.streak)
    };
    val firstNameUser by remember {
        mutableStateOf(state.name)
    }
    var streakText = "";

    streakText = if (streakCount==0){
        "No streak yet!"
    }
    else{
        "Great work!"
    }

    val colors = listOf(Color(0xffF8F7FA), Color(0xffA687FF))
    val colorsCategories = listOf(Color(0xffF8F7FA), Color(0xff5734BA))
    val currentDateTime = LocalDateTime.now()
    val formattedDateTime = currentDateTime.format(DateTimeFormatter.ofPattern("E, MMM dd, yyyy", Locale.ENGLISH))
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(colors = colors)
            )
            .padding(0.dp)
    )
    {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ){
            Row (
                Modifier
                    .fillMaxHeight(0.2f)){
                Box (
                    Modifier
                        .fillMaxWidth(0.7f)
                        .fillMaxHeight()
                        .padding(top = 30.dp, start = 20.dp))
                {
                    Column (modifier = Modifier.fillMaxSize()){
                        Text(text = formattedDateTime, color = Color.Black, fontSize = 22.sp, fontWeight = FontWeight.Normal)
                        Text(text="Hello ${firstNameUser}!", color = Color.Black, fontSize = 35.sp, fontWeight = FontWeight.Bold)
                    }

                }

            }
            if(state.type==Type.CLIENT) {
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .padding(start = 13.dp, end = 13.dp)
                )
                {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .height(120.dp)
                            .shadow(5.dp, RoundedCornerShape(12.dp))
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        Color(0xFFF2EFFA), // Start color
                                        Color(0xFFFFC79C)  // End color
                                    )
                                ), shape = RoundedCornerShape(12.dp)
                            )
                    ) {
                        Row(modifier = Modifier.fillMaxSize())
                        {
                            Box(
                                Modifier
                                    .fillMaxWidth(0.75f)
                                    .fillMaxHeight()
                                    .padding(top = 10.dp, start = 10.dp)
                            )
                            {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = streakText,
                                        color = Color.Black,
                                        fontSize = 30.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Spacer(modifier = Modifier.height(7.dp))
                                    Text(
                                        text = "Keep logging to grow your streak ",
                                        color = Color.Black,
                                        fontSize = 19.sp,
                                        fontWeight = FontWeight.Normal
                                    )
                                }
                            }
                            Box(
                                Modifier
                                    .fillMaxWidth(1f)
                                    .fillMaxHeight()
                                    .padding(top = 15.dp, start = 10.dp, bottom = 15.dp)
                            )
                            {
                                Image(
                                    painter = painterResource(R.drawable.streak_fire),
                                    contentDescription = null,
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                )
                                Text(
                                    text = streakCount.toString(),
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .padding(
                                            top = 25.dp,
                                            start = 17.dp,
                                            end = 14.dp,
                                            bottom = 3.dp
                                        ),
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }

                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(450.dp)
                        .padding(start = 13.dp, end = 13.dp)
                        .background(
                            brush = Brush.verticalGradient(colorsCategories),
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Text(
                        text = "Categories",
                        color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(bottom = 3.dp, start = 13.dp, end = 13.dp, top = 16.dp)
                            .background(color = Color.Transparent)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .verticalScroll(rememberScrollState())
                            .background(color = Color.Transparent)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { navController.navigate("sleep_page_screen") }
                                .background(color = Color.White, shape = RoundedCornerShape(12.dp))
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                verticalAlignment = Alignment.CenterVertically
                            )
                            {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(0.2f)
                                        .fillMaxHeight()
                                        .padding(7.dp),
                                    contentAlignment = Alignment.Center

                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(50.dp) // Set the size of the circle
                                            .background(Color.LightGray, shape = CircleShape),
                                        contentAlignment = Alignment.Center
                                    ) {

                                        Image(
                                            painter = painterResource(id = R.drawable.sleep_icon_purple),
                                            contentDescription = null, // Add appropriate content description
                                            modifier = Modifier
                                                .size(37.dp)
                                        )
                                    }
                                }
                                Box(
                                    Modifier
                                        .fillMaxWidth(0.7f)
                                        .fillMaxHeight(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Sleep",
                                        color = Color.Black,
                                        fontSize = 27.sp,
                                        fontWeight = FontWeight.Normal,
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Box(
                                    Modifier
                                        .fillMaxWidth(1f)
                                        .fillMaxHeight().padding(start = 45.dp)
                                ) {
                                    Icon(
                                        Icons.Rounded.KeyboardArrowUp,
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(38.dp)
                                            .graphicsLayer {
                                                rotationZ = 90f
                                            },
                                        tint = Color(0xFF64519A),
                                    )
                                }
                            }

                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()

                                .clickable { navController.navigate("workout_page_screen") }
                                .background(color = Color.White, shape = RoundedCornerShape(12.dp))
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                verticalAlignment = Alignment.CenterVertically
                            )
                            {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(0.2f)
                                        .fillMaxHeight()
                                        .padding(7.dp),
                                    contentAlignment = Alignment.Center

                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(50.dp) // Set the size of the circle
                                            .background(Color.LightGray, shape = CircleShape),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        // Your image goes here
                                        Image(
                                            painter = painterResource(id = R.drawable.running_purple_icon),
                                            contentDescription = null, // Add appropriate content description
                                            modifier = Modifier
                                                .size(37.dp)
                                        )
                                    }
                                }
                                Box(
                                    Modifier
                                        .fillMaxWidth(0.7f)
                                        .fillMaxHeight(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Workout",
                                        color = Color.Black,
                                        fontSize = 27.sp,
                                        fontWeight = FontWeight.Normal,
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Box(
                                    Modifier
                                        .fillMaxWidth(1f)
                                        .fillMaxHeight().padding(start = 45.dp)
                                ) {
                                    Icon(
                                        Icons.Rounded.KeyboardArrowUp,
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(38.dp)
                                            .graphicsLayer {
                                                rotationZ = 90f
                                            },
                                        tint = Color(0xFF64519A),
                                    )
                                }
                            }

                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { navController.navigate(Screen.FoodPageScreen.route) }
                                .background(color = Color.White, shape = RoundedCornerShape(12.dp))
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                verticalAlignment = Alignment.CenterVertically
                            )
                            {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(0.2f)
                                        .fillMaxHeight()
                                        .padding(7.dp),
                                    contentAlignment = Alignment.Center

                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(50.dp) // Set the size of the circle
                                            .background(Color.LightGray, shape = CircleShape),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        // Your image goes here
                                        Image(
                                            painter = painterResource(id = R.drawable.food_icon_purple),
                                            contentDescription = null, // Add appropriate content description
                                            modifier = Modifier
                                                .size(37.dp)
                                        )
                                    }
                                }
                                Box(
                                    Modifier
                                        .fillMaxWidth(0.7f)
                                        .fillMaxHeight(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Food",
                                        color = Color.Black,
                                        fontSize = 27.sp,
                                        fontWeight = FontWeight.Normal,
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Box(
                                    Modifier
                                        .fillMaxWidth(1f)
                                        .fillMaxHeight().padding(start = 45.dp)
                                ) {
                                    Icon(
                                        Icons.Rounded.KeyboardArrowUp,
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(38.dp)
                                            .graphicsLayer {
                                                rotationZ = 90f
                                            },
                                        tint = Color(0xFF64519A),
                                    )
                                }
                            }

                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        // ------------------ SYMPTOMS ---------------------------
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.White, shape = RoundedCornerShape(12.dp))
                                .clickable { navController.navigate("symptoms_page_screen") }
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                verticalAlignment = Alignment.CenterVertically
                            )
                            {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(0.2f)
                                        .fillMaxHeight()
                                        .padding(7.dp),
                                    contentAlignment = Alignment.Center

                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(50.dp) // Set the size of the circle
                                            .background(Color.LightGray, shape = CircleShape),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        // Your image goes here
                                        Image(
                                            painter = painterResource(id = R.drawable.symptoms_icon_purple),
                                            contentDescription = null, // Add appropriate content description
                                            modifier = Modifier
                                                .size(37.dp)
                                        )
                                    }
                                }
                                Box(
                                    Modifier
                                        .fillMaxWidth(0.7f)
                                        .fillMaxHeight(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Symptoms",
                                        color = Color.Black,
                                        fontSize = 27.sp,
                                        fontWeight = FontWeight.Normal,
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Box(
                                    Modifier
                                        .fillMaxWidth(1f)
                                        .fillMaxHeight().padding(start = 45.dp)
                                ) {
                                    Icon(
                                        Icons.Rounded.KeyboardArrowUp,
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(38.dp)
                                            .graphicsLayer {
                                                rotationZ = 90f
                                            },
                                        tint = Color(0xFF64519A),
                                    )
                                }
                            }

                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        // ---------------------- MEDICATION -------------------------------------------------
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { navController.navigate(Screen.MedicationPageScreen.route) }
                                .background(color = Color.White, shape = RoundedCornerShape(12.dp))
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                verticalAlignment = Alignment.CenterVertically
                            )
                            {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(0.2f)
                                        .fillMaxHeight()
                                        .padding(7.dp),
                                    contentAlignment = Alignment.Center

                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(50.dp) // Set the size of the circle
                                            .background(Color.LightGray, shape = CircleShape),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        // Your image goes here
                                        Image(
                                            painter = painterResource(id = R.drawable.medication_icon_purple),
                                            contentDescription = null, // Add appropriate content description
                                            modifier = Modifier
                                                .size(37.dp)
                                        )
                                    }
                                }
                                Box(
                                    Modifier
                                        .fillMaxWidth(0.7f)
                                        .fillMaxHeight(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Medication",
                                        color = Color.Black,
                                        fontSize = 27.sp,
                                        fontWeight = FontWeight.Normal,
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Box(
                                    Modifier
                                        .fillMaxWidth(1f)
                                        .fillMaxHeight().padding(start = 45.dp)
                                ) {
                                    Icon(
                                        Icons.Rounded.KeyboardArrowUp,
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(38.dp)
                                            .graphicsLayer {
                                                rotationZ = 90f
                                            },
                                        tint = Color(0xFF64519A),
                                    )
                                }
                            }

                        }
                        //----------------------- MOOD -------------------------
                        Spacer(modifier = Modifier.height(10.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { navController.navigate("mood_page_screen") }
                                .background(color = Color.White, shape = RoundedCornerShape(12.dp))
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                verticalAlignment = Alignment.CenterVertically
                            )
                            {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(0.2f)
                                        .fillMaxHeight()
                                        .padding(7.dp),
                                    contentAlignment = Alignment.Center

                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(50.dp) // Set the size of the circle
                                            .background(Color.LightGray, shape = CircleShape),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        // Your image goes here
                                        Image(
                                            painter = painterResource(id = R.drawable.mood_icon_purple),
                                            contentDescription = null, // Add appropriate content description
                                            modifier = Modifier
                                                .size(37.dp)
                                        )
                                    }
                                }
                                Box(
                                    Modifier
                                        .fillMaxWidth(0.7f)
                                        .fillMaxHeight(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Mood",
                                        color = Color.Black,
                                        fontSize = 27.sp,
                                        fontWeight = FontWeight.Normal,
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Box(
                                    Modifier
                                        .fillMaxWidth(1f)
                                        .fillMaxHeight().padding(start = 45.dp)
                                ) {
                                    Icon(
                                        Icons.Rounded.KeyboardArrowUp,
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(38.dp)
                                            .graphicsLayer {
                                                rotationZ = 90f
                                            },
                                        tint = Color(0xFF64519A),
                                    )
                                }
                            }

                        }
                        Spacer(modifier = Modifier.height(10.dp))

                        //-------------- TOILET -----------------------------
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.White, shape = RoundedCornerShape(12.dp))
                                .clickable { navController.navigate("toilet_page_screen") }
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                verticalAlignment = Alignment.CenterVertically
                            )
                            {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(0.2f)
                                        .fillMaxHeight()
                                        .padding(7.dp),
                                    contentAlignment = Alignment.Center

                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(50.dp)
                                            .background(Color.LightGray, shape = CircleShape),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        // Your image goes here
                                        Image(
                                            painter = painterResource(id = R.drawable.toilet_icon_purple),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(37.dp)
                                        )
                                    }
                                }
                                Box(
                                    Modifier
                                        .fillMaxWidth(0.7f)
                                        .fillMaxHeight(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Toilet",
                                        color = Color.Black,
                                        fontSize = 27.sp,
                                        fontWeight = FontWeight.Normal,
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Box(
                                    Modifier
                                        .fillMaxWidth(1f)
                                        .fillMaxHeight().padding(start = 45.dp)
                                ) {
                                    Icon(
                                        Icons.Rounded.KeyboardArrowUp,
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(38.dp)
                                            .graphicsLayer {
                                                rotationZ = 90f
                                            },
                                        tint = Color(0xFF64519A),
                                    )
                                }
                            }

                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
            else if(state.type == Type.DOCTOR){
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                )
                {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .background(Color.White, RoundedCornerShape(20.dp))
                            .padding(16.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp), contentAlignment = Alignment.Center
                        )
                        {
                            Text(
                                text = "Keep Up with your clients:",
                                color = Color.Black,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        val lazyColumnHeightInDp = if (state.clientsList.isNotEmpty()) {
                            state.clientsList.size * 50
                        } else {
                            -1
                        }
                        if (lazyColumnHeightInDp != -1) {
                            LazyColumn(
                                Modifier
                                    .height(lazyColumnHeightInDp.dp)
                                    .padding(start = 7.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                items(state.clientsList.size) { item ->
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(
                                                Color.LightGray,
                                                RoundedCornerShape(10.dp)
                                            )
                                            .padding(vertical = 7.dp),
                                        contentAlignment = Alignment.CenterStart
                                    )
                                    {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(
                                                    start = 10.dp,
                                                    end = 10.dp
                                                ),
                                            verticalAlignment = Alignment.CenterVertically
                                        )
                                        {
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxWidth(0.8f)
                                                    .padding(end = 5.dp)
                                            )
                                            {
                                                Text(
                                                    text = state.clientsList[item],
                                                    color = Color.Black,
                                                    fontSize = 17.sp,
                                                    fontWeight = FontWeight.Normal
                                                )
                                            }
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.Center,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Box(
                                                    modifier = Modifier
                                                        .weight(0.5f)
                                                        .padding(end = 3.dp),
                                                    contentAlignment = Alignment.CenterEnd
                                                ) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.info_icon),
                                                        contentDescription = "remove button",
                                                        modifier = Modifier
                                                            .height(30.dp)
                                                            .align(Alignment.CenterEnd)
                                                            .clickable(
                                                                onClick = {
                                                                }
                                                            )
                                                    )
                                                }
                                            }
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(5.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    if(state.type== Type.DOCTOR) {
        BottomNavBarDoctor(navController = navController)
    }else{
        BottomNavBar(navController = navController)
    }
}

