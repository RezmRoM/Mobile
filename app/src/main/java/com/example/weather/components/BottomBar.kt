package com.example.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
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
    modifier: Modifier = Modifier
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
                contentDescription = "Home",
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(Color(0xFF48B2E7))
            )

            // Favorite Icon
            Image(
                painter = AppIcons.HeartOutline(),
                contentDescription = "Favorites",
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(SubTextDark)
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
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(Block)
                )
            }

            // Notification Icon
            Image(
                painter = AppIcons.Notification(),
                contentDescription = "Notifications",
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(SubTextDark)
            )

            // Profile Icon
            Image(
                painter = AppIcons.Profile(),
                contentDescription = "Profile",
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(SubTextDark)
            )
        }
    }
}