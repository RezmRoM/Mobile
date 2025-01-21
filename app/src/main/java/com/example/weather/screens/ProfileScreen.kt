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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.components.BottomBar
import com.example.weather.ui.theme.*
import com.example.weather.utils.AppIcons

@Composable
fun ProfileScreen(
    onMenuClick: () -> Unit,
    onEditClick: () -> Unit,
    onOrdersClick: () -> Unit,
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
                .padding(horizontal = 12.dp)
                .padding(top = 12.dp)
                .verticalScroll(rememberScrollState()) // Добавляем вертикальный скроллинг
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = AppIcons.Menu(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(onClick = onMenuClick)
                )

                Text(
                    text = "Профиль",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Text
                    )
                )

                Box(
                    modifier = Modifier
                        .size(25.dp)
                        .background(Accent, CircleShape)
                        .clickable(onClick = onEditClick),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = AppIcons.Edit(),
                        contentDescription = null,
                        modifier = Modifier.size(14.dp),
                        colorFilter = ColorFilter.tint(Block)
                    )
                }
            }

            Spacer(modifier = Modifier.height(45.dp))

            // Profile Image and Name
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
            }

            Spacer(modifier = Modifier.height(38.dp))

            // Barcode
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Background, RoundedCornerShape(16.dp))
                    .padding(horizontal = 8.dp)
                    .size(335.dp, 67.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Открыть",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 12.sp,
                            color = Text
                        ),
                        modifier = Modifier.rotate(-90f)
                    )

                    Image(
                        painter = AppIcons.BarCode(),
                        contentDescription = null,
                        modifier = Modifier
                            .size(297.dp, 51.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }

            Spacer(modifier = Modifier.height(19.dp))

            // Profile Fields
            Column {
                // First Name
                Text(
                    text = "Имя",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Text
                    )
                )

                Spacer(modifier = Modifier.height(19.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Background, RoundedCornerShape(14.dp))
                        .padding(start = 16.dp, top = 14.dp, bottom = 20.dp)
                ) {
                    Text(
                        text = "Emmanuel",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 14.sp,
                            color = Text
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Last Name
                Text(
                    text = "Фамилия",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Text
                    )
                )

                Spacer(modifier = Modifier.height(19.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Background, RoundedCornerShape(14.dp))
                        .padding(start = 16.dp, top = 14.dp, bottom = 20.dp)
                ) {
                    Text(
                        text = "Oyiboke",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 14.sp,
                            color = Text
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Address
                Text(
                    text = "Адрес",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Text
                    )
                )

                Spacer(modifier = Modifier.height(19.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Background, RoundedCornerShape(14.dp))
                        .padding(start = 16.dp, top = 14.dp, bottom = 20.dp)
                ) {
                    Text(
                        text = "Nigeria",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 14.sp,
                            color = Text
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Phone
                Text(
                    text = "Телефон",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Text
                    )
                )

                Spacer(modifier = Modifier.height(19.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Background, RoundedCornerShape(14.dp))
                        .padding(start = 16.dp, top = 14.dp, bottom = 20.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier.clickable { /* TODO: Show country code picker */ },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "+234",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontSize = 16.sp,
                                    color = Hint
                                )
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Image(
                                painter = AppIcons.ChevronDown(),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp),
                                colorFilter = ColorFilter.tint(Text)
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "811-732-5298",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 14.sp,
                                color = Text
                            )
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