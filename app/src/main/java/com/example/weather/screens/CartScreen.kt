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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.components.SuccessOrderDialog
import com.example.weather.ui.theme.*
import com.example.weather.utils.AppIcons

@Composable
fun CartScreen(
    onBackClick: () -> Unit,
    onConfirmClick: () -> Unit,
    onMapClick: () -> Unit
) {
    var showSuccessDialog by remember { mutableStateOf(false) }
    var isEmailEditable by remember { mutableStateOf(false) }
    var isPhoneEditable by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(Block),
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

        Text(
                text = "Корзина",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    color = Text
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Surface(
            modifier = Modifier
                .width(335.dp)
                .wrapContentHeight(),
            shape = RoundedCornerShape(16.dp),
            color = Block
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                Text(
                    text = "Контактная информация",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp,
                        color = Text
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(Background, RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = AppIcons.Email(),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 12.dp)
                    ) {
                        Text(
                            text = if (isEmailEditable) "emmanuel@gmail.com" else "*******@****.***",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 14.sp,
                                color = Text
                            )
                        )
                        Text(
                            text = "Email",
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = 12.sp,
                                color = Hint
                            )
                        )
                    }
                    
                    IconButton(
                        onClick = { isEmailEditable = !isEmailEditable },
                        modifier = Modifier.size(20.dp)
                    ) {
                        Image(
                            painter = AppIcons.Edit(),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(Background, RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = AppIcons.Phone(),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 12.dp)
                    ) {
                        Text(
                            text = if (isPhoneEditable) "+234-811-732-5298" else "**-***-***-****",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 14.sp,
                                color = Text
                            )
                        )
                        Text(
                            text = "Телефон",
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = 12.sp,
                                color = Hint
                            )
                        )
                    }
                    
                    IconButton(
                        onClick = { isPhoneEditable = !isPhoneEditable },
                        modifier = Modifier.size(20.dp)
                    ) {
                        Image(
                            painter = AppIcons.Edit(),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Column {
        Text(
                        text = "Адрес",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 14.sp,
                            color = Text
                        )
                    )
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "1082 Аэропорт, Нигерии",
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = 12.sp,
                                color = Hint
                            )
                        )
                        Image(
                            painter = AppIcons.ChevronDown(),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                            .height(101.dp)
                            .clip(RoundedCornerShape(16.dp))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Black.copy(alpha = 0.33f))
        ) {
            Image(
                                painter = AppIcons.Map(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                                text = "Посмотреть на карте",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontSize = 20.sp,
                    color = Block
                                ),
                                modifier = Modifier.padding(top = 19.dp)
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .background(Accent, CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = AppIcons.Location(),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp),
                                    colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Column {
        Text(
                        text = "Способ оплаты",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 14.sp,
                            color = Text
                        )
                    )
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(Background, RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center
        ) {
            Image(
                                painter = AppIcons.Card(),
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
                        }
                        
            Column(
                modifier = Modifier
                    .weight(1f)
                                .padding(horizontal = 12.dp)
            ) {
                Text(
                                text = "DbL Card",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontSize = 14.sp,
                                    color = Text
                                )
                )
                Text(
                                text = "**** **** 0696 4629",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontSize = 12.sp,
                                    color = Hint
                                )
                            )
                        }
                        
                        Image(
                            painter = AppIcons.ChevronDown(),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                    .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                    text = "Сумма",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Hint
                    )
            )
            Text(
                    text = "₽753.95",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Text
                    )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                    .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                    text = "Доставка",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Hint
                    )
            )
            Text(
                    text = "₽60.20",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Text
                    )
                )
            }

            Text(
                text = "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    color = Hint.copy(alpha = 0.2f)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                    .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                    text = "Итого",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Text
                    )
            )
            Text(
                    text = "₽814.15",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Accent
                    )
                )
            }
            
            Spacer(modifier = Modifier.height(23.dp))

            Button(
                onClick = { showSuccessDialog = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Accent
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Подтвердить",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp,
                        color = Block
                    )
                )
            }
        }
    }

    if (showSuccessDialog) {
        SuccessOrderDialog(
            onBackToShopping = {
                showSuccessDialog = false
            }
        )
    }
} 