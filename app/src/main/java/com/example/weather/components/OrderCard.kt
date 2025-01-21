package com.example.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ui.theme.*
import com.example.weather.utils.AppIcons
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.ui.input.pointer.pointerInput

@Composable
fun OrderCard(
    orderNumber: String = "№ 325556516",
    title: String = "Nike Air Max 270 Essential",
    currentPrice: String = "$364.95",
    oldPrice: String = "$260.00",
    time: String = "7 мин назад",
    onDelete: () -> Unit = {},
    onEmail: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var offsetX by remember { mutableStateOf(0f) }
    var isSwipedLeft by remember { mutableStateOf(false) }
    var isSwipedRight by remember { mutableStateOf(false) }
    val swipeThreshold = 150f

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(105.dp)
    ) {
        // Левый контейнер (для email)
        if (isSwipedRight) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .width(58.dp)
                    .height(104.dp)
                    .background(Accent, RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = AppIcons.Email(),
                    contentDescription = "Email",
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(Block)
                )
            }
        }

        // Правый контейнер (для удаления)
        if (isSwipedLeft) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .width(58.dp)
                    .height(104.dp)
                    .background(Red, RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = AppIcons.Delete(),
                    contentDescription = "Удалить",
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(Block)
                )
            }
        }

        // Основная карточка
        Box(
            modifier = Modifier
                .offset { androidx.compose.ui.unit.IntOffset(offsetX.toInt(), 0) }
                .width(if (isSwipedLeft || isSwipedRight) 255.dp else 335.dp)
                .height(105.dp)
                .align(if (isSwipedRight) Alignment.CenterEnd else Alignment.CenterStart)
                .background(Block, RoundedCornerShape(8.dp))
                .pointerInput(Unit) {
                    detectHorizontalDragGestures(
                        onDragEnd = {
                            when {
                                offsetX < -swipeThreshold -> {
                                    isSwipedLeft = true
                                    isSwipedRight = false
                                    offsetX = -10f
                                }

                                offsetX > swipeThreshold -> {
                                    isSwipedRight = true
                                    isSwipedLeft = false
                                    offsetX = 10f
                                }

                                else -> {
                                    isSwipedLeft = false
                                    isSwipedRight = false
                                    offsetX = 0f
                                }
                            }
                        },
                        onDragCancel = {
                            offsetX = 0f
                            isSwipedLeft = false
                            isSwipedRight = false
                        },
                        onHorizontalDrag = { _, dragAmount ->
                            val newOffset = offsetX + dragAmount
                            offsetX = newOffset.coerceIn(-200f, 200f)
                        }
                    )
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(87.dp, 85.dp)
                        .background(Background, RoundedCornerShape(16.dp))
                        .padding(10.dp)
                ) {
                    Image(
                        painter = AppIcons.BlueNike(),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 12.dp, bottom = 18.dp),
                        contentScale = ContentScale.Fit
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 4.dp, bottom = 1.dp)
                ) {
                    if (!isSwipedLeft && !isSwipedRight) {
                        Text(
                            text = orderNumber,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 14.sp,
                                color = Accent
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(9.dp))

                    Text(
                        text = title,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 14.sp,
                            color = Text
                        )
                    )

                    Spacer(modifier = Modifier.height(9.dp))

                    Row {
                        Text(
                            text = currentPrice,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 14.sp,
                                color = Text
                            )
                        )

                        if (!isSwipedLeft && !isSwipedRight) {
                            Spacer(modifier = Modifier.width(39.dp))

                            Text(
                                text = oldPrice,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontSize = 14.sp,
                                    color = Hint
                                )
                            )
                        }
                    }
                }
            }
            if (!isSwipedLeft && !isSwipedRight) {
                Text(
                    text = time,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp,
                        color = Hint
                    ),
                    modifier = Modifier.padding(top = 10.dp, start = 270.dp).wrapContentHeight(Alignment.Top)
                )
            }
        }
    }
}