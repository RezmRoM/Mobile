package com.example.weather.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ui.theme.*
import com.example.weather.utils.AppIcons
import com.example.weather.utils.StringResources

@Composable
fun RegistrationScreen(
    onBackClick: () -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

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
            text = StringResources.getString("register"),
            style = MaterialTheme.typography.displayLarge
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = StringResources.getString("fill_details"),
            style = MaterialTheme.typography.bodyMedium.copy(textAlign = TextAlign.Center),
            color = SubTextDark
        )
        
        Spacer(modifier = Modifier.height(32.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Ваше имя",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    color = Text
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                placeholder = {
                    Text(
                        text = "xxxxxxxx",
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

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Email",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    color = Text
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
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

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Пароль",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    color = Text
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = {
                    Text(
                        text = "••••••••",
                        style = MaterialTheme.typography.labelMedium,
                        color = Hint
                    )
                },
                textStyle = MaterialTheme.typography.labelMedium.copy(color = Text),
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Image(
                            painter = if (passwordVisible) AppIcons.Visibility() else AppIcons.VisibilityOff(),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Background,
                    focusedContainerColor = Background,
                    unfocusedBorderColor = Background,
                    focusedBorderColor = Accent
                )
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(18.dp)
                    .background(Background, RoundedCornerShape(4.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = AppIcons.ShieldCheck(),
                    contentDescription = null,
                    modifier = Modifier.size(10.dp)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = StringResources.getString("agree_to_terms"),
                style = MaterialTheme.typography.labelLarge.copy(
                    textDecoration = TextDecoration.Underline
                ),
                color = Hint
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onRegisterClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Accent
            )
        ) {
            Text(
                text = StringResources.getString("sign_up"),
                style = MaterialTheme.typography.labelLarge,
                color = Block
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Есть аккаунт? ",
                style = MaterialTheme.typography.labelLarge,
                color = Hint
            )
            TextButton(onClick = onLoginClick) {
                Text(
                    text = "Войти",
                    style = MaterialTheme.typography.labelLarge,
                    color = Text
                )
            }
        }
    }
} 