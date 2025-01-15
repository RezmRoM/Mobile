package com.example.weather.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ui.theme.*
import com.example.weather.utils.AppIcons
import com.example.weather.utils.StringResources
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("DefaultLocale")
@Composable
fun OtpVerificationScreen(
    onBackClick: () -> Unit,
    onVerifyClick: () -> Unit,
    onResendClick: () -> Unit
) {
    var otpValues by remember { mutableStateOf(List(6) { "" }) }
    var focusedIndex by remember { mutableStateOf(0) }
    var timeLeft by remember { mutableStateOf(30) }
    var canResend by remember { mutableStateOf(false) }
    var hasError by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val focusRequesters = remember { List(6) { FocusRequester() } }

    LaunchedEffect(Unit) {
        while (timeLeft > 0) {
            delay(1000)
            timeLeft--
            if (timeLeft == 0) {
                hasError = otpValues.any { it.isEmpty() }
                if (hasError) {
                    otpValues = List(6) { "0" }
                }
            }
        }
        canResend = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

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
            text = StringResources.getString("otp_verification"),
            style = MaterialTheme.typography.displayLarge
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = StringResources.getString("check_email_verification"),
            style = MaterialTheme.typography.bodyMedium.copy(textAlign = TextAlign.Center),
            color = SubTextDark
        )
        
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "OTP Код",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 21.sp,
                color = Text
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            otpValues.forEachIndexed { index, value ->
                val isFocused = index == focusedIndex
                val isError = hasError || (timeLeft == 0 && value != "0")
                
                Box(
                    modifier = Modifier
                        .width(46.dp)
                        .height(99.dp)
                        .background (Background,
                            RoundedCornerShape(12.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = when {
                                isError -> Color(0xFFF87265)
                                isFocused -> Accent
                                else -> Color.Transparent
                            },
                            shape = RoundedCornerShape(12.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    BasicTextField(
                        value = value,
                        onValueChange = { newValue ->
                            if (newValue.length <= 1 && newValue.all { it.isDigit() }) {
                                val newOtpValues = otpValues.toMutableList()
                                newOtpValues[index] = newValue
                                otpValues = newOtpValues
                                
                                if (newValue.isNotEmpty() && index < otpValues.size - 1) {
                                    focusedIndex = index + 1
                                    focusRequesters[index + 1].requestFocus()
                                }
                                
                                hasError = false
                                
                                if (otpValues.all { it.isNotEmpty() }) {
                                    onVerifyClick()
                                }
                            } else if (newValue.isEmpty() && index > 0) {
                                val newOtpValues = otpValues.toMutableList()
                                newOtpValues[index] = ""
                                otpValues = newOtpValues
                                focusedIndex = index - 1
                                focusRequesters[index - 1].requestFocus()
                            }
                        },
                        textStyle = MaterialTheme.typography.headlineSmall.copy(
                            fontSize = 18.sp,
                            color = Text,
                            textAlign = TextAlign.Center
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = if (index == 5) ImeAction.Done else ImeAction.Next
                        ),
                        singleLine = true,
                        modifier = Modifier
                            .wrapContentSize(Alignment.Center)
                            .focusRequester(focusRequesters[index])
                            .onKeyEvent { keyEvent ->
                                if (keyEvent.nativeKeyEvent.keyCode == android.view.KeyEvent.KEYCODE_DEL && value.isEmpty() && index > 0) {
                                    focusedIndex = index - 1
                                    focusRequesters[index - 1].requestFocus()
                                    true
                                } else {
                                    false
                                }
                            }
                            .onFocusChanged { focusState ->
                                if (focusState.isFocused) {
                                    focusedIndex = index
                                }
                            }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(
                onClick = {
                    if (canResend) {
                        hasError = false
                        otpValues = List(6) { "" }
                        timeLeft = 30
                        canResend = false
                        onResendClick()
                        scope.launch {
                            while (timeLeft > 0) {
                                delay(1000)
                                timeLeft--
                            }
                            canResend = true
                        }
                    }
                },
                enabled = canResend
            ) {
                Text(
                    text = "Отправить заново",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = 12.sp,
                        color = if (canResend) SubTextDark else SubTextDark.copy(alpha = 0.5f)
                    )
                )
            }
            Text(
                text = String.format("%02d:%02d", timeLeft / 60, timeLeft % 60),
                style = MaterialTheme.typography.labelSmall.copy(
                    fontSize = 12.sp,
                    color = SubTextDark
                )
            )
        }
    }
} 