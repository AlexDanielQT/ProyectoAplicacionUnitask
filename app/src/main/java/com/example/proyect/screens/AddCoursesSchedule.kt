package com.example.proyect.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
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

@Composable
fun CursosHoraYAulaScreen(onBackClick: () -> Unit, onDoneClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFef7ff)), // Fondo color rosa
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
                color = Color.Black,
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

@Composable
fun SelectField(label: String, value: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = label, fontSize = 16.sp, color = Color.Black, fontWeight = FontWeight.Bold)
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
                    .background(Color.White)
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

@Composable
fun InputField(label: String, value: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = label, fontSize = 16.sp, color = Color.Black, fontWeight = FontWeight.Bold)
        OutlinedTextField(
            value = value,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color.White)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCursosHoraYAula() {
    CursosHoraYAulaScreen(onBackClick = {}, onDoneClick = {})
}
