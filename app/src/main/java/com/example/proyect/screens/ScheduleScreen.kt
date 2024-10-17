package com.example.proyect.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.proyect.R
import com.example.proyect.ui.theme.*
import com.example.proyect.utils.ButtonUtils

@Composable
fun ScheduleScreen(navController: NavHostController, onBackClick: () -> Unit, onDoneClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background) // Fondo dinámico según el tema
    ) {
        // Icono de flecha izquierda (regresar)
        Image(
            painter = painterResource(id = R.drawable.arrow_left),
            contentDescription = "Back",
            modifier = Modifier
                .size(65.dp)
                .padding(start = 20.dp, top = 30.dp)
                .clickable { onBackClick() }
                .align(Alignment.TopStart)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp, vertical = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Texto de información
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            ) {
                Text(
                    text = "A continuación, configuraremos tu horario académico de manera rápida y sencilla",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onPrimary, // Texto sobre fondo primario
                    textAlign = TextAlign.Center
                )
            }

            // Cuadrícula de horario
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .border(2.dp, MaterialTheme.colorScheme.secondary) // Borde con color secundario
            ) {
                ScheduleGrid(navController) // Pasamos navController aquí
            }

            // Botón "Continuar"
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 25.dp, top = 20.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                ButtonUtils(
                    text = "Continuar",
                    onClick = onDoneClick,
                    icon = R.drawable.arrow_right
                )
            }
        }
    }
}

@Composable
fun ScheduleGrid(navController: NavHostController) {
    val days = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
    val times = (0..23).map { hour -> String.format("%02d:00", hour) }
    val verticalScrollState = rememberScrollState()
    val horizontalScrollState = rememberScrollState()

    // Posicionar el scroll en las 7:00 al iniciar
    LaunchedEffect(Unit) {
        verticalScrollState.scrollTo(7 * 60) // Aproximación para alinear con las 7:00
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // Contenido con scroll
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(verticalScrollState)
        ) {
            Spacer(modifier = Modifier.height(40.dp)) // Espacio para los encabezados flotantes
            times.forEach { time ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(horizontalScrollState)
                ) {
                    // Columna de horas
                    Text(
                        text = time,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .width(50.dp)
                            .padding(8.dp)
                            .background(MaterialTheme.colorScheme.surface) // Fondo para las horas
                    )

                    // Celdas de horario con divisores
                    days.forEach { _ ->
                        Box(
                            modifier = Modifier
                                .width(120.dp)
                                .height(50.dp)
                                .border(0.5.dp, Color(0xFFB1B1B1)) // Borde entre celdas
                                .clickable {
                                    // Navegación al hacer clic en una celda
                                    navController.navigate("add_courses_schedule")
                                }
                        )
                    }
                }
            }
        }

        // Encabezados flotantes
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(horizontalScrollState) // Sincronizado con las filas
                .background(MaterialTheme.colorScheme.background) // Fondo fijo para que destaque
                .zIndex(1f) // Eleva los encabezados sobre el resto
        ) {
            Spacer(modifier = Modifier.width(50.dp)) // Espacio para la columna de horas
            days.forEach { day ->
                Text(
                    text = day,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(120.dp)
                        .padding(8.dp)
                        .background(MaterialTheme.colorScheme.secondary) // Fondo secundario para los días
                        .border(0.5.dp, MaterialTheme.colorScheme.onSecondary) // Borde de las celdas
                )
            }
        }
    }
}
