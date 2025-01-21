package com.example.weather.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ui.theme.*
import com.example.weather.utils.AppIcons

@Composable
fun SideMenuScreen(
    onProfileClick: () -> Unit,
    onCartClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    onOrdersClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Accent)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Accent)
        ) {
            // Профиль пользователя
            Column(
                modifier = Modifier
                    .padding(top = 30.dp, start = 35.dp)
                    .clickable(onClick = onProfileClick)
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

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "Эмануэль Кверти",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 20.sp,
                        color = Block,
                        fontFamily = FontFamily.Default // Замените на Raleway когда добавите шрифт
                    )
                )
            }

            // Меню навигации
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, top = 55.dp)
            ) {
                // Профиль
                Row(
                    modifier = Modifier
                        .width(204.dp)
                        .clickable(onClick = onProfileClick),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = AppIcons.Profile(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(25.dp))
                    Text(
                        text = "Профиль",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp,
                            color = Block
                        ),
                        modifier = Modifier.weight(1f)
                    )
                    Image(
                        painter = AppIcons.ChevronLeft(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block),
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                // Корзина
                Row(
                    modifier = Modifier
                        .width(204.dp)
                        .clickable(onClick = onCartClick),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = AppIcons.Bag(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(25.dp))
                    Text(
                        text = "Корзина",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp,
                            color = Block
                        ),
                        modifier = Modifier.weight(1f)
                    )
                    Image(
                        painter = AppIcons.ChevronLeft(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block),
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                // Избранное
                Row(
                    modifier = Modifier
                        .width(204.dp)
                        .clickable(onClick = onFavoriteClick),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = AppIcons.HeartOutline(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(25.dp))
                    Text(
                        text = "Избранное",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp,
                            color = Block
                        ),
                        modifier = Modifier.weight(1f)
                    )
                    Image(
                        painter = AppIcons.ChevronLeft(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block),
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                // Заказы
                Row(
                    modifier = Modifier
                        .width(204.dp)
                        .clickable(onClick = onOrdersClick),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = AppIcons.Delivery(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(25.dp))
                    Text(
                        text = "Заказы",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp,
                            color = Block
                        ),
                        modifier = Modifier.weight(1f)
                    )
                    Image(
                        painter = AppIcons.ChevronLeft(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block),
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                // Уведомления
                Row(
                    modifier = Modifier
                        .width(204.dp)
                        .clickable(onClick = onNotificationsClick),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = AppIcons.Notification(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(25.dp))
                    Text(
                        text = "Уведомления",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp,
                            color = Block
                        ),
                        modifier = Modifier.weight(1f)
                    )
                    Image(
                        painter = AppIcons.ChevronLeft(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block),
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                // Настройки
                Row(
                    modifier = Modifier
                        .width(204.dp)
                        .clickable(onClick = onSettingsClick),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = AppIcons.Settings(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(25.dp))
                    Text(
                        text = "Настройки",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp,
                            color = Block
                        ),
                        modifier = Modifier.weight(1f)
                    )
                    Image(
                        painter = AppIcons.ChevronLeft(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block),
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.height(37.dp))

                // Разделительная линия
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    thickness = 1.dp,
                    color = Color(0xF7F7F9).copy(alpha = 0.23f)
                )

                Spacer(modifier = Modifier.height(30.dp))

                // Выход
                Row(
                    modifier = Modifier
                        .width(204.dp)
                        .clickable(onClick = onLogoutClick),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = AppIcons.Logout(),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Block),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(25.dp))
                    Text(
                        text = "Выйти",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp,
                            color = Block
                        )
                    )
                }
            }
        }

        // Фоновое изображение
        Image(
            painter = AppIcons.HomeScreen(),
            contentDescription = null,
            modifier = Modifier
                .width(278.dp)
                .height(602.dp)
                .padding(top = 49.dp)
                .offset(x = 241.dp)
                .rotate(-3.43f)
                .clip(RoundedCornerShape(25.dp)),
            contentScale = ContentScale.Crop
        )
    }
} 