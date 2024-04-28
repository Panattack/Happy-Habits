package com.example.happyhabits.feature_authentication.presentation.sign_up_doctor

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.happyhabits.R
import com.example.happyhabits.feature_authentication.presentation.util.Screen
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import kotlinx.coroutines.delay
import org.w3c.dom.Text
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SignUpDoctorView(
    navController: NavController
) {
    val context = LocalContext.current
    var birthdateBorder by remember {
        mutableStateOf(Color.Transparent)
    }
    var emailBorder by remember {
        mutableStateOf(Color.Transparent)
    }
    var lastNameBorder by remember {
        mutableStateOf(Color.Transparent)
    }
    var firstNameBorder by remember {
        mutableStateOf(Color.Transparent)
    }
    var passwordBorder by remember {
        mutableStateOf(Color.Transparent)
    }
    var verifyPasswordBorder by remember {
        mutableStateOf(Color.Transparent)
    }
    var specialtyBorder by remember {
        mutableStateOf(Color.Transparent)
    }

    var verifyError by remember {
        mutableStateOf(false)
    }

    val colors = listOf(Color(0xffF8F7FA), Color(0xffA687FF))
    var nameInput by remember {
        mutableStateOf("")
    }
    var surnameInput by remember {
        mutableStateOf("")
    }
    var emailInput by remember {
        mutableStateOf("")
    }
    var passwordInput by remember {
        mutableStateOf("")
    }
    var verifyPasswordInput by remember {
        mutableStateOf("")
    }
    var pickedDate by remember {
        mutableStateOf(LocalDate.now())
    }
    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("MMM dd yyyy")
                .format(pickedDate)
        }
    }
    val dateDialogState = rememberMaterialDialogState()
    var dayInput by remember {
        mutableStateOf(-1)
    }
    var monthInput by remember {
        mutableStateOf(-1)
    }
    var yearInput by remember {
        mutableStateOf(-1)
    }
    var birthDayButtonText by remember {
        mutableStateOf("DD/MM/YY")
    }
    var specialtyInput by remember{
        mutableStateOf("")
    }

    //////////////DropBox Variables//////////////////////////////////////

    var isExpanded by remember {
        mutableStateOf(false)
    }

    val specialties = listOf(
        "Anesthesiology",
        "Cardiology",
        "Dermatology",
        "Emergency Medicine",
        "Endocrinology",
        "Family Medicine",
        "Gastroenterology",
        "Geriatrics",
        "Hematology",
        "Infectious Disease",
        "Internal Medicine",
        "Nephrology",
        "Neurology",
        "Obstetrics and Gynecology",
        "Oncology",
        "Ophthalmology",
        "Orthopedics",
        "Otolaryngology (ENT)",
        "Pathology",
        "Pediatrics",
        "Physical Medicine and Rehabilitation",
        "Plastic Surgery",
        "Psychiatry",
        "Pulmonology",
        "Radiology",
        "Rheumatology",
        "Surgery (General Surgery)",
        "Urology",
        "Other"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(colors = colors)
            )
            .padding(0.dp)
    )
    {
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.95f)
        )
        {
            Text(text = "Welcome to Happy Habits!",
                color= Color.Black,
                fontSize = 29.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    lineHeight = 30.sp
                )
            )
            Text(text = "Create your account!",
                color= Color.Black,
                fontSize = 27.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    lineHeight = 40.sp
                )
            )
            Spacer(modifier = Modifier.height(10.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
                    .verticalScroll(rememberScrollState())
            )
            {
                Text(
                    text = "N A M E",
                    color = Color.Black,
                    fontSize = 15.sp,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 6.dp, top = 10.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                TextField(
                    value = nameInput,
                    shape = RoundedCornerShape(8.dp),
                    onValueChange = {
                        nameInput = it
                    },
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(4.dp)
                        .border(2.dp, firstNameBorder, RoundedCornerShape(8.dp)),
                    label = { Text(text = "Name") },
                    colors = TextFieldDefaults.colors(
                        cursorColor = Color.Gray,
                        unfocusedLabelColor = Color.Gray,
                        focusedLabelColor = Color.Gray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        focusedTextColor = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "S U R N A M E",
                    color = Color.Black,
                    fontSize = 15.sp,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 6.dp, top = 10.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                TextField(
                    value = surnameInput,
                    shape = RoundedCornerShape(8.dp),
                    onValueChange = {
                        surnameInput = it
                    },
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(4.dp)
                        .border(2.dp, lastNameBorder, RoundedCornerShape(8.dp)),
                    label = { Text(text = "Surname") },
                    colors = TextFieldDefaults.colors(
                        cursorColor = Color.Gray,
                        unfocusedLabelColor = Color.Gray,
                        focusedLabelColor = Color.Gray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        focusedTextColor = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "E M A I L",
                    color = Color.Black,
                    fontSize = 15.sp,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 6.dp, top = 10.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                TextField(
                    value = emailInput,
                    shape = RoundedCornerShape(8.dp),
                    onValueChange = {
                        emailInput = it
                    },
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(4.dp)
                        .border(2.dp, emailBorder, RoundedCornerShape(8.dp)),
                    label = { Text(text = "Email") },
                    colors = TextFieldDefaults.colors(
                        cursorColor = Color.Gray,
                        unfocusedLabelColor = Color.Gray,
                        focusedLabelColor = Color.Gray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        focusedTextColor = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "P A S S W O R D",
                    color = Color.Black,
                    fontSize = 15.sp,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 6.dp, top = 10.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                TextField(
                    value = passwordInput,
                    shape = RoundedCornerShape(8.dp),
                    onValueChange = {
                        passwordInput = it
                    },
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(4.dp)
                        .border(2.dp, passwordBorder, RoundedCornerShape(8.dp)),
                    label = { Text(text = "Password") },
                    colors = TextFieldDefaults.colors(
                        cursorColor = Color.Gray,
                        unfocusedLabelColor = Color.Gray,
                        focusedLabelColor = Color.Gray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        focusedTextColor = Color.Black
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "V E R I F Y  P A S S W O R D",
                    color = Color.Black,
                    fontSize = 15.sp,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 6.dp, top = 10.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                TextField(
                    value = verifyPasswordInput,
                    shape = RoundedCornerShape(8.dp),
                    onValueChange = {
                        verifyPasswordInput = it
                    },
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(4.dp)
                        .border(2.dp, verifyPasswordBorder, RoundedCornerShape(8.dp)),
                    label = { Text(text = "Verify Password") },
                    colors = TextFieldDefaults.colors(
                        cursorColor = Color.Gray,
                        unfocusedLabelColor = Color.Gray,
                        focusedLabelColor = Color.Gray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        focusedTextColor = Color.Black
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
                Spacer(modifier = Modifier.height(4.dp))
                var textColor by remember {
                    mutableStateOf(Color.Gray)
                }
                Text(
                    text = "B I R T H D A Y",
                    color = Color.Black,
                    fontSize = 15.sp,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 6.dp, top = 10.dp)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Button(onClick = {
                    dateDialogState.show()
                },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                        .shadow(4.dp)
                        .border(2.dp, birthdateBorder, RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.White
                    )) {
                    Text(text = birthDayButtonText,
                        fontSize =20.sp,
                        color = textColor,
                        textAlign = TextAlign.Start)
                }
                MaterialDialog(
                    dialogState = dateDialogState,
                    buttons = {
                        positiveButton(text = "Ok") {
                        }
                        negativeButton(text = "Cancel")
                    }
                ) {
                    datepicker(
                        initialDate = LocalDate.now(),
                        title = "Pick a date",
                        allowedDateValidator = {
                            it.dayOfMonth <= 31
                            it.year <= 2023
                        }
                    ) {
                        pickedDate = it
                        dayInput = pickedDate.dayOfMonth
                        monthInput = pickedDate.monthValue
                        yearInput = pickedDate.year
                        birthDayButtonText = "%02d/%02d/%02d".format(dayInput, monthInput, yearInput % 100)
                        textColor = Color.Black
                    }
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "S P E C I AL T Y",
                    color = Color.Black,
                    fontSize = 15.sp,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 6.dp, top = 10.dp)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Column(modifier = Modifier
                    .fillMaxWidth())
                {
                    ExposedDropdownMenuBox(expanded=isExpanded, onExpandedChange={ isExpanded = !isExpanded})
                    {
                        TextField(
                            modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth()
                                .shadow(4.dp)
                                .border(2.dp, specialtyBorder, RoundedCornerShape(8.dp)),
                            value =specialtyInput,
                            shape = RoundedCornerShape(8.dp),
                            onValueChange={},
                            readOnly=true,
                            colors = ExposedDropdownMenuDefaults.textFieldColors(
                                cursorColor = Color.Gray,
                                unfocusedLabelColor = Color.Gray,
                                focusedLabelColor = Color.Gray,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                unfocusedContainerColor = Color.White,
                                focusedContainerColor = Color.White,
                                focusedTextColor = Color.Black),
                            trailingIcon= { ExposedDropdownMenuDefaults.TrailingIcon(expanded= isExpanded)})
                        ExposedDropdownMenu(expanded=isExpanded, onDismissRequest = {isExpanded = false}, modifier = Modifier.background(Color.White).fillMaxWidth()){
                            specialties.forEach { specialty ->
                                DropdownMenuItem(onClick = {
                                    specialtyInput = specialty
                                    isExpanded = false
                                }, text = {Text(specialty)}, modifier = Modifier.background(Color.White).fillMaxWidth())
                            }
                        }

                    }

                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = {

                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff8A6AE5),
                    contentColor = Color(0xff8A6AE5)
                )
            ) {
                Text(
                    text = "Sign Up",
                    fontSize =25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Already a member?",
                color = Color.White,
                fontSize =25.sp,
                fontWeight = FontWeight.Bold
            )
            ClickableText(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xff8A6AE5),
                            fontSize = 27.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    ) {
                        append("Log In")
                    }
                },
                onClick = {
                    // Handle click event here
                    navController.navigate(
                        Screen.LoginScreen.route
                    )
                }
            )
        }

    }
}