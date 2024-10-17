package com.example.proyect.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.style.TextAlign
import com.example.proyect.R

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    icon: Int? = null, // Añadido: icono opcional
    modifier: Modifier = Modifier
) {
    val buttonColor = MaterialTheme.colorScheme.primary // Color de fondo del botón
    val textColor = MaterialTheme.colorScheme.onPrimary // Color del texto

    Box(
        modifier = modifier
            .background(buttonColor, shape = MaterialTheme.shapes.small) // Color de fondo
            .size(width = 190.dp, height = 70.dp) // Tamaño del botón
            .padding(0.dp) // Sin padding interno
            .border(0.5.dp, MaterialTheme.colorScheme.onSurface) // Borde de las horas
            .clickable(onClick = onClick), // Hacer clic
        contentAlignment = Alignment.Center // Alinear el contenido al centro
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, // Centrar verticalmente
            horizontalArrangement = Arrangement.SpaceBetween // Espacio entre elementos
        ) {
            Text(
                text = text,
                fontSize = 18.sp,
                color = textColor,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
            // Mostrar el icono solo si se proporciona
            icon?.let {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = null, // Se puede especificar un contenido descriptivo
                    modifier = Modifier
                        .size(40.dp) // Ajustar el tamaño según sea necesario
                        .padding(start = 8.dp) // Espacio entre el texto y el icono
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomButton() {
    CustomButton(
        text = "Comencemos",
        onClick = { /* Acción del botón */ },
        icon = R.drawable.arrow_right // Añadir el icono aquí para la vista previa
    )
}
