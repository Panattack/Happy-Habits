package com.example.happyhabits.feature_application.feature_symptoms.presentation.symptoms_statistics_screen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.happyhabits.R
import com.example.happyhabits.feature_application.presentation.util.Screen
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.MaterialDialogState
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import kotlinx.coroutines.delay
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.Year
import java.time.YearMonth

@SuppressLint("UnrememberedMutableState")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SymptomsStatisticsPageView(
    navController: NavController,
    viewModel : SymptomsStatisticsPageViewModel = hiltViewModel()
) {
    var fill by remember { mutableStateOf(false) }

    var selectedMonth by remember { mutableStateOf(0) }
    // when the screen will load
    LaunchedEffect(Unit) {
        delay(2000)
        fill = true

    }
    val dialogState = rememberMaterialDialogState()
    val colors = listOf(Color.White, Color(0xff64519A))
    val dynamicState = viewModel.state.value
    val scrollState = rememberScrollState()
    val sendStatistics = rememberMaterialDialogState()
    val state by viewModel.state
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = Brush.verticalGradient(colors = colors))
        ) {
            Column()
            {
                Row (
                    Modifier
                        .fillMaxHeight(0.14f))
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
                                Row(modifier = Modifier.clickable { navController.navigate(Screen.WorkoutStatisticsPageScreen.route) })
                                {
                                    Text(
                                        text = "<",
                                        color = Color(0xFF544C4C),
                                        fontSize = 28.sp,
                                        fontWeight = FontWeight.Normal,
                                        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                                    )
                                    Text(
                                        text = "Back",
                                        color = Color(0xFF544C4C),
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Normal,
                                        modifier = Modifier.padding(top = 17.dp)
                                    )
                                }
                            }
                            Text(
                                text = "Symptom Statistics",
                                color = Color.Black,
                                fontSize = 22.sp,
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
                        .verticalScroll(scrollState)
                        .padding(16.dp)
                ) {
                    Text(
                        text = dynamicState.month,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    Row {
                        Text(
                            text = "Top ",
                            fontSize = 30.sp,
                            fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                            color = Color.Black
                        )
                        Text(
                            text = "5",
                            color = Color(0xff64519A),
                            fontSize = 33.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif
                        )
                        Text(
                            text = " Symptoms",
                            fontSize = 30.sp,
                            fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                            color = Color.Black
                        )
                    }

                    Spacer(modifier = Modifier.fillMaxWidth(0.5f))
                    Spacer(Modifier.height(10.dp))


                    dynamicState.symptomList.forEachIndexed { index, item ->
                        val percentage = 1f - (index * 0.2f)
                        CategoryBox(
                            fill = fill,
                            symptom = item,
                            image = viewModel.getImage(item),
                            percentage = percentage
                        )

                    }
                    Spacer(Modifier.height(10.dp))
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

                    Spacer(Modifier.height(20.dp))
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
                                .height(60.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.calender_logo_purple), // Replace with your calendar icon resource
                                contentDescription = "Calendar Icon",
                                tint = Color(0xff64519A),
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = "Pick a Month",
                                color = Color(0xff64519A),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

//                selectedMonth?.let { month ->
//                    Text(
//                        text = "Selected Month: $month",
//                        modifier = Modifier.padding(top = 16.dp),
//                        fontSize = 20.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                }

                }
            }
        }
    }
    MonthPickerDialog(dialogState, selectedMonth= mutableStateOf(selectedMonth),viewModel)
    MonthPickerDialog(dialogState, selectedMonth= mutableStateOf(selectedMonth),viewModel)
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
                            viewModel.onEvent(SymptomStatisticsPageEvent.SendStatistics(selectedItemIndex))
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




@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MonthPickerDialog(dialogState: MaterialDialogState, selectedMonth: MutableState<Int>,viewModel: SymptomsStatisticsPageViewModel) {

    val currentMonth = YearMonth.now().monthValue
    val months = Month.values().take(currentMonth)
    var selectedOption by remember { mutableStateOf<Month?>(null) }

    MaterialDialog(dialogState = dialogState, buttons = {
        positiveButton("OK"){
            selectedOption?.let { month ->
                selectedMonth.value = month.value
                viewModel.onEvent(SymptomStatisticsPageEvent.MonthHasChanged(month.value))


            }
        }
        negativeButton("Cancel")
    }) {
        Column (
            modifier = Modifier
                .background(Color(0xFFE6E6FA)) // Soft purple background
                .padding(16.dp)
        ) {
            Text(
                text = "Select a Month",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xff64519A),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally)

            )
            Divider(color = Color.Gray)
            LazyColumn {
                items(months) { month ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable { selectedOption = month }
                    ) {
                        RadioButton(
                            selected = selectedOption == month,
                            onClick = { selectedOption = month },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xff64519A) // Dark purple bullet
                            )
                        )
                        Text(text = month.name, modifier = Modifier.padding(start = 8.dp), color = Color(0xff64519A))
                    }
                }
            }
        }
    }
}



@Composable
fun CategoryBox(fill: Boolean, symptom: String, image: Int, percentage: Float) {
    val fillFraction by animateFloatAsState(
        targetValue = if (fill) percentage else 0f,
        animationSpec = tween(durationMillis = 1000), label = ""
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Box(
            modifier = Modifier
                .size(90.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color.White)
                .clickable { /* Handle click if needed */ }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red)
                    .align(Alignment.BottomStart)
                    .fillMaxHeight(fillFraction)

            )
            Image(
                painter = painterResource(id = image),
                contentDescription = "Category Icon",
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(10.dp)

            )


        }
        Spacer(Modifier.width(20.dp))
        Text(
            text = symptom,
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(top = 8.dp),
            color = Color.Black
        )
    }

    Spacer(modifier = Modifier.height(20.dp))
}