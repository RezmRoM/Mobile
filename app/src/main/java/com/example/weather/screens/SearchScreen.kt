package com.example.weather.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.components.ProductCard
import com.example.weather.ui.theme.*
import com.example.weather.utils.AppIcons

@Composable
fun SearchScreen(
    onBackClick: () -> Unit
) {
    var searchText by remember { mutableStateOf("") }
    val showHistory = searchText.isEmpty()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(horizontal = 20.dp)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .background(Block, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = AppIcons.ChevronLeft(),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }

            Text(
                text = "Поиск",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    color = Text
                )
            )

            // Пустой Box для центрирования заголовка
            Box(modifier = Modifier.size(44.dp))
        }

        Spacer(modifier = Modifier.height(26.dp))

        // Search Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .background(Block, RoundedCornerShape(14.dp))
                .padding(start = 14.dp, end = 43.dp, top = 14.dp, bottom = 14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = AppIcons.Search(),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(Hint)
                )
                
                Spacer(modifier = Modifier.width(17.dp))
                
                BasicTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    textStyle = TextStyle(
                        fontSize = 12.sp,
                        color = Text
                    ),
                    modifier = Modifier.weight(1f),
                    decorationBox = { innerTextField ->
                        Box {
                            if (searchText.isEmpty()) {
                                Text(
                                    text = "Поиск",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        fontSize = 12.sp,
                                        color = Hint
                                    )
                                )
                            }
                            innerTextField()
                        }
                    }
                )
                
                Box(
                    modifier = Modifier
                        .width(1.5.dp)
                        .height(24.dp)
                        .background(SubTextDark)
                )
                
                Spacer(modifier = Modifier.width(12.dp))
                
                Image(
                    painter = AppIcons.Microphone(),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(Hint)
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        if (showHistory) {
            // Search History
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = AppIcons.Clock(),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(SubTextDark)
                )
                
                Spacer(modifier = Modifier.width(17.dp))
                
                Text(
                    text = "New Shoes",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp,
                        color = Text
                    )
                )
            }
        } else {
            // Search Results
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(8) {
                    ProductCard(
                        onCartClick = {},
                        rightIcon = {
                            Image(
                                painter = AppIcons.Plus(),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp),
                                colorFilter = ColorFilter.tint(Block)
                            )
                        },
                        heartIcon = {
                            Image(
                                painter = AppIcons.HeartFilled(),
                                contentDescription = null,
                                modifier = Modifier.size(16.dp),
                                colorFilter = ColorFilter.tint(Color(0xFFF87265))
                            )
                        }
                    )
                }
            }
        }
    }
} 