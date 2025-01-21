package com.example.weather.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.components.BottomBar
import com.example.weather.ui.theme.*
import com.example.weather.utils.AppIcons

@Composable
fun EditProfileScreen(
    onSaveClick: () -> Unit,
    onHomeClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    onCartClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Block)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(7.dp))

            // Кнопка "Сохранить"
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(212.dp, 32.dp)
                    .padding(horizontal = 61.dp)
                    .background(Accent, RoundedCornerShape(14.dp))
                    .clickable(onClick = onSaveClick),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Сохранить",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp,
                        color = Background
                    )
                )
            }

            Spacer(modifier = Modifier.height(43.dp))

            // Профиль пользователя
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(96.dp)
                        .clip(CircleShape)
                ) {
                    Image(
                        painter = AppIcons.UserProfile(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Emmanuel Oyiboke",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 20.sp,
                        color = Text
                    )
                )

                Spacer(modifier = Modifier.height(11.dp))

                Text(
                    text = "Изменить фото профиля",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 12.sp,
                        color = Accent
                    ),
                    modifier = Modifier.clickable { /* TODO: Implement photo picker */ }
                )
            }

            Spacer(modifier = Modifier.height(21.dp))

            // Поля профиля
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                // Имя
                Text(
                    text = "Имя",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Text
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Background, RoundedCornerShape(14.dp))
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Emmanuel",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 14.sp,
                                color = Text
                            ),
                            modifier = Modifier.padding(start = 16.dp, top = 13.dp, bottom = 21.dp)
                        )

                        Image(
                            painter = AppIcons.Done(),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Accent),
                            modifier = Modifier
                                .padding(end = 24.dp, top = 21.dp, bottom = 20.dp)
                                .size(10.dp, 7.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Фамилия
                Text(
                    text = "Фамилия",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Text
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Background, RoundedCornerShape(14.dp))
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Oyiboke",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 14.sp,
                                color = Text
                            ),
                            modifier = Modifier.padding(start = 16.dp, top = 13.dp, bottom = 21.dp)
                        )

                        Image(
                            painter = AppIcons.Done(),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Accent),
                            modifier = Modifier
                                .padding(end = 24.dp, top = 21.dp, bottom = 20.dp)
                                .size(10.dp, 7.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Адрес
                Text(
                    text = "Адрес",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Text
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Background, RoundedCornerShape(14.dp))
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Nigeria",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 14.sp,
                                color = Text
                            ),
                            modifier = Modifier.padding(start = 16.dp, top = 13.dp, bottom = 21.dp)
                        )

                        Image(
                            painter = AppIcons.Done(),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Accent),
                            modifier = Modifier
                                .padding(end = 24.dp, top = 21.dp, bottom = 20.dp)
                                .size(10.dp, 7.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Телефон
                Text(
                    text = "Телефон",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Text
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Background, RoundedCornerShape(14.dp))
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "+7 811-732-5298",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 14.sp,
                                color = Text
                            ),
                            modifier = Modifier.padding(start = 16.dp, top = 13.dp, bottom = 21.dp)
                        )

                        Image(
                            painter = AppIcons.Done(),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Accent),
                            modifier = Modifier
                                .padding(end = 24.dp, top = 21.dp, bottom = 20.dp)
                                .size(10.dp, 7.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(100.dp))
        }

        // Bottom Navigation Bar
        BottomBar(
            onHomeClick = onHomeClick,
            onFavoriteClick = onFavoriteClick,
            onCartClick = onCartClick,
            onNotificationClick = onNotificationClick,
            onProfileClick = onProfileClick,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
} 