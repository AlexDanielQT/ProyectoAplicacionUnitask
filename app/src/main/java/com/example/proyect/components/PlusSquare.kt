package com.example.proyect.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.proyect.R

@Composable
fun PlusSquare(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(40.dp) // Tamaño del botón
            .background(Color(0xFFD0BCFF), shape = MaterialTheme.shapes.small) // Color de fondo
            .clickable(onClick = onClick), // Acción de clic
        contentAlignment = Alignment.Center // Alinear el contenido al centro
    ) {
        Image(
            painter = painterResource(id = R.drawable.plus_square), // Asegúrate de tener este icono
            contentDescription = "Añadir curso", // Descripción para accesibilidad
            modifier = Modifier.size(24.dp) // Tamaño del icono
        )
    }
}
