package com.example.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ui.theme.*
import com.example.weather.utils.AppIcons

@Composable
fun CartItemCard(
    title: String,
    price: String,
    quantity: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        // Quantity controls
        Box(
            modifier = Modifier
                .width(58.dp)
                .height(104.dp)
                .background(Background)
                .padding(end = 10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = AppIcons.Plus(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(14.dp)
                        .padding(top = 14.dp),
                    colorFilter = ColorFilter.tint(Block)
                )
                
                Spacer(modifier = Modifier.height(23.dp))
                
                Text(
                    text = quantity.toString(),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp,
                        color = Block
                    )
                )
                
                Spacer(modifier = Modifier.height(23.dp))
                
                Image(
                    painter = AppIcons.Minus(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(14.dp)
                        .padding(bottom = 13.5.dp),
                    colorFilter = ColorFilter.tint(Block)
                )
            }
        }

        // Main card content
        Box(
            modifier = Modifier
                .width(335.dp)
                .height(104.dp)
                .background(Block, RoundedCornerShape(12.dp))
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(87.dp, 85.dp)
                        .background(Background)
                        .padding(10.dp)
                ) {
                    Image(
                        painter = AppIcons.BlueNike(),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 12.dp, bottom = 18.dp, end = 1.dp),
                        contentScale = ContentScale.Fit
                    )
                }
                
                Spacer(modifier = Modifier.width(20.dp))
                
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 13.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp,
                            color = Color(0xFF1A2530)
                        )
                    )
                    
                    Spacer(modifier = Modifier.height(6.dp))
                    
                    Text(
                        text = price,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 14.sp,
                            color = Color(0xFF1A2530)
                        )
                    )
                }
            }
        }

        // Delete button
        Box(
            modifier = Modifier
                .width(58.dp)
                .height(104.dp)
                .background(Color(0xFFF87265))
                .padding(start = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = AppIcons.Delete(),
                contentDescription = null,
                modifier = Modifier.size(18.dp, 20.dp),
                colorFilter = ColorFilter.tint(Block)
            )
        }
    }
} 