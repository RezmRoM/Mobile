package com.example.weather.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.components.BottomBar
import com.example.weather.components.OrderCard
import com.example.weather.ui.theme.*
import com.example.weather.utils.AppIcons

@Composable
fun OrdersScreen(
    onBackClick: () -> Unit,
    onHomeClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    onCartClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp)
        ) {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .background(Block, CircleShape)
                        .clickable(onClick = onBackClick),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = AppIcons.ChevronLeft(),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Text(
                    text = "Заказы",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Text
                    )
                )

                // Пустой Box для центрирования заголовка
                Box(modifier = Modifier.size(44.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Recent Orders Section
            Text(
                text = "Недавний",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 18.sp,
                    color = Text
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Recent Orders
            OrderCard(
                time = "7 мин назад"
            )

            Spacer(modifier = Modifier.height(12.dp))

            OrderCard(
                time = "7 мин назад"
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Yesterday Orders Section
            Text(
                text = "Вчера",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 18.sp,
                    color = Text
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Yesterday Orders
            repeat(3) {
                OrderCard(
                    time = "10:23"
                )
                if (it < 2) {
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
} 