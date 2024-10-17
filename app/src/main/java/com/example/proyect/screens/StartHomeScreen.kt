package com.example.proyect.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyect.components.CustomButton // Asegúrate de tener este componente implementado
import com.example.proyect.R // Importa tu archivo R para acceder a los recursos

@Composable
fun FinIntroduccion(onNavigate: () -> Unit) { // Parámetro para navegación
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFef7ff)), // Fondo color rosa
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .size(width = 360.dp, height = 800.dp)
                .background(Color(0xFFFef7ff)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "¡Listo! Hemos terminado.",
                fontSize = 30.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 225.dp)
                    .wrapContentWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp)) // Espacio entre el texto y la imagen

            // Imagen check_square
            Image(
                painter = painterResource(id = R.drawable.check_square), // Asegúrate de tener este ícono en tus recursos
                contentDescription = null, // Descripción para accesibilidad
                modifier = Modifier
                    .size(80.dp) // Ajusta el tamaño de la imagen según sea necesario
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp)) // Espacio entre la imagen y el siguiente texto

            Text(
                text = "¡Todo está configurado! Estás listo para empezar a organizar tus actividades académicas",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 44.dp)
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.weight(1f)) // Ocupa el espacio restante para empujar el botón hacia abajo

            Box(
                modifier = Modifier
                    .size(width = 178.dp, height = 63.dp)
                    .background(Color(0xFFD0BCFF), shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp))
                    .padding(1.dp)
            ) {
                CustomButton(
                    text = "Vamos Allá", // Texto del botón
                    onClick = onNavigate,
                    icon = R.drawable.arrow_right // Asegúrate de tener este icono en tus recursos
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFinIntroduccion() {
    FinIntroduccion(onNavigate = {})
}
