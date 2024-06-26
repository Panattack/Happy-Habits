package com.example.happyhabits.feature_application.feauture_sleep.presentation.sleep_statistics_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import kotlin.math.pow
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

import com.example.happyhabits.R
import com.example.happyhabits.feature_application.feature_food.presentation.statistics_food.FoodStatisticsEvent
import com.example.happyhabits.feature_application.presentation.util.Screen
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SleepStatisticsPageView(
    navController: NavController,
    viewModel: SleepStatisticsPageViewModel = hiltViewModel()
) {
    val state by viewModel.state
    var selectedWeek by remember { mutableStateOf<Pair<LocalDate, LocalDate>?>(null) }
    val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val dialogState = rememberMaterialDialogState()
    val colors = listOf(Color.White, Color(0xff64519A))
    val sendStatistics = rememberMaterialDialogState()
    val daysOfWeek = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    val dynamicState = viewModel.state.value
    val scrollState = rememberScrollState()


    val maxDataPoint = 24
    val customFontFamily = FontFamily(
        Font(R.font.inter_medium, FontWeight.Medium)
    )



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = androidx.compose.ui.graphics.Brush.verticalGradient(colors = colors)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                Modifier
                    .fillMaxHeight(0.13f)
            )
            {
                Box(
                    Modifier
                        .fillMaxWidth(0.8f)
                        .fillMaxHeight()
                )
                {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    )
                    {
                        Box()
                        {
                            Row(
                                modifier = Modifier
                                    .clickable {
                                        navController.navigate(Screen.StatisticsPageScreen.route)
                                    })
                            {
                                Text(
                                    text = "<",
                                    color = Color(0xFF544C4C),
                                    fontSize = 28.sp,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier.padding(start = 20.dp, top = 15.dp)
                                )
                                Text(
                                    text = "Back",
                                    color = Color(0xFF544C4C),
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier.padding(top = 22.dp)
                                )
                            }
                        }
                        Text(
                            text = "Sleep Statistics",
                            color = Color.Black,
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }
                Box(
                    Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight()
                        .padding(top = 15.dp),
                    contentAlignment = Alignment.Center
                )
                {
                    Box(
                        modifier = Modifier
                            .size(45.dp)
                            .background(Color.LightGray, shape = CircleShape)
                            .clickable(onClick = {
                                sendStatistics.show()
                            }),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.share_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())

            ) {
                // Chart Box
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(700.dp)
                        .background(Color.White, shape = RoundedCornerShape(20.dp))
                        .padding(10.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Row(
                            modifier = Modifier.weight(1f)
                        ) {
                            // Scale
                            Column(
                                verticalArrangement = Arrangement.SpaceBetween,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(end = 8.dp, top = 5.dp)
                            ) {
                                for (i in maxDataPoint downTo 0 step 1) {
                                    Text(
                                        text = i.toString(),
                                        fontSize = 15.sp,
                                        color = Color(0xff837979),
                                    )
                                }
                            }
                            // Chart
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 8.dp, end = 10.dp)
                            ) {
                                Canvas(modifier = Modifier.fillMaxSize()) {
                                    val path = Path()
                                    dynamicState.sleepDurations.forEachIndexed { index, y ->
                                        val x =
                                            (size.width / (dynamicState.sleepDurations.size - 1)) * index
                                        val correctTime = y.toInt()
                                        val time =
                                            (correctTime / 60).toInt() + ((correctTime % 60) * 10.0.pow(
                                                -((correctTime % 60) / 10)
                                            )).toInt()
                                        //val time = BigDecimal(((correctTime / 60) +((correctTime % 60))*0.1).toString()).setScale(2, RoundingMode.HALF_EVEN).toInt()
                                        val yOffset =
                                            size.height - (time / maxDataPoint.toFloat() * size.height)
                                        if (index == 0) {
                                            path.moveTo(x, yOffset)
                                        } else {
                                            path.lineTo(x, yOffset)
                                        }
                                    }
                                    drawPath(
                                        path,
                                        color = Color(0xFFA687FF),
                                        style = Stroke(width = 3.dp.toPx())
                                    )

                                    dynamicState.sleepDurations.forEachIndexed { index, y ->
                                        val x =
                                            (size.width / (dynamicState.sleepDurations.size - 1)) * index
                                        val correctTime = y.toInt()
                                        val time =
                                            (correctTime / 60).toInt() + ((correctTime % 60) * 10.0.pow(
                                                -((correctTime % 60) / 10)
                                            )).toInt()
                                        //val time = BigDecimal(((correctTime / 60) +((correctTime % 60)*0.1)).toString()).setScale(2, RoundingMode.HALF_EVEN).toInt()
                                        val yOffset =
                                            size.height - (time / maxDataPoint.toFloat() * size.height)
                                        drawCircle(
                                            color = Color(0xFFA687FF),
                                            radius = 6.dp.toPx(),
                                            center = Offset(x, yOffset)
                                        )
                                    }
                                }
                            }
                        }

                        // Labels for x-axis
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp)
                                .padding(start = 15.dp, end = 0.dp,top=5.dp)
                        ) {
                            daysOfWeek.forEach {
                                Text(
                                    text = it,
                                    fontSize = 17.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Additional information
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    // Daily Average Circle
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .background(Color.White, shape = CircleShape)
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                text = "Daily Average",
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(bottom = 6.dp),
                                style = TextStyle(
                                    fontFamily = customFontFamily,
                                    fontSize = 16.sp,
                                    color = Color.Black
                                )
                            )
                            Row (verticalAlignment = Alignment.CenterVertically){
                                val hours = (state.averageHours).toInt()
                                val minutes = (state.averageMinutes).toInt()
                                val minutesString = if(minutes>=10){minutes.toString()}else{"0${minutes.toString()}"}
                                Text(
                                    text = "${hours}.${minutesString}",
                                    style = TextStyle(
                                        fontFamily = customFontFamily,
                                        fontSize = 20.sp,
                                        color = Color(0xff64519A)
                                    )
                                )
                                Text(
                                    text = "h",
                                    style = TextStyle(
                                        fontFamily = customFontFamily,
                                        fontSize = 20.sp,
                                        color = Color.Black
                                    )
                                )
                            }
                        }
                    }

                    Column(
                        modifier = Modifier.weight(0.5f),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Average Difference Box
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .background(Color.White, shape = RoundedCornerShape(10.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "Average Difference",
                                    fontSize = 16.sp,
                                    style = TextStyle(
                                        fontFamily = FontFamily.Default,
                                        color = Color.Black
                                    )

                                )
                                Text(
                                    text = "from Sleeping Goal",
                                    fontSize = 16.sp,
                                    style = TextStyle(
                                        fontFamily = FontFamily.Default,
                                        color = Color.Black
                                    )
                                )
                                Row (verticalAlignment = Alignment.CenterVertically){
                                    val hours = (state.differenceHours).toInt()
                                    val minutes = (state.differenceMinutes).toInt()
                                    val minutesString = if(minutes>=10){minutes.toString()}else{"0${minutes.toString()}"}
                                    Text(
                                        text = "${hours}.${minutesString}",
                                        style = TextStyle(
                                            fontFamily = FontFamily.Default
                                        ),
                                        fontSize = 20.sp,
                                        color = Color(0xff64519A)
                                    )
                                    Text(
                                        text = " h",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        modifier = Modifier.padding(top = 2.dp),
                                        style = TextStyle(
                                            fontFamily = FontFamily.Default,
                                            color = Color.Black
                                        )
                                    )
                                }
                            }
                        }

                        Spacer(Modifier.height(10.dp))

                        // Average Quality Box
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .background(Color.White, shape = RoundedCornerShape(10.dp))
                                .padding(16.dp)
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "Mostly the sleep was:",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )

                                var image = R.drawable.red_angry_face
                                if (dynamicState.quality == "good") {
                                    image = R.drawable.purple_good_face
                                }
                                if (dynamicState.quality == "okay") {
                                    image = R.drawable.blue_okay_face
                                }
                                if (dynamicState.quality == "great") {
                                    image = R.drawable.green_great_face
                                }
                                if (dynamicState.quality == "poor") {
                                    image = R.drawable.yellow_poor_face
                                }

                                Spacer(modifier = Modifier.width(10.dp))

                                Image(
                                    painter = painterResource(id = image),
                                    contentDescription = "Emoji Icon",
                                    Modifier.size(30.dp)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        thickness = 2.dp,
                        color = Color.LightGray
                    )
                    Text(
                        text = "or",
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 8.dp),
                        style = TextStyle(
                            fontFamily = FontFamily.Default,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        thickness = 2.dp,
                        color = Color.LightGray
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = { dialogState.show() },
                        colors = ButtonDefaults.buttonColors(Color(0XFFEBE8F4)),
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .padding(8.dp)
                            .height(48.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.calender_logo_purple), // Replace with your calendar icon resource
                            contentDescription = "Calendar Icon",
                            tint = Color(0xff64519A),
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Pick a Week",
                            color = Color(0xff64519A),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    selectedWeek?.let { week ->
                        Text(
                            text = "Selected Week: ${week.first.format(dateFormatter)} - ${
                                week.second.format(
                                    dateFormatter
                                )
                            }",
                            modifier = Modifier.padding(top = 16.dp)
                        )
                    }
                }
            }
        }
        MaterialDialog(dialogState = dialogState, buttons = {
            positiveButton("OK")
            negativeButton("Cancel")
        }) {
            // Custom title
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Select the Monday of the week you want ",
                    fontSize = 20.sp, // Adjust the font size as needed
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                datepicker(
                    initialDate = LocalDate.now().with(DayOfWeek.MONDAY),
                    allowedDateValidator = { it.dayOfWeek == DayOfWeek.MONDAY }
                ) { date ->
                    val selectedMonday = date.with(DayOfWeek.MONDAY)
                    val selectedSunday = selectedMonday.plusDays(6)

                    viewModel.onEvent(SleepStatisticsPageEvent.WeekhasChanged(selectedMonday.toString(),selectedSunday.toString()))
                    dialogState.hide()
                }
            }
        }
    }
    MaterialDialog(
        dialogState = sendStatistics,
        shape = RoundedCornerShape(20.dp)
    ) {
        val friendsList = state.clientsList
        var selectedItemIndex by remember { mutableStateOf(-1) }
        var sendButtonBackground by remember { mutableStateOf(Color.LightGray) }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            )
            {
                Text(
                    text = "Chose Receiver",
                    color = Color.Black,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            LazyColumn (Modifier.height(200.dp)){
                items(friendsList) { friend ->
                    val index = friendsList.indexOfFirst { it.friendUsername == friend.friendUsername }
                    val borderColor = if (index == selectedItemIndex) Color(0xFF776A9C) else Color.LightGray

                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray, RoundedCornerShape(10.dp))
                        .border(5.dp, borderColor, RoundedCornerShape(10.dp))
                        .padding(top = 3.dp, bottom = 3.dp)
                        .clickable(onClick = {
                            selectedItemIndex = index
                            sendButtonBackground = Color(0xFF776A9C)
                        }),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Text(
                            text = friend.friendUsername,
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center)
            {
                Button(
                    onClick = {sendStatistics.hide()},
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
                        .height(60.dp)
                        .weight(0.9f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 5.dp,
                        pressedElevation = 5.dp,
                    )
                ) {
                    Text(
                        text = "Cancel",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Button(
                    onClick = {
                        if(selectedItemIndex!=-1)
                        {
                            viewModel.onEvent(SleepStatisticsPageEvent.SendStatistics(selectedItemIndex))
                            sendStatistics.hide()
                        }},
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
                        .height(60.dp)
                        .weight(0.9f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = sendButtonBackground
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 5.dp,
                        pressedElevation = 5.dp,
                    )
                ) {
                    Text(
                        text = "Send",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}




