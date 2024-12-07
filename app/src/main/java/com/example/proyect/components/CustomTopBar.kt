package com.example.proyect.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.proyect.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(title: String, onClick: () -> Unit) {
    val topBarColor = MaterialTheme.colorScheme.primary
    val contentColor = MaterialTheme.colorScheme.onPrimary

    TopAppBar(
        title = {
            Text(text = title, color = contentColor)
        },
        navigationIcon = {
            IconButton(onClick = onClick) {
                Icon(
                    painter = painterResource(id = R.drawable.navbar),
                    contentDescription = "Abrir menú",
                    tint = contentColor // Color del ícono según el modo
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = topBarColor) // Color de la barra
    )
}
