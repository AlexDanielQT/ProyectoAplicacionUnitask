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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyect.components.CustomButton // Asegúrate de tener este componente implementado
import com.example.proyect.R // Importa tu archivo R para acceder a los recursos

@Composable
fun WelcomeScreen(onNavigate: () -> Unit) { // Parámetro para navegación
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
                text = "¡Bienvenido!",
                fontSize = 30.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 180.dp)
                    .wrapContentWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(125.dp)) // Espacio para el párrafo

            Text(
                text = "Esta aplicación está diseñada para ayudarte a gestionar tus tareas y proyectos universitarios de manera eficiente. \nEsperamos que disfrutes la experiencia.",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 59.dp)
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.weight(1f)) // Ocupa el espacio restante para empujar el botón hacia abajo

            Spacer(modifier = Modifier.height(70.dp)) // Separación de 70 píxeles antes del botón

            Box(
                modifier = Modifier
                    .size(width = 190.dp, height = 70.dp)
                    .padding(1.dp)
                    .background(Color.White) // Color de fondo opcional
            ) {
                // Botón que incluye el texto y el icono
                CustomButton(
                    text = "Comencemos", // Texto del botón
                    onClick = onNavigate,
                    icon = R.drawable.arrow_right // Pasar el id del icono aquí
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewWelcomeScreen() {
    WelcomeScreen(onNavigate = {})
}
