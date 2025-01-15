package com.example.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.weather.ui.theme.*
import com.example.weather.utils.AppIcons

@Composable
fun SuccessOrderDialog(
    onBackToShopping: () -> Unit
) {
    Dialog(
        onDismissRequest = onBackToShopping
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable(onClick = onBackToShopping),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .width(335.dp)
                    .height(400.dp)
                    .background(Block, RoundedCornerShape(16.dp)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(40.dp))

                Box(
                    modifier = Modifier
                        .size(159.dp, 242.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(134.dp)
                                .background(Color(0xFFDFEFFF), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = AppIcons.OrderingSuccess(),
                                contentDescription = null,
                                modifier = Modifier.size(86.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Вы успешно\nоформили\nзаказ",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 20.sp,
                                color = Text
                            ),
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = onBackToShopping,
                    modifier = Modifier
                        .width(237.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF48B2E7)
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "Вернуться к покупкам",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 14.sp,
                            color = Block
                        )
                    )
                }
            }
        }
    }
} 