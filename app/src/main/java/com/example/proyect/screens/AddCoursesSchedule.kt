package com.example.proyect.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import com.example.proyect.R
import com.example.proyect.utils.ButtonUtils

val LightPrimary = Color(0xFFF5F5F5)
val LightSecondary = Color(0xFFE8E8E8)
val LightTertiary = Color(0xFFDFDFDF)
val LightOnPrimary = Color(0xFF333333)
val LightOnSecondary = Color(0xFF555555)
val LightOnTertiary = Color(0xFF777777)
val LightBackground = Color(0xFFFFFFFF)
val LightSurface = Color(0xFFF1F1F1)

val DarkPrimary = Color(0xFF3F1E64)
val DarkSecondary = Color(0xFF4F2B7A)
val DarkTertiary = Color(0xFF5F3C91)
val DarkOnPrimary = Color(0xFFD0A7FF)
val DarkOnSecondary = Color(0xFFD1A3FF)
val DarkOnTertiary = Color(0xFFD8B2FF)
val DarkBackground = Color(0xFF2A1A55)
val DarkSurface = Color(0xFF3C2143)
val DarkOnBackground = Color(0xFFD0A7FF)
val DarkOnSurface = Color(0xFFD1A3FF)

@Composable
fun CursosHoraYAulaScreen(onBackClick: () -> Unit, onDoneClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBackground), // Fondo
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .width(360.dp)
                .padding(horizontal = 30.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            // Texto de información
            Text(
                text = "Por favor, ingresa la información del curso y horarios",
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = LightOnPrimary, // Color del texto
                modifier = Modifier.padding(top = 30.dp), // Ajustado para más espacio
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Campos de selección
            SelectField(label = "Curso", value = "Física")
            Spacer(modifier = Modifier.height(16.dp))

            SelectField(label = "Desde", value = "7:00 am")
            Spacer(modifier = Modifier.height(16.dp))

            SelectField(label = "Hasta", value = "9:00 am")
            Spacer(modifier = Modifier.height(16.dp))

            // Campo de entrada para Aula
            InputField(label = "Aula", value = "301")

            Spacer(modifier = Modifier.weight(1f)) // Espacio flexible para alinear el botón

            // Botón "Hecho" al fondo
            ButtonUtils(
                text = "Hecho", // Texto del botón
                onClick = onDoneClick, // Lógica para finalizar
                icon = R.drawable.arrow_right // Icono opcional
            )
        }

        // Icono de flecha izquierda (regresar) en la parte superior izquierda
        Image(
            painter = painterResource(id = R.drawable.arrow_left),
            contentDescription = "Regresar",
            modifier = Modifier
                .size(70.dp)
                .padding(start = 20.dp, top = 30.dp) // Margen de 20px a la izquierda y 30px arriba
                .clickable { onBackClick() }
                .align(Alignment.TopStart) // Alinear al extremo superior izquierdo
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class) // Aquí habilitas el uso de APIs experimentales

@Composable
fun SelectField(label: String, value: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            color = LightOnPrimary, // Usa el color definido en LightOnPrimary
            fontWeight = FontWeight.Bold
        )
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = value,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(end = 40.dp) // Espacio para el icono a la derecha
                    .background(LightSurface), // Usa el color de surface (LightSurface)
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = LightSecondary, // Usa LightSecondary
                    unfocusedBorderColor = LightTertiary // Usa LightTertiary
                )
            )
            // Imagen chevron_down dentro del campo
            Image(
                painter = painterResource(id = R.drawable.chevron_down),
                contentDescription = "Dropdown",
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterEnd) // Alinear al final (derecha) del Box
                    .padding(end = 8.dp) // Espacio de separación del borde
                    .clickable { /* Acción del ícono */ } // Puedes agregar una acción si es necesario
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(label: String, value: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            color = LightOnPrimary, // Color para los textos
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = value,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(LightSurface), // Color de fondo para el campo
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = LightSecondary, // Borde del campo enfocado
                unfocusedBorderColor = LightTertiary // Borde cuando no está enfocado
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCursosHoraYAula() {
    CursosHoraYAulaScreen(onBackClick = {}, onDoneClick = {})
}
