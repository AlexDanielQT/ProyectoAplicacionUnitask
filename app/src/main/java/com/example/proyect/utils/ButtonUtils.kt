package com.example.proyect.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.proyect.components.CustomButton

@Composable
fun ButtonUtils(
    text: String,
    onClick: () -> Unit,
    icon: Int? = null,
    modifier: Modifier = Modifier
) {
    CustomButton(
        text = text,
        onClick = onClick,
        icon = icon,
        modifier = modifier
    )
}
