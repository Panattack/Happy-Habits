//package com.example.happyhabits.View
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.annotation.DrawableRes
//import androidx.compose.foundation.Image
//package com.example.happyhabits.View
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.annotation.DrawableRes
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.graphicsLayer
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.Font
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.Font
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.ViewModelProvider
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.happyhabits.R
//import com.example.happyhabits.ViewModel.MainViewModel
//
////import androidx.compose.foundation.background
////import androidx.compose.foundation.border
////import androidx.compose.foundation.layout.Box
////import androidx.compose.foundation.layout.Column
////import androidx.compose.foundation.layout.Row
////import androidx.compose.foundation.layout.Spacer
////import androidx.compose.foundation.layout.fillMaxHeight
////import androidx.compose.foundation.layout.fillMaxSize
////import androidx.compose.foundation.layout.fillMaxWidth
////import androidx.compose.foundation.layout.height
////import androidx.compose.foundation.layout.padding
////import androidx.compose.foundation.layout.size
////import androidx.compose.foundation.layout.width
////import androidx.compose.foundation.text.BasicTextField
////import androidx.compose.material3.Button
////import androidx.compose.material3.MaterialTheme
////import androidx.compose.material3.OutlinedTextField
////import androidx.compose.material3.Text
////import androidx.compose.material3.TextField
////import androidx.compose.material3.TextFieldDefaults
////import androidx.compose.runtime.mutableStateOf
////import androidx.compose.runtime.remember
////import androidx.compose.ui.draw.clip
////import androidx.compose.ui.draw.shadow
////import androidx.compose.ui.graphics.graphicsLayer
////import androidx.compose.ui.res.painterResource
////import androidx.compose.ui.unit.dp
////import androidx.compose.ui.unit.sp
//
//class MainActivity : ComponentActivity() {
//
////TODO : Remove the black header
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
//
//        setContent {
//           ChooseRole()
//        }
//    }
//
//
//    //@Preview
//    @Composable
//    fun LogoView() {
//        val first = FontFamily(
//            Font(R.font.oi_regular, FontWeight.Bold),
//        )
//        val colors = listOf(Color(0xffA586FD), Color(0xff64519A), Color(0xff645199))
//        val letter_color = Color(0xff3A2F59)
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(
//                    brush = Brush.verticalGradient(colors = colors)
//                )
//        ) {
//
//            Text(
//                text = "Happy Habits",
//                color = letter_color,
//                fontSize = 46.sp,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .align(Alignment.TopCenter)
//                    .padding(top = 100.dp),
//                style = TextStyle(
//                    fontWeight = FontWeight.Bold,
//                    fontFamily = first,
//                    lineHeight = 50.sp
//                )
//            )
//
//            Image(
//                painter = painterResource(R.drawable.logoscreen_icon),
//                contentDescription = null,
//                contentScale = ContentScale.Fit,
//                modifier = Modifier
//                    .align(Alignment.Center)
//                    .size(250.dp)
//
//
//            )
//
//            Text(
//                text = "Keep track of what is important to you!",
//                color = Color.White,
//                fontWeight = FontWeight.SemiBold,
//                fontSize = 20.sp,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .align(Alignment.BottomCenter)
//                    .padding(start = 50.dp, end = 50.dp)
//                    .padding(bottom = 60.dp)
//
//            )
//            Button(
//                onClick = {
//                    //viewModel.Na
//                },
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = Color(0xff8A6AE5),
//                    contentColor = Color.White
//                ),
//                shape = RoundedCornerShape(10.dp),
//                contentPadding = PaddingValues(
//                    vertical = 15.dp, // The padding inside the button, vertical
//                    horizontal = 90.dp // The padding inside the button, horizontal
//                ),
//                elevation = ButtonDefaults.buttonElevation(
//                    defaultElevation = 20.dp,
//                    pressedElevation = 20.dp,
//                ),
//                modifier = Modifier
//                    .align(Alignment.BottomCenter)
//                    .padding(bottom = 150.dp)
//
//            ) {
//                Text(
//                    text = "Get Started",
//                    fontSize = 25.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//        }
//
//
//    }
//
//    //@Preview
//    @Composable
//    fun CreateSignInView() {
//        val colors = listOf(Color(0xffF8F7FA), Color(0xffA687FF))
//        var emailInput by remember {
//            mutableStateOf("")
//        }
//        var passwordInput by remember {
//            mutableStateOf("")
//        }
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(
//                    brush = Brush.verticalGradient(colors = colors)
//                )
//                .padding(0.dp)
//                .fillMaxSize()
//                .background(
//                    brush = Brush.verticalGradient(colors = colors)
//                )
//                .padding(0.dp)
//        )
//        {
////        Row(
////            horizontalArrangement = Arrangement.End,
////            modifier = Modifier
////                .fillMaxHeight(0.6f)
////                .fillMaxWidth(0.2f)
////                .background(Color.White)
////        )
////        {
////            Box(
////                modifier = Modifier.fillMaxSize(),
////                contentAlignment = Alignment.TopEnd
////            ) {
//////                Image(
//////                    painter = painterResource(id = R.drawable.light_purple_corner_top),
//////                    contentDescription = null,
//////                    modifier = Modifier
//////                        .graphicsLayer(rotationZ = 180f)
//////                        .fillMaxHeight()
//////                )
//////                Image(
//////                    painter = painterResource(id = R.drawable.dark_purple_corner_top),
//////                    contentDescription = null,
//////                    modifier = Modifier
//////                        .graphicsLayer(rotationZ = 180f)
//////                        .fillMaxSize(0.9f)
//////                )
////            }
////        }
//        }
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            Column(
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier
//                    .fillMaxWidth(0.8f)
//                    .fillMaxHeight(0.8f)
//            )
//            {
//                Text(
//                    text = "Hello!",
//                    color = Color.Black,
//                    fontSize = 40.sp,
//                    style = TextStyle(
//                        fontWeight = FontWeight.Bold,
//                        lineHeight = 30.sp
//                    )
//                )
//                Text(
//                    text = "Sign into your account",
//                    color = Color.Black,
//                    fontSize = 30.sp,
//                    style = TextStyle(
//                        fontWeight = FontWeight.Bold,
//                        lineHeight = 40.sp
//                    )
//                )
//                Spacer(modifier = Modifier.height(30.dp))
//                Text(
//                    text = "E M A I L",
//                    color = Color.Black,
//                    fontSize = 15.sp,
//                    style = TextStyle(
//                        fontWeight = FontWeight.Bold
//                    ),
//                    modifier = Modifier
//                        .align(Alignment.Start)
//                        .padding(start = 6.dp, bottom = 2.dp)
//                )
//                OutlinedTextField(
//                    value = emailInput,
//                    onValueChange = {
//                        emailInput = it
//                    },
//                    maxLines = 1,
//                    modifier = Modifier
//                        .height(50.dp)
//                        .fillMaxWidth()
//                        .size(100.dp)
//                        .background(Color.White)
//
//                )
//
//
//                Spacer(modifier = Modifier.height(16.dp))
//                Text(
//                    text = "P A S S W O R D",
//                    color = Color.Black,
//                    fontSize = 15.sp,
//                    style = TextStyle(
//                        fontWeight = FontWeight.Bold
//                    ),
//                    modifier = Modifier
//                        .align(Alignment.Start)
//                        .padding(start = 6.dp, bottom = 2.dp)
//                )
//                OutlinedTextField(
//                    value = passwordInput,
//                    onValueChange = {
//                        passwordInput = it
//                    },
//                    maxLines = 1,
//                    modifier = Modifier
//                        .height(50.dp)
//                        .fillMaxWidth()
//                        .size(100.dp)
//
//                )
//                Spacer(modifier = Modifier.height(30.dp))
//                Button(
//                    onClick = {
//                        println(emailInput)
//                    },
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = Color(0xff8A6AE5),
//                        contentColor = Color.White
//                    ),
//                    shape = ButtonDefaults.filledTonalShape,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(50.dp)
//                        .background(Color(0xff8A6AE5))
//                        .shadow(4.dp)
//                )
//                {
//                    Text(
//                        text = "Login",
//                        fontSize = 25.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//                Spacer(modifier = Modifier.height(30.dp))
//                Text(
//                    text = "Not a member?",
//                    color = Color.White,
//                    fontSize = 25.sp,
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    text = "Sign Up",
//                    color = Color(0xff8A6AE5),
//                    fontSize = 27.sp,
//                    fontWeight = FontWeight.ExtraBold
//                )
//            }
//
//        }
//    }
//
//    @Preview
//    @Composable
//    fun ChooseRole() {
//        var selectedRole by remember{ mutableStateOf<Int?>(null) }
//        val font = FontFamily(
//            Font(R.font.josefinsans_bold, FontWeight.Bold),
//        )
//        val colors = listOf(Color(0xffA586FD), Color(0xff64519A), Color(0xff645199))
//        var alpha1= 1f
//        var alpha2=1f
//        var elevation1=10.0f
//        var elevation2=10.0f
//
//
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(
//                    brush = Brush.verticalGradient(colors = colors)
//                )
//
//        )
//        {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .align(Alignment.TopCenter),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = "Choose Your Role",
//                    color = Color.White,
//                    fontSize = 30.sp,
//                    fontWeight = FontWeight.SemiBold,
//                    fontFamily = font,
//                    modifier = Modifier
//                        .padding(top=100.dp)
//
//                    )
//                Spacer(modifier = Modifier.height(10.dp))
//                //-----------------SIMPLE USER-----------------------------
//                Row(
//
//                    verticalAlignment = Alignment.CenterVertically,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clickable { selectedRole = 1 }
//                        .graphicsLayer {
//                            this.alpha = alpha1
//                            this.shadowElevation = elevation1
//                            this.clip = true
//                        }
//                )
//                {
//                    Text(
//                        text = "SIMPLE USER",
//                        color = Color.White,
//                        fontSize = 25.sp,
//                        fontWeight = FontWeight.Medium,
//                        fontFamily = font,
//                        modifier = Modifier
//                            .weight(1f)
//                            .padding(start = 30.dp)
//                    )
//                    Spacer(modifier = Modifier.width(16.dp)) // Adjust spacing as necessary
//                    Image(
//                        painter = painterResource(R.drawable.simple_user_photo),
//                        contentDescription = null,
//                        contentScale = ContentScale.Fit,
//                        modifier = Modifier.size(250.dp)
//                    )
//
//
//                }
//
//                Spacer(modifier = Modifier.height(30.dp))
//                // -------------------- DOCTOR -------------------------
//                Row(
//
//                    verticalAlignment = Alignment.CenterVertically,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clickable { selectedRole = 2 }
//                        .graphicsLayer {
//                            this.alpha = alpha2
//                            this.shadowElevation = elevation2
//                            this.clip = true
//                        }
//                )
//                {
//                    Image(
//                        painter = painterResource(R.drawable.doctor_photo),
//                        contentDescription = null,
//                        contentScale = ContentScale.Fit,
//                        modifier = Modifier
//                            .size(250.dp)
//                            .padding(start = 7.dp)
//                    )
//                    Spacer(modifier = Modifier.width(16.dp))
//                    Text(
//                        text = "DOCTOR",
//                        color = Color.White,
//                        fontSize = 25.sp,
//                        fontWeight = FontWeight.Medium,
//                        fontFamily = font,
////        Row(
////            horizontalArrangement = Arrangement.End,
////            modifier = Modifier
////                .fillMaxHeight(0.6f)
////                .fillMaxWidth(0.2f)
////                .background(Color.White)
////        )
////        {
////            Box(
////                modifier = Modifier.fillMaxSize(),
////                contentAlignment = Alignment.TopEnd
////            ) {
//////                Image(
//////                    painter = painterResource(id = R.drawable.light_purple_corner_top),
//////                    contentDescription = null,
//////                    modifier = Modifier
//////                        .graphicsLayer(rotationZ = 180f)
//////                        .fillMaxHeight()
//////                )
//////                Image(
//////                    painter = painterResource(id = R.drawable.dark_purple_corner_top),
//////                    contentDescription = null,
//////                    modifier = Modifier
//////                        .graphicsLayer(rotationZ = 180f)
//////                        .fillMaxSize(0.9f)
//////                )
////            }
////        }
//        }
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            Column(
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier
//                    .fillMaxWidth(0.8f)
//                    .fillMaxHeight(0.8f)
//            )
//            {
//                Text(
//                    text = "Hello!",
//                    color = Color.Black,
//                    fontSize = 40.sp,
//                    style = TextStyle(
//                        fontWeight = FontWeight.Bold,
//                        lineHeight = 30.sp
//                    )
//                )
//                Text(
//                    text = "Sign into your account",
//                    color = Color.Black,
//                    fontSize = 30.sp,
//                    style = TextStyle(
//                        fontWeight = FontWeight.Bold,
//                        lineHeight = 40.sp
//                    )
//                )
//                Spacer(modifier = Modifier.height(30.dp))
//                Text(
//                    text = "E M A I L",
//                    color = Color.Black,
//                    fontSize = 15.sp,
//                    style = TextStyle(
//                        fontWeight = FontWeight.Bold
//                    ),
//                    modifier = Modifier
//                        .align(Alignment.Start)
//                        .padding(start = 6.dp, bottom = 2.dp)
//                )
//                OutlinedTextField(
//                    value = emailInput,
//                    onValueChange = {
//                        emailInput = it
//                    },
//                    maxLines = 1,
//                    modifier = Modifier
//                        .height(50.dp)
//                        .fillMaxWidth()
//                        .size(100.dp)
//                        .background(Color.White)
//
//                )
//
//
//                Spacer(modifier = Modifier.height(16.dp))
//                Text(
//                    text = "P A S S W O R D",
//                    color = Color.Black,
//                    fontSize = 15.sp,
//                    style = TextStyle(
//                        fontWeight = FontWeight.Bold
//                    ),
//                    modifier = Modifier
//                        .align(Alignment.Start)
//                        .padding(start = 6.dp, bottom = 2.dp)
//                )
//                OutlinedTextField(
//                    value = passwordInput,
//                    onValueChange = {
//                        passwordInput = it
//                    },
//                    maxLines = 1,
//                    modifier = Modifier
//                        .height(50.dp)
//                        .fillMaxWidth()
//                        .size(100.dp)
//
//                )
//                Spacer(modifier = Modifier.height(30.dp))
//                Button(
//                    onClick = {
//                        println(emailInput)
//                    },
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = Color(0xff8A6AE5),
//                        contentColor = Color.White
//                    ),
//                    shape = ButtonDefaults.filledTonalShape,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(50.dp)
//                        .background(Color(0xff8A6AE5))
//                        .shadow(4.dp)
//                )
//                {
//                    Text(
//                        text = "Login",
//                        fontSize = 25.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//                Spacer(modifier = Modifier.height(30.dp))
//                Text(
//                    text = "Not a member?",
//                    color = Color.White,
//                    fontSize = 25.sp,
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    text = "Sign Up",
//                    color = Color(0xff8A6AE5),
//                    fontSize = 27.sp,
//                    fontWeight = FontWeight.ExtraBold
//                )
//            }
//
//        }
//    }
//
//    @Preview
//    @Composable
//    fun ChooseRole() {
//        var selectedRole by remember{ mutableStateOf<Int?>(null) }
//        val font = FontFamily(
//            Font(R.font.josefinsans_bold, FontWeight.Bold),
//        )
//        val colors = listOf(Color(0xffA586FD), Color(0xff64519A), Color(0xff645199))
//        var alpha1= 1f
//        var alpha2=1f
//        var elevation1=10.0f
//        var elevation2=10.0f
//
//
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(
//                    brush = Brush.verticalGradient(colors = colors)
//                )
//
//        )
//        {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .align(Alignment.TopCenter),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = "Choose Your Role",
//                    color = Color.White,
//                    fontSize = 30.sp,
//                    fontWeight = FontWeight.SemiBold,
//                    fontFamily = font,
//                    modifier = Modifier
//                        .padding(top=100.dp)
//
//                    )
//                Spacer(modifier = Modifier.height(10.dp))
//                //-----------------SIMPLE USER-----------------------------
//                Row(
//
//                    verticalAlignment = Alignment.CenterVertically,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clickable { selectedRole = 1 }
//                        .graphicsLayer {
//                            this.alpha = alpha1
//                            this.shadowElevation = elevation1
//                            this.clip = true
//                        }
//                )
//                {
//                    Text(
//                        text = "SIMPLE USER",
//                        color = Color.White,
//                        fontSize = 25.sp,
//                        fontWeight = FontWeight.Medium,
//                        fontFamily = font,
//                        modifier = Modifier
//                            .weight(1f)
//                            .padding(start = 30.dp)
//                    )
//                    Spacer(modifier = Modifier.width(16.dp)) // Adjust spacing as necessary
//                    Image(
//                        painter = painterResource(R.drawable.simple_user_photo),
//                        contentDescription = null,
//                        contentScale = ContentScale.Fit,
//                        modifier = Modifier.size(250.dp)
//                    )
//
//
//                }
//
//                Spacer(modifier = Modifier.height(30.dp))
//                // -------------------- DOCTOR -------------------------
//                Row(
//
//                    verticalAlignment = Alignment.CenterVertically,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clickable { selectedRole = 2 }
//                        .graphicsLayer {
//                            this.alpha = alpha2
//                            this.shadowElevation = elevation2
//                            this.clip = true
//                        }
//                )
//                {
//                    Image(
//                        painter = painterResource(R.drawable.doctor_photo),
//                        contentDescription = null,
//                        contentScale = ContentScale.Fit,
//                        modifier = Modifier
//                            .size(250.dp)
//                            .padding(start = 7.dp)
//                    )
//                    Spacer(modifier = Modifier.width(16.dp))
//                    Text(
//                        text = "DOCTOR",
//                        color = Color.White,
//                        fontSize = 25.sp,
//                        fontWeight = FontWeight.Medium,
//                        fontFamily = font,
//                        modifier = Modifier
//                            .weight(1f)
//                            .padding(bottom = 12.dp)
//                    )
//
//
//                }
//
////                Box() {
////                    Button(
////                        onClick = {},//TODO : go to the next screen
////                        shape = RoundedCornerShape(10),
////                        modifier = Modifier
////                            .align(Alignment.BottomCenter)
////                            .padding(bottom = 100.dp)
////                            .width(300.dp)
////                            .height(48.dp),
////
////
////                        colors = ButtonDefaults.buttonColors(
////                            containerColor = Color(0xFFF8E1FB)
////
////                        )
////
////                    )
////                    {
////                        Text(
////                            text="Continue",
////                            color= Color.Black,
////                            fontSize = 24.sp
////                        )
////                    }
////
////                }
//
//
//
//
//            }
//        }
//
//        if(selectedRole!= null) {
//
//            Box() {
//                Button(
//                    onClick = {},//TODO : go to the next screen
//                    shape = RoundedCornerShape(10),
//                    modifier = Modifier
//                        .align(Alignment.BottomCenter)
//                        .padding(bottom = 100.dp)
//                        .width(300.dp)
//                        .height(48.dp),
//
//
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = Color(0xFFF8E1FB)
//                            .weight(1f)
//                            .padding(bottom = 12.dp)
//                    )
//
//
//                }
//
////                Box() {
////                    Button(
////                        onClick = {},//TODO : go to the next screen
////                        shape = RoundedCornerShape(10),
////                        modifier = Modifier
////                            .align(Alignment.BottomCenter)
////                            .padding(bottom = 100.dp)
////                            .width(300.dp)
////                            .height(48.dp),
////
////
////                        colors = ButtonDefaults.buttonColors(
////                            containerColor = Color(0xFFF8E1FB)
////
////                        )
////
////                    )
////                    {
////                        Text(
////                            text="Continue",
////                            color= Color.Black,
////                            fontSize = 24.sp
////                        )
////                    }
////
////                }
//
//
//
//
//            }
//        }
//
//        if(selectedRole!= null) {
//
//            Box() {
//                Button(
//                    onClick = {},//TODO : go to the next screen
//                    shape = RoundedCornerShape(10),
//                    modifier = Modifier
//                        .align(Alignment.BottomCenter)
//                        .padding(bottom = 100.dp)
//                        .width(300.dp)
//                        .height(48.dp),
//
//
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = Color(0xFFF8E1FB)
//
//                    )
//
//                )
//                {
//                    Text(
//                        text="Continue",
//                        color= Color.Black,
//                        fontSize = 24.sp
//                    )
//                }
//
//            }
//            if(selectedRole==1){
//                elevation2=0.0f
//                alpha2=0.3f
//            }
//            else if(selectedRole==2){
//                elevation1=0.0f
//                alpha1=0.3f
//            }
//        }
//    }
//}
//private fun selectedRole(role : Int){
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//                )
//                {
//                    Text(
//                        text="Continue",
//                        color= Color.Black,
//                        fontSize = 24.sp
//                    )
//                }
//
//            }
//            if(selectedRole==1){
//                elevation2=0.0f
//                alpha2=0.3f
//            }
//            else if(selectedRole==2){
//                elevation1=0.0f
//                alpha1=0.3f
//            }
//        }
//    }
//}
//private fun selectedRole(role : Int){
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//