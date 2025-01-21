package com.example.weather.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.components.BottomBar
import com.example.weather.components.NotificationItem
import com.example.weather.ui.theme.*
import com.example.weather.utils.AppIcons

@Composable
fun NotificationScreen(
    onMenuClick: () -> Unit,
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
                .padding(top = 8.dp)
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
                        .padding(start = 9.dp)
                        .size(24.dp)
                        .clickable(onClick = onMenuClick)
                )

                Text(
                    text = "Уведомления",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Text
                    )
                )

                // Пустой Box для центрирования заголовка
                Box(modifier = Modifier.size(24.dp))
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Notifications List
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                repeat(5) {
                    NotificationItem(
                        title = "Заголовок",
                        description = "Lorem ipsum dolor sit amet consectetur. Venenatis pulvinar lobortis risus consectetur morbi egestas id in bibendum. Volutpat nulla urna sit sed diam nulla.",
                        date = "27.01.2024, 15:42"
                    )
                }
            }

            Spacer(modifier = Modifier.height(80.dp))
        }

        // Bottom Navigation Bar
        BottomBar(
            onHomeClick = onHomeClick,
            onFavoriteClick = onFavoriteClick,
            onCartClick = onCartClick,
            onNotificationClick = onNotificationClick,
            onProfileClick = onProfileClick,
            modifier = Modifier.align(Alignment.BottomCenter),
            selectedIcon = "notification"
        )
    }
} 