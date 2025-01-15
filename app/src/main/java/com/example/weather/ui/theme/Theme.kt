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
    background = Block,
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
    
    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = {
            SystemBarColors()
            content()
        }
    )
}

@Composable
private fun SystemBarColors() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colorScheme.surface.red * 0.299 + 
                      MaterialTheme.colorScheme.surface.green * 0.587 +
                      MaterialTheme.colorScheme.surface.blue * 0.114 > 0.5
    
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )
    }
}