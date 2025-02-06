package com.example.weather.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weather.ui.theme.*
import com.example.weather.utils.AppIcons
import com.example.weather.utils.StringResources

@Preview(showBackground = true)
@Composable
fun AuthorizationScreenPreview () {
    AuthorizationScreen(
        onBackClick = {},
        onForgotPasswordClick = TODO(),
        onRegisterClick = TODO(),
        onLoginClick = TODO()
    )
}
@Composable
fun AuthorizationScreen(
    onBackClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onLoginClick: () -> Unit
) {
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
            text = buildAnnotatedString {
                append("Привет")
                withStyle(SpanStyle(fontStyle = FontStyle.Italic)) {
                    append("!")
                }
            },
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
                text = StringResources.getString("email"),
                style = MaterialTheme.typography.labelLarge,
                color = Text
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
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
        }
        
        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = StringResources.getString("password"),
                style = MaterialTheme.typography.labelLarge,
                color = Text
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
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
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = if (passwordVisible) AppIcons.Visibility() else AppIcons.VisibilityOff(),
                            contentDescription = if (passwordVisible) "Hide password" else "Show password",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
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
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = onForgotPasswordClick) {
                Text(
                    text = "Восстановить",
                    style = MaterialTheme.typography.bodySmall,
                    color = SubTextDark
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Accent
            )
        ) {
            Text(
                text = StringResources.getString("sign_in"),
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
                text = "Вы впервые? ",
                style = MaterialTheme.typography.labelLarge,
                color = Hint
            )
            TextButton(onClick = onRegisterClick) {
                Text(
                    text = "Создать пользователя",
                    style = MaterialTheme.typography.labelLarge,
                    color = Text
                )
            }
        }
    }
} 