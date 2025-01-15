package com.example.weather.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ui.theme.*
import com.example.weather.utils.AppIcons

@Composable
fun OnboardingFirstScreen(
    onNextClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF4882E7),
                        Color(0xFF0076B1)
                    ),
                )
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(29.dp))
            
            Text(
                text = "ДОБРО\nПОЖАЛОВАТЬ",
                style = MaterialTheme.typography.displayLarge.copy(
                    fontSize = 30.sp,
                    color = Block,
                    fontWeight = FontWeight.Black,
                ),
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(108.dp))
            
            Image(
                painter = AppIcons.BlueWhiteNike(),
                contentDescription = null,
                modifier = Modifier.size(375.dp, 302.dp),
                contentScale = ContentScale.Fit
            )
            
            Spacer(modifier = Modifier.height(26.dp))
            
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(43.dp)
                        .height(5.dp)
                        .background(Block, RoundedCornerShape(5.dp))
                )
                Box(
                    modifier = Modifier
                        .width(28.dp)
                        .height(5.dp)
                        .background(Disable, RoundedCornerShape(5.dp))
                )
                Box(
                    modifier = Modifier
                        .width(28.dp)
                        .height(5.dp)
                        .background(Disable, RoundedCornerShape(5.dp))
                )
            }
            
            Spacer(modifier = Modifier.height(136.dp))
            
            Button(
                onClick = onNextClick,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Block
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Начать",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp,
                        color = Text
                    )
                )
            }
        }
    }
} 