package com.example.proyect.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.proyect.components.CustomTopBar
import java.util.Calendar

@Composable
fun CalendarScreen(navController: NavHostController) {
    var isDrawerOpen by remember { mutableStateOf(false) }
    var screenTitle by remember { mutableStateOf("Calendario") }

    // Estados para el mes y año actuales
    var currentYear by remember { mutableStateOf(Calendar.getInstance().get(Calendar.YEAR)) }
    var currentMonth by remember { mutableStateOf(Calendar.getInstance().get(Calendar.MONTH)) }

    val monthNames = arrayOf(
        "Enero", "Febrero", "Marzo", "Abril",
        "Mayo", "Junio", "Julio", "Agosto",
        "Septiembre", "Octubre", "Noviembre", "Diciembre"
    )
    val currentMonthName = monthNames[currentMonth]

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Barra superior fija
        CustomTopBar(
            title = screenTitle,
            onClick = { isDrawerOpen = !isDrawerOpen }
        )

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 64.dp) // Ajustar espacio debajo de la barra superior
        ) {
            // Menú lateral con visibilidad animada
            AnimatedVisibility(visible = isDrawerOpen) {
                DrawerContent(navController = navController)
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Controles para cambiar el mes/año
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {
                        if (currentMonth == 0) {
                            currentMonth = 11
                            currentYear--
                        } else {
                            currentMonth--
                        }
                    }) {
                        Text("<", fontSize = 20.sp)
                    }

                    Text(
                        text = "$currentMonthName $currentYear",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleLarge
                    )

                    IconButton(onClick = {
                        if (currentMonth == 11) {
                            currentMonth = 0
                            currentYear++
                        } else {
                            currentMonth++
                        }
                    }) {
                        Text(">", fontSize = 20.sp)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Días de la semana
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    val days = arrayOf("Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom")
                    days.forEach { day ->
                        Text(
                            text = day,
                            color = MaterialTheme.colorScheme.onPrimary,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(vertical = 10.dp)
                        )
                    }
                }

                // Cuadrícula del calendario
                CalendarGrid(currentYear, currentMonth)
            }
        }
    }
}

@Composable
fun CalendarGrid(currentYear: Int, currentMonth: Int) {
    val calendar = Calendar.getInstance()
    calendar.set(currentYear, currentMonth, 1)

    val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
    val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    val dayOffset = if (firstDayOfWeek == Calendar.SUNDAY) 6 else firstDayOfWeek - 2

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        for (week in 0..5) { // Máximo 6 filas
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (day in 1..7) { // 7 días en una semana
                    if (week == 0 && day <= dayOffset) {
                        Spacer(modifier = Modifier.width(48.dp))
                    } else {
                        val dayOfMonth = week * 7 + day - dayOffset
                        if (dayOfMonth <= daysInMonth) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .padding(4.dp)
                                    .size(48.dp)
                                    .background(
                                        MaterialTheme.colorScheme.surface,
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .border(
                                        1.dp,
                                        MaterialTheme.colorScheme.secondary,
                                        shape = RoundedCornerShape(12.dp)
                                    )
                            ) {
                                Text(
                                    text = dayOfMonth.toString(),
                                    color = MaterialTheme.colorScheme.onSurface,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        } else {
                            Spacer(modifier = Modifier.width(48.dp))
                        }
                    }
                }
            }
        }
    }
}
