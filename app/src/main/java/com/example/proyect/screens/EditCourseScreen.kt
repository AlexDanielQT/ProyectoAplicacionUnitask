package com.example.proyect.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyect.R
import com.example.proyect.utils.ButtonUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditCourseScreen(onDoneClick: () -> Unit) {
    var selectedCourse by remember { mutableStateOf("Cálculo") }
    var selectedTeacher by remember { mutableStateOf("Elvis") }
    var selectedCredits by remember { mutableStateOf("1") }
    var startTime by remember { mutableStateOf("7:00 AM") }
    var endTime by remember { mutableStateOf("9:00 AM") }
    var selectedDays by remember { mutableStateOf(setOf<Int>()) } // Para mantener el estado de los días seleccionados


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFef7ff)) // Color de fondo
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(bottom = 80.dp),  // Espacio para el botón
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Icono de volver
            Icon(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = "Volver",
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Start)
                    .padding(top = 16.dp)
                    .background(Color(0xFFD0BCFF), shape = MaterialTheme.shapes.small)

            )

            Spacer(modifier = Modifier.height(30.dp))

            // Campo de curso
            Text(text = "Curso", textAlign = TextAlign.Left, modifier = Modifier.fillMaxWidth())
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = selectedCourse)
                    Icon(
                        painter = painterResource(id = R.drawable.chevron_down),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Campo de docente
            Text(text = "Docente", textAlign = TextAlign.Left, modifier = Modifier.fillMaxWidth())
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = selectedTeacher)
                    Icon(
                        painter = painterResource(id = R.drawable.chevron_down),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Campo de créditos
            Text(text = "Créditos", textAlign = TextAlign.Left, modifier = Modifier.fillMaxWidth())
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = selectedCredits)
                    Icon(
                        painter = painterResource(id = R.drawable.chevron_down),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Días", textAlign = TextAlign.Left, modifier = Modifier.fillMaxWidth())
            Box(
                Modifier.background(Color(0xFFD0BCFF), shape = MaterialTheme.shapes.small)
            ){
                DaysSelector(selectedDays = selectedDays, onDaySelected = { dayIndex ->
                    selectedDays = selectedDays.toMutableSet().apply {
                        if (contains(dayIndex)) remove(dayIndex) else add(dayIndex) // Alternar selección
                    }
                })
            }

            // Campo de hora de inicio
            Text(text = "Desde", textAlign = TextAlign.Left, modifier = Modifier.fillMaxWidth())
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = startTime)
                    Icon(
                        painter = painterResource(id = R.drawable.chevron_down),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Mostrar Horas de Inicio y Fin
            Text(text = "Horas", textAlign = TextAlign.Left, modifier = Modifier.fillMaxWidth())
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                TimeBoxx(time = "9:00 AM")
                Icon(
                    painter = painterResource(id = R.drawable.chevron_down),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                TimeBoxx(time = "10:00 AM")
                Icon(
                    painter = painterResource(id = R.drawable.chevron_down),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
        }

        // Botón de confirmar, centrado y con padding adecuado
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 65.dp)  // A 65px del límite inferior
                .wrapContentWidth(Alignment.CenterHorizontally)  // Asegurando que el botón esté centrado
        ) {
            ButtonUtils(
                text = "Confirmar",
                onClick = onDoneClick,
                icon = R.drawable.arrow_right
            )
        }
    }
}

@Composable
fun DaysSelector(selectedDays: Set<Int>, onDaySelected: (Int) -> Unit) {
    val days = listOf("L", "M", "M", "J", "V", "S", "D") // Representaciones de los días
    val daysIndex = listOf(0, 1, 2, 3, 4, 5, 6) // Índices de los días

    // Contenedor para la barra de selección
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        daysIndex.forEach { dayIndex ->
            val isSelected = selectedDays.contains(dayIndex)
            Text(
                text = days[dayIndex],
                color = if (isSelected) Color.White else Color.Black,
                modifier = Modifier
                    .background(
                        if (isSelected) Color(0xFFB49AFF) else Color.Transparent,
                        shape = RoundedCornerShape(50) // Esquinas redondeadas
                    )
                    .clickable {
                        onDaySelected(dayIndex) // Maneja la selección de días
                    }
                    .padding(8.dp) // Espaciado alrededor del texto
            )
        }
    }
}

@Composable
fun TimeBoxx(time: String) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(text = time, color = Color.Black)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewEditCourseScreen() {
    EditCourseScreen(onDoneClick = {})
}
