package com.example.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.weather.ui.theme.Accent
import com.example.weather.ui.theme.Background
import com.example.weather.ui.theme.Block
import com.example.weather.ui.theme.SubTextDark
import com.example.weather.utils.AppIcons

@Composable
fun BottomBar(
    onHomeClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    onCartClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onProfileClick: () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: String = ""
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(106.dp)
    ) {
        // Background Image
        Image(
            painter = AppIcons.BackgroundBNB(),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Row with Icons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .padding(bottom = 30.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Home Icon
            Image(
                painter = AppIcons.Home(),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clickable(onClick = onHomeClick),
                colorFilter = ColorFilter.tint(if (selectedIcon == "home") Accent else SubTextDark)
            )

            // Favorite Icon
            Image(
                painter = AppIcons.HeartOutline(),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clickable(onClick = onFavoriteClick),
                colorFilter = ColorFilter.tint(if (selectedIcon == "favorite") Accent else SubTextDark)
            )

            // Cart Icon
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(Color(0xFF48B2E7), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = AppIcons.Bag(),
                    contentDescription = "Cart",
                    modifier = Modifier.size(24.dp).clickable(onClick = onCartClick),
                    colorFilter = ColorFilter.tint(Block)
                )
            }

            // Notification Icon
            Image(
                painter = AppIcons.Notification(),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clickable(onClick = onNotificationClick),
                colorFilter = ColorFilter.tint(if (selectedIcon == "notification") Accent else SubTextDark)
            )

            // Profile Icon
            Image(
                painter = AppIcons.Profile(),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clickable(onClick = onProfileClick),
                colorFilter = ColorFilter.tint(if (selectedIcon == "profile") Accent else SubTextDark)
            )
        }
    }
}