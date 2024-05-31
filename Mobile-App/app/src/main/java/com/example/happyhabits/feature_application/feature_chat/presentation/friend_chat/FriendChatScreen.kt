package com.example.happyhabits.feature_application.feature_chat.presentation.friend_chat

import androidx.compose.material3.Text
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.happyhabits.feature_application.presentation.util.Screen
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChatScreen(
    navController: NavController,
    viewModel: FriendChatViewModel = hiltViewModel()
) {

    val dynamicState = viewModel.state.value
    val staticState by viewModel.state

    var message by remember { mutableStateOf(staticState.messageContent) }
    val colors = listOf(Color(0xffFAF9FA), Color(0xffA687FF))


    // Function to send a message
    val sendMessage: () -> Unit = {
        // Call ViewModel function to send message
        viewModel.sendMessage(message)
        // Clear the message input field after sending
        message = ""
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xffF5F5F5))
        ){
           Row (
               Modifier
                   .fillMaxHeight(0.13f)) {
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
                               navController.navigate(Screen.InboxPageScreen.route)
                           })
                           {
                               Text(
                                   text = "<",
                                   color = Color(0xFF544C4C),
                                   fontSize = 32.sp,
                                   fontWeight = FontWeight.Normal,
                                   modifier = Modifier.padding(start = 20.dp, top = 24.dp)
                               )
                               Text(
                                   text = "Back",
                                   color = Color(0xFF544C4C),
                                   fontSize = 22.sp,
                                   fontWeight = FontWeight.Normal,
                                   modifier = Modifier.padding(top = 31.dp)
                               )
                           }
                       }
                       Row(
                           modifier = Modifier.fillMaxWidth(),
                           horizontalArrangement = Arrangement.Center
                       ){
                           Text(
                               text= staticState.friendname,
                               fontSize = 24.sp,
                               fontWeight = FontWeight.Bold,
                               modifier = Modifier.padding(start=5.dp),
                               textAlign = TextAlign.Center
                           )
                       }
                   }

               }
           }
        }




        LazyColumn(
            reverseLayout = true,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
        ) {
            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
            items(dynamicState.conversation.reversed()) { message ->
                val isOwnMessage = message.senderId == staticState.userId
                Box(
                    contentAlignment = if (isOwnMessage) {
                        Alignment.CenterEnd
                    } else Alignment.CenterStart,
                    modifier = Modifier.fillMaxWidth()

                ) {
                    Column(
                        modifier = Modifier
                            .widthIn(max=300.dp)
                            .padding(8.dp)
                            .background(
                                color = if (isOwnMessage) Color(0xffF4F4F7) else Color(0xFF64519A),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .drawBehind {
                                val trianglePath = Path().apply {
                                    if (isOwnMessage) {
                                        moveTo(size.width - 10.dp.toPx(), size.height)
                                        lineTo(size.width, size.height - 10.dp.toPx())
                                        lineTo(size.width, size.height)
                                        close()
                                    } else {
                                        moveTo(0f, size.height - 10.dp.toPx())
                                        lineTo(10.dp.toPx(), size.height)
                                        lineTo(0f, size.height)
                                        close()
                                    }
                                }
                                drawPath(
                                    path = trianglePath,
                                    color = if (isOwnMessage) Color(0xFFD8DADE) else Color(0xFF64519A)
                                )
                            }
                            .padding(8.dp)
                    ) {
                        val inputFormat = SimpleDateFormat("M/dd/yyyy h:mm:ss a", Locale.getDefault())
                        val outputFormat = SimpleDateFormat("h:mm a", Locale.getDefault())
                        if(!isOwnMessage) {
                            Text(
                                text = message.content,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 15.sp,
                            )

                            val date = inputFormat.parse(message.timestamp)
                            val timeWithoutSeconds = outputFormat.format(date)

                            Text(
                                text = timeWithoutSeconds,
                                color = Color.White,
                                modifier = Modifier.align(Alignment.End)
                            )
                        }
                        else {
                            Text(
                                text = message.content,
                                color = Color.Black,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 15.sp
                            )
                            val date = inputFormat.parse(message.timestamp)
                            val timeWithoutSeconds = outputFormat.format(date)

                            Text(
                                text = timeWithoutSeconds,
                                color = Color.Black,
                                modifier = Modifier.align(Alignment.End)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(Color.White)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
                //.padding(vertical = 8.dp)
        ) {

                TextField(
                    value = message,
                    onValueChange = { newValue -> message = newValue },
                    placeholder = {
                        Text(text = "Type your message")
                    },
                    modifier = Modifier.weight(1f)
                        .padding(5.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xffD8DADE)
                    ),
                    shape = RoundedCornerShape(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(onClick = sendMessage) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Send,
                        contentDescription = "Send",
                        tint = Color(0xFF64519A)
                    )
                }
        }
    }
}
