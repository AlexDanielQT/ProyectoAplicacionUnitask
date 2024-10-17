package com.example.proyect.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    secondary = LightSecondary,
    background = LightBackground,
    surface = LightSurface,
    onPrimary = LightOnPrimary,
    onSecondary = LightOnSecondary,
    onBackground = LightOnPrimary,  // Color del texto sobre el fondo
    onSurface = LightOnPrimary      // Color del texto sobre superficies
)

@Composable
fun ProyectTheme(
    content: @Composable () -> Unit
) {
    val isDarkTheme = isSystemInDarkTheme()
    val colorScheme = if (isDarkTheme) darkColorScheme() else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
