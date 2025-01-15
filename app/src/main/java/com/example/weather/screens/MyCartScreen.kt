package com.example.weather.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.components.CartItemCard
import com.example.weather.ui.theme.*
import com.example.weather.utils.AppIcons

@Composable
fun MyCartScreen(
    onBackClick: () -> Unit,
    onCheckoutClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        // Column for header and cart items with horizontal padding
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .align(Alignment.TopCenter)
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
                        modifier = Modifier.size(24.dp)
                    )
                }

                Text(
                    text = "Корзина",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Text
                    )
                )

                // Empty Box for centering the title
                Box(modifier = Modifier.size(44.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "3 товара",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    color = Text
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Cart items
            CartItemCard(
                title = "Nike Club Max",
                price = "₽584.95",
                quantity = 1,
                onIncrement = { },
                onDecrement = { },
                onDelete = { }
            )

            Spacer(modifier = Modifier.height(8.dp))

            CartItemCard(
                title = "Nike Air Max 200",
                price = "₽94.05",
                quantity = 1,
                onIncrement = { },
                onDecrement = { },
                onDelete = { }
            )

            Spacer(modifier = Modifier.height(8.dp))

            CartItemCard(
                title = "Nike Air Max 270 Essential",
                price = "₽74.95",
                quantity = 1,
                onIncrement = { },
                onDecrement = { },
                onDelete = { }
            )

            Spacer(modifier = Modifier.weight(1f))
        }

        // Summary block at the bottom
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(258.dp)
                .background(Block)
                .align(Alignment.BottomCenter)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Сумма",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp,
                            color = SubTextDark
                        )
                    )
                    Text(
                        text = "₽753.95",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp,
                            color = Text
                        )
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Доставка",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp,
                            color = SubTextDark
                        )
                    )
                    Text(
                        text = "₽60.20",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp,
                            color = Text
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Dashed line
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(SubTextDark)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Итого",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp,
                            color = Text
                        )
                    )
                    Text(
                        text = "₽814.15",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp,
                            color = Accent
                        )
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = onCheckoutClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Accent,
                    ),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(
                        text = "Оформить заказ",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 14.sp,
                            color = Background
                        )
                    )
                }
            }
        }
    }
}