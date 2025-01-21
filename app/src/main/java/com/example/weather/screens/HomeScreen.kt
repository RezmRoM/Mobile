package com.example.weather.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.components.BottomBar
import com.example.weather.components.ProductCard
import com.example.weather.ui.theme.*
import com.example.weather.utils.AppIcons
import androidx.navigation.NavController
import com.example.weather.navigation.Screen

@Composable
fun HomeScreen(
    onCartClick: () -> Unit,
    onAllClick: () -> Unit,
    onHomeClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onProfileClick: () -> Unit,
    onSearchClick: () -> Unit,
    onMenuClick: () -> Unit,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
                .padding(bottom = 106.dp)
        ) {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
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
                    text = "Главная",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 32.sp,
                        color = Text,
                        fontWeight = FontWeight.Bold
                    )
                )

                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .background(Block, CircleShape)
                        .clickable(onClick = onCartClick),
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        painter = AppIcons.Bag(),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(Text)
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Search
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .background(Block, RoundedCornerShape(14.dp))
                    .clickable(onClick = onSearchClick)
                    .padding(horizontal = 14.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = AppIcons.Search(),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(Hint)
                    )
                    
                    Spacer(modifier = Modifier.width(17.dp))
                    
                    Text(
                        text = "Поиск",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 12.sp,
                            color = Hint
                        )
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Categories
            Text(
                text = "Категории",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    color = Text,
                    fontWeight = FontWeight.SemiBold
                )
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                val categories = listOf("Все", "Outdoor", "Tennis", "Running")
                items(categories.size) { index ->
                    Box(
                        modifier = Modifier
                            .width(108.dp)
                            .height(40.dp)
                            .background(Block, RoundedCornerShape(12.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = categories[index],
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 14.sp,
                                color = Text
                            )
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Popular
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Популярное",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Text
                    )
                )
                
                Text(
                    text = "Все",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 12.sp,
                        color = Accent
                    ),
                    modifier = Modifier.clickable { onAllClick() }
                )
            }
            
            Spacer(modifier = Modifier.height(30.dp))
            
            // Products
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ProductCard(
                    onCartClick = {},
                    onDetailsClick = { navController.navigate(Screen.Details.route) },
                    rightIcon = {
                        Image(
                            painter = AppIcons.Plus(),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            colorFilter = ColorFilter.tint(Block)
                        )
                    }
                )
                Spacer(modifier = Modifier.width(15.dp))

                ProductCard(
                    onCartClick = onCartClick,
                    onDetailsClick = { navController.navigate(Screen.Details.route) },
                    rightIcon = {
                        Image(
                            painter = AppIcons.Cart(),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            colorFilter = ColorFilter.tint(Block)
                        )
                    }
                )
            }
            
            Spacer(modifier = Modifier.height(29.dp))
            
            // Sales
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Акции",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Text
                    )
                )
                Text(
                    text = "Все",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 12.sp,
                        color = Accent
                    )
                )
            }
            
            Spacer(modifier = Modifier.height(20.dp))
            
            Image(
                painter = AppIcons.Sale(),
                contentDescription = null,
                modifier = Modifier.size(335.dp, 95.dp)
            )
        }
        
        // Bottom Bar
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
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
} 