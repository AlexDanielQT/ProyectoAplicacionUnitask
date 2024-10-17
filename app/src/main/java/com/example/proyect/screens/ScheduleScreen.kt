package com.example.proyect.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyect.R
import com.example.proyect.utils.ButtonUtils

@Composable
fun ScheduleScreen(onBackClick: () -> Unit, onDoneClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFef7ff)), // Fondo color rosa
    ) {
        // Icono de flecha izquierda (regresar)
        Image(
            painter = painterResource(id = R.drawable.arrow_left),
            contentDescription = "Back",
            modifier = Modifier
                .size(65.dp)
                .padding(start = 20.dp, top = 30.dp) // Margen de 20px a la izquierda y 30px arriba
                .clickable { onBackClick() }
                .align(Alignment.TopStart) // Alinear al extremo superior izquierdo
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp, vertical = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Box para el texto de información
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp) // Espacio entre el texto y el horario
            ) {
                Text(
                    text = "A continuación, configuraremos tu horario académico de manera rápida y sencilla",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 30.dp),
                    textAlign = TextAlign.Center
                )
            }

            // Crear la cuadrícula del horario en un Box separado
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f) // Ocupa el espacio disponible
            ) {
                ScheduleGrid()
            }

            // Alinear el botón "Continuar" al fondo
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 25.dp, top = 20.dp), // Este padding establece el margen inferior deseado
                contentAlignment = Alignment.BottomCenter // Centramos el botón
            ) {
                ButtonUtils(
                    text = "Continuar", // Texto del botón
                    onClick = onDoneClick, // Lógica para continuar
                    icon = R.drawable.arrow_right // Icono opcional
                )
            }
        }
    }
}

@Composable
fun ScheduleGrid() {
    Row(modifier = Modifier.fillMaxWidth()) {
        // Mostrar horas a la izquierda
        LazyColumn(modifier = Modifier.weight(1f)) {
            val times = listOf("09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00")
            items(times) { time ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth() // Asegúrate de que la columna ocupe todo el ancho
                        .padding(vertical = 8.dp) // Espacio vertical entre los horarios
                ) {
                    Text(
                        text = time,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFFB1B1B1),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Divider(color = Color(0xFFB1B1B1), thickness = 1.dp) // Línea que abarca todo el ancho
            }
        }

        // Desplazamiento horizontal para los días de la semana
        LazyRow(modifier = Modifier.weight(3f)) {
            val days = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
            items(days) { day ->
                Column(
                    modifier = Modifier
                        .width(100.dp) // Ancho fijo para cada columna de día
                        .padding(start = 8.dp, end = 8.dp)
                ) {
                    Text(
                        text = day,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFFB1B1B1),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f)
                    )
                }
                // Aquí agregamos el Divider que abarque todo el alto
                Divider(
                    color = Color(0xFFB1B1B1),
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxHeight() // Asegura que el Divider ocupe toda la altura
                        .width(1.dp) // Ancho del Divider
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640) // Tamaño específico para la vista previa
@Composable
fun ScheduleScreenPreview() {
    ScheduleScreen(
        onBackClick = { /* Acción para volver */ },
        onDoneClick = { /* Acción para "Continuar" */ }
    )
}
