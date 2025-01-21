package com.example.weather.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ui.theme.*

@Composable
fun NotificationItem(
    title: String,
    description: String,
    date: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(335.dp, 128.dp)
            .background(Background, RoundedCornerShape(14.dp))
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    color = Text
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 12.sp,
                    color = Text
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = date,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 12.sp,
                    color = SubTextDark
                )
            )
        }
    }
} 