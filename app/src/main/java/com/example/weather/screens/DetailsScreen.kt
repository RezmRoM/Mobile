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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ui.theme.*
import com.example.weather.utils.AppIcons

@Composable
fun DetailsScreen(
    onBackClick: () -> Unit,
    onCartClick: () -> Unit,
    onAddToCartClick: () -> Unit
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
                    .fillMaxWidth()
                    .padding(top = 16.dp),
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
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(Text)
                    )
                }

                Text(
                    text = "Sneaker Shop",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Text
                    )
                )

                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .background(Block, CircleShape)
                        .clickable(onClick = onCartClick),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = AppIcons.Bag(),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(Text)
                    )
                }
            }

            Spacer(modifier = Modifier.height(26.dp))

            // Title and Price Section
            Column {
                Text(
                    text = "Nike Air Max 270\nEssential",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 26.sp,
                        color = Text,
                        fontWeight = FontWeight.Bold
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Men's Shoes",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Hint
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "₽179.39",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 24.sp,
                        color = Text,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            // Nike Section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp, start = 12.dp, end = 12.dp)
            ) {
                // Main Nike Image
                Image(
                    painter = AppIcons.BlueNike(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(241.dp, 125.dp)
                        .align(Alignment.TopCenter),
                    contentScale = ContentScale.Fit
                )

                // Ellipse with Rectangle
                Box(
                    modifier = Modifier
                        .width(351.dp)
                        .height(68.dp)
                        .align(Alignment.Center)
                        .offset(y = 58.dp)
                ) {
                    Canvas(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        // Размеры эллипса
                        val ellipseWidth = size.width
                        val ellipseHeight = size.height

                        // Градиент: начинается с середины (прозрачный) и заканчивается внизу (#2363F6)
                        val gradientBrush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0x00000000), // #00000000 (полностью прозрачный)
                                Color(0xFF2363F6)  // #2363F6 (непрозрачный синий)
                            ),
                            startY = ellipseHeight / 2, // Начинается с середины
                            endY = ellipseHeight        // Заканчивается внизу
                        )

                        // Рисуем эллипс с градиентом
                        drawOval(
                            brush = gradientBrush, // Градиентная кисть
                            topLeft = Offset(0f, 0f), // Начальная точка (левый верхний угол)
                            size = Size(ellipseWidth, ellipseHeight), // Размеры эллипса
                            style = Stroke(width = 2.dp.toPx()) // Толщина границы
                        )
                    }

                    // Navigation Canvas with Rectangle
                    Box(
                        modifier = Modifier
                            .padding(top = 58.dp)
                            .align(Alignment.BottomCenter)
                    ) {
                        Canvas(
                            modifier = Modifier
                                .width(38.5.dp)
                                .height(18.dp)
                        ) {
                            drawRoundRect(
                                color = Hint,
                                size = Size(38.5.dp.toPx(), 18.dp.toPx()),
                                cornerRadius = androidx.compose.ui.geometry.CornerRadius(10.dp.toPx())
                            )
                        }

                        Row(
                            modifier = Modifier
                                .width(38.5.dp)
                                .height(18.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = AppIcons.ChevronLeft(),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(Block)
                            )
                            Image(
                                painter = AppIcons.ChevronLeft(),
                                contentDescription = null,
                                modifier = Modifier
                                    .rotate(180f),
                                colorFilter = ColorFilter.tint(Block)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(79.dp))

            // Thumbnail Cards
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(5) {
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .background(Block, RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = AppIcons.BlueNike(),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Description Section
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Вставка Max Air 270 Обеспечивает Непревзойденный Комфорт " +
                            "В Течение Всего Дня. Изящный Дизайн ........",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp,
                        lineHeight = 24.sp,
                        color = Hint
                    )
                )

                Spacer(modifier = Modifier.height(9.dp))

                Text(
                    text = "Подробнее",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp,
                        color = Accent
                    ),
                    modifier = Modifier
                        .align(Alignment.End)
                        .clickable { }
                )
            }

            Spacer(modifier = Modifier.height(60.dp))

            // Bottom Actions
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .background(Color(0xFFD9D9D9).copy(alpha = 0.4f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = AppIcons.HeartOutline(),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(Text)
                    )
                }

                Spacer(modifier = Modifier.width(18.dp))

                Button(
                    onClick = onAddToCartClick,
                    modifier = Modifier
                        .weight(1f)
                        .height(52.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Accent
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = AppIcons.Bag(),
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .padding(start = 12.dp),
                            colorFilter = ColorFilter.tint(Block)
                        )
                        Text(
                            text = "В Корзину",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 14.sp,
                                color = Block
                            ),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
} 