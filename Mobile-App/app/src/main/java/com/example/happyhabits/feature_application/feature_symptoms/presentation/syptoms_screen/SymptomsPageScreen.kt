package com.example.happyhabits.feature_application.feature_symptoms.presentation.syptoms_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

import com.example.happyhabits.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.happyhabits.feature_application.presentation.util.Screen
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.MaterialDialogState

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SymptomsPageView(
    navController: NavController,
    viewModel : SymptomsPageViewModel = hiltViewModel()
) {

    val state by viewModel.state
    val colors = listOf(Color.White, Color(0xff64519A))
    val newNotification = true
    val scrollState = rememberScrollState()
    var notes by remember {
        mutableStateOf(state.notes)
    }
    var symptom by remember {
        mutableStateOf(state.symptom)
    }

    var showDialog by remember {
        mutableStateOf(false)
    }
    var selectedSection by remember {
        mutableStateOf("")
    }


   var dynamicState = viewModel.state


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(colors = colors)
            )
            .padding(0.dp)
    ) {
        Column(
        )
        {
            Row(
                Modifier
                    .fillMaxHeight(0.13f)
            ) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
                {
                    Column(modifier = Modifier.fillMaxSize())
                    {
                        Box()
                        {
                            Row(modifier = Modifier.clickable {
                                navController.navigate(Screen.HomePageScreen.route)
                            })
                            {
                                Text(
                                    text = "<",
                                    color = Color(0xFF544C4C),
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier.padding(start = 20.dp, top = 24.dp)
                                )
                                Text(
                                    text = "Back",
                                    color = Color(0xFF544C4C),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier.padding(top = 31.dp)
                                )
                            }
                        }
                        Text(
                            text = "Symptoms",
                            color = Color.Black,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }

                }

            }
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
            )
            {
                Spacer(modifier = Modifier.height(5.dp))
                //------------------------------Head---------------------------
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color.White)
                        .clickable {
                            selectedSection = "Head and Neck"
                            showDialog = true
                        }


                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            text = "Head and Neck",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp, start = 20.dp),
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .size(80.dp)
                            //.background(Color.LightGray, CircleShape)
                            ,
                            contentAlignment = Alignment.Center

                        ) {
                            Image(
                                painter = painterResource(R.drawable.head_neck),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .size(55.dp)

                            )
                        }

                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                // ----------------------------Abdomen ------------------------------------
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .clip(RoundedCornerShape(30.dp))

                        .background(Color.White)
                        .clickable {
                            selectedSection = "Abdomen"
                            showDialog = true
                        }


                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            text = "Abdomen",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp, start = 20.dp),
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .size(80.dp)
                            //.background(Color.LightGray, CircleShape)
                            ,
                            contentAlignment = Alignment.Center

                        ) {
                            Image(
                                painter = painterResource(R.drawable.abdomen),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .size(55.dp)

                            )
                        }

                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                //------------------------------- Chest and Back ---------------------
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .clip(RoundedCornerShape(30.dp))

                        .background(Color.White)
                        .clickable {
                            selectedSection = "Chest and Back"
                            showDialog = true
                        }


                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            text = "Chest and Back",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp, start = 20.dp),
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .size(80.dp)
                            //.background(Color.LightGray, CircleShape)
                            ,
                            contentAlignment = Alignment.Center

                        ) {
                            Image(
                                painter = painterResource(R.drawable.back_icon),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .size(55.dp)

                            )
                        }

                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                // ------------------------Pelvic and Genitourinary--------------------------------------
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .clip(RoundedCornerShape(30.dp))

                        .background(Color.White)
                        .clickable {
                            selectedSection = "Pelvic and Genitourinary"
                            showDialog = true
                        }


                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            text = "Pelvic and Genitourinary",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp, start = 20.dp),
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .size(80.dp)
                            //.background(Color.LightGray, CircleShape)
                            ,
                            contentAlignment = Alignment.Center

                        ) {
                            Image(
                                painter = painterResource(R.drawable.pelvic_icon),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .size(55.dp)

                            )
                        }

                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                //------------------- Limbs --------------------------------
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .clip(RoundedCornerShape(30.dp))

                        .background(Color.White)
                        .clickable {
                            selectedSection = "Limbs"
                            showDialog = true
                        }


                ) {
                    Row(
                        modifier = Modifier
                            .clickable {
                                selectedSection = "Limbs"
                                showDialog = true
                            }
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            text = "Limbs",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp, start = 20.dp),
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .size(80.dp)
                            //.background(Color.LightGray, CircleShape)
                            ,
                            contentAlignment = Alignment.Center

                        ) {
                            Image(
                                painter = painterResource(R.drawable.limbs_icon),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .size(55.dp)

                            )
                        }

                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                // -------------------- Neurological -------------------------
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .clip(RoundedCornerShape(30.dp))

                        .background(Color.White)
                        .clickable {
                            selectedSection = "Neurological"
                            showDialog = true
                        }


                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            text = "Neurological",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp, start = 20.dp),
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .size(80.dp)
                            //.background(Color.LightGray, CircleShape)
                            ,
                            contentAlignment = Alignment.Center

                        ) {
                            Image(
                                painter = painterResource(R.drawable.neuro_icon),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .size(55.dp)

                            )
                        }

                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                // --------------------- Skin ----------------------------
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .clip(RoundedCornerShape(30.dp))

                        .background(Color.White)
                        .clickable {
                            selectedSection = "Skin"
                            showDialog = true
                        }


                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            text = "Skin",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp, start = 20.dp),
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .size(80.dp)
                            //.background(Color.LightGray, CircleShape)
                            ,
                            contentAlignment = Alignment.Center

                        ) {
                            Image(
                                painter = painterResource(R.drawable.skin_icon),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .size(55.dp)

                            )
                        }

                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
        if (showDialog) {
            ChecklistDialog(
                section = selectedSection,
                dialogState = remember { MaterialDialogState(true) },
                symptomList = when (selectedSection) {
                    "Skin" -> viewModel.getSkinList()
                    "Limbs" -> viewModel.getLimbList()
                    "Head and Neck" -> viewModel.getHandList()
                    "Abdomen" -> viewModel.getAbdList()
                    "Chest and Back" -> viewModel.getChestList()
                    "Pelvic and Genitourinary" -> viewModel.getPelvList()
                    "Neurological" -> viewModel.getNeuroList()
                    else -> emptyList()
                },
                viewModel = viewModel,
                onDismiss = { showDialog = false }
            )

        }
        if(dynamicState.value.showErrorMessage){
            AlertDialog(
                onDismissRequest = {viewModel.onEvent(SymptomsPageEvent.ShowErrorMessage(false))},
                title = { Text("You did not choose a symptom")},
                confirmButton = {
                    Button(
                        onClick={ viewModel.onEvent(SymptomsPageEvent.ShowErrorMessage(false))
                                navController.navigate(Screen.HomePageScreen.route)},

                        ){
                        Text("OK")
                    }
                }
            )
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChecklistDialog(section: String, dialogState: MaterialDialogState, symptomList: List<String>,viewModel : SymptomsPageViewModel, onDismiss: () -> Unit)  {
    val selectedOption = remember { mutableStateOf("") }
    var diary by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    MaterialDialog(
        dialogState = dialogState,
        buttons = {
            positiveButton("OK") {
                if(selectedOption.value!="") {
                    viewModel.onEvent(SymptomsPageEvent.AddSymptomLog(diary, selectedOption.value))
                    dialogState.hide()
                    onDismiss()

                }
                else {
                    viewModel.onEvent(SymptomsPageEvent.ShowErrorMessage(true))
                }

            }
            negativeButton("Cancel") {
                onDismiss()
            }
        },
        shape = RoundedCornerShape(20.dp)
    ) {


        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xffE9E3FB))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .fillMaxWidth()

            ) {


                Text(
                    text = section,
                    fontSize = 24.sp,
                    color = Color(0xff64519A),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))

                symptomList.forEachIndexed { index, item ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        RadioButton(
                            selected = selectedOption.value == item,
                            onClick = { selectedOption.value = item }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = item,
                            style = TextStyle(fontSize = 18.sp),
                            color = Color.Black
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.White)
                ) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        val lineHeight = 40.dp.toPx()
                        var y = lineHeight
                        while (y < size.height) {
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(0f, y),
                                end = Offset(size.width, y),
                                strokeWidth = 1.dp.toPx()
                            )
                            y += lineHeight
                        }
                    }
                    TextField(
                        value = diary,
                        shape = RoundedCornerShape(20.dp),
                        onValueChange = { newText ->
                            val lines = newText.split("\n")
                            diary = if (lines.size <= 2) {
                                newText
                            } else {
                                lines.take(2).joinToString("\n")
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .fillMaxHeight(),
                        label = { Text("Additional Notes") },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 40.sp
                        ),
                        maxLines=2

                    )
                }
            }

        }
    }
}















