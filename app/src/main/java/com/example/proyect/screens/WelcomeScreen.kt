package com.example.proyect.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.isSystemInDarkTheme
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
import com.example.proyect.ui.theme.ProyectTheme
import com.example.proyect.ui.theme.*

@Composable
fun WelcomeScreen(onNavigate: () -> Unit) {
    ProyectTheme { // Aplicar el tema de colores
        val backgroundColor = LightBackground
        val textColor = LightOnPrimary

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor), // Fondo fijo
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .size(width = 360.dp, height = 800.dp)
                    .background(backgroundColor), // Fondo fijo
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = "¡Bienvenido!",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Normal,
                    color = textColor, // Color del texto fijo
                    modifier = Modifier
                        .padding(top = 180.dp)
                        .wrapContentWidth(),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(125.dp))

                Text(
                    text = "Esta aplicación está diseñada para ayudarte a gestionar tus tareas y proyectos universitarios de manera eficiente. \nEsperamos que disfrutes la experiencia.",
                    fontSize = 18.sp,
                    color = textColor, // Color del texto fijo
                    modifier = Modifier
                        .padding(horizontal = 59.dp)
                        .wrapContentWidth()
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.weight(1f))

                Spacer(modifier = Modifier.height(70.dp))

                Box(
                    modifier = Modifier
                        .size(width = 190.dp, height = 70.dp)
                        .padding(1.dp)
                        .background(Color.White)

                ) {
                    CustomButton(
                        text = "Comencemos",
                        onClick = onNavigate,
                        icon = R.drawable.arrow_right

                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWelcomeScreen() {
    WelcomeScreen(onNavigate = {})
}
