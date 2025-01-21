package com.example.weather.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val LightColorScheme = lightColorScheme(
    primary = Accent,
    secondary = SubTextDark,
    tertiary = Red,
    background = Background,
    surface = Block,
    onPrimary = Block,
    onSecondary = Block,
    onTertiary = Block,
    onBackground = Text,
    onSurface = Text
)

@Composable
fun WeatherTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme
    val systemUiController = rememberSystemUiController()
    
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = true
        )
    }
    
    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}