package com.example.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ui.theme.*
import com.example.weather.utils.AppIcons

@Composable
fun ProductCard(
    title: String = "Nike Air Max",
    label: String = "BEST SELLER",
    price: String = "₽752.00",
    rightIcon: @Composable () -> Unit,
    onCartClick: () -> Unit,
    modifier: Modifier = Modifier,
    heartIcon: @Composable () -> Unit = { 
        Image(
            painter = AppIcons.HeartOutline(),
            contentDescription = null,
            modifier = Modifier.size(16.dp),
            colorFilter = ColorFilter.tint(Text)
        )
    }
) {
    Box(
        modifier = modifier
            .width(160.dp)
            .height(220.dp)
            .background(Block, RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(top = 18.dp)
            ) {
                Image(
                    painter = AppIcons.BlueNike(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .align(Alignment.Center),
                    contentScale = ContentScale.Fit
                )
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Column {
                Text(
                    text = label,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 12.sp,
                        color = Accent,
                        fontWeight = FontWeight.Medium
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = Hint,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(start = 9.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Text(
                text = price,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp,
                    color = Text,
                    fontWeight = FontWeight.Bold,
                )
            )

            Box(
                modifier = Modifier
                    .size(34.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp))
                    .background(Accent),
                contentAlignment = Alignment.Center
            ) {
                rightIcon()
            }
        }
        
        Box(
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.TopStart)
                .offset(x = 12.dp, y = 12.dp)
                .background(Background, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            heartIcon()
        }
    }
}