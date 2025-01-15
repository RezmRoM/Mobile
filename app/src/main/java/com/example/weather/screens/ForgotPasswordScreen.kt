package com.example.weather.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.weather.ui.theme.*
import com.example.weather.utils.AppIcons
import com.example.weather.utils.StringResources

@Composable
fun ForgotPasswordScreen(
    onBackClick: () -> Unit,
    onSubmitClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(23.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(Background),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = onBackClick) {
                        Image(
                            painter = AppIcons.ChevronLeft(),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(20.dp))
            
            Text(
                text = StringResources.getString("forgot_password"),
                style = MaterialTheme.typography.displayLarge
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = StringResources.getString("enter_account"),
                style = MaterialTheme.typography.labelLarge.copy(textAlign = TextAlign.Center),
                color = Hint
            )
            
            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = {
                    Text(
                        text = "xyz@gmail.com",
                        style = MaterialTheme.typography.labelMedium,
                        color = Hint
                    )
                },
                textStyle = MaterialTheme.typography.labelMedium.copy(color = Text),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Background,
                    focusedContainerColor = Background,
                    unfocusedBorderColor = Background,
                    focusedBorderColor = Accent
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { showDialog = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Accent
                )
            ) {
                Text(
                    text = StringResources.getString("send"),
                    style = MaterialTheme.typography.labelLarge,
                    color = Block
                )
            }
        }

        if (showDialog) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.2f))
                    .blur(4.dp)
                    .clickable { 
                        showDialog = false
                        onSubmitClick()
                    }
            )
            
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    modifier = Modifier
                        .width(335.dp)
                        .height(196.dp),
                    shape = RoundedCornerShape(16.dp),
                    color = Color.White
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(64.dp)
                                .background(Color(0xFF48B2E7), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = AppIcons.EmailOtp(),
                                contentDescription = null,
                                modifier = Modifier.size(32.dp),
                                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White)
                            )
                        }
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        Text(
                            text = StringResources.getString("check_email"),
                            style = MaterialTheme.typography.labelLarge,
                            color = Text
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Text(
                            text = StringResources.getString("recovery_code_sent"),
                            style = MaterialTheme.typography.labelLarge,
                            color = SubTextDark,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
} 