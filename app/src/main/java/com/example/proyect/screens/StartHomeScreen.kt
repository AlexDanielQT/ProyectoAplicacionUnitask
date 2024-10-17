package com.example.proyect.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.style.TextAlign
import com.example.proyect.components.CustomButton
import com.example.proyect.R
import com.example.proyect.ui.theme.LightOnPrimary

@Composable
fun StartHomeScreen(onNavigate: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background), // Fondo dinámico según el tema
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .size(width = 360.dp, height = 800.dp)
                .background(MaterialTheme.colorScheme.background), // Fondo dinámico según el tema
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "¡Listo! Hemos terminado.",
                fontSize = 30.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onPrimary, // Color de texto sobre fondo primario
                modifier = Modifier
                    .padding(top = 225.dp)
                    .wrapContentWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Imagen check_square
            Image(
                painter = painterResource(id = R.drawable.check_square),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "¡Todo está configurado! Estás listo para empezar a organizar tus actividades académicas",
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onPrimary, // Color de texto
                modifier = Modifier
                    .padding(horizontal = 44.dp)
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 50.dp), // Ajustar el margen
                contentAlignment = Alignment.Center
            ) {
                CustomButton(
                    text = "Iniciar",
                    onClick = onNavigate,
                    icon = R.drawable.arrow_right
                )
            }
        }
    }
}
