package com.example.proyect.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.Calendar
import com.example.proyect.R

@Composable
fun CalendarScreen() {
    // Obtener el calendario actual
    val calendar = Calendar.getInstance()
    val currentYear = calendar.get(Calendar.YEAR)
    val currentMonth = calendar.get(Calendar.MONTH)

    // Título del calendario
    val monthNames = arrayOf(
        "Enero", "Febrero", "Marzo", "Abril",
        "Mayo", "Junio", "Julio", "Agosto",
        "Septiembre", "Octubre", "Noviembre", "Diciembre"
    )
    val currentMonthName = monthNames[currentMonth]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFef7ff)) // Color de fondo
            .padding(16.dp),
    ) {
        // Icono de retroceso
        Image(
            painter = painterResource(id = R.drawable.arrow_left), // Reemplaza con el ID correcto de tu recurso
            contentDescription = "Volver",
            modifier = Modifier
                .size(70.dp)
                .padding(start = 10.dp, top = 30.dp) // Espaciado específico
        )

        // Título del mes
        Text(
            text = "$currentMonthName $currentYear",
            color = Color(0xFF1D1B20),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(top = 16.dp) // Espaciado entre el icono y el título
        )

        Spacer(modifier = Modifier.height(16.dp)) // Espaciado entre el título y la cuadrícula del calendario

        // Días de la semana
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val days = arrayOf("Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom")
            days.forEach { day ->
                Text(
                    text = day,
                    color = Color(0xFF1D1B20),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 10.dp) // Espaciado vertical
                )
            }
        }

        // Cuadrícula del calendario
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Calcular el primer día del mes
            calendar.set(currentYear, currentMonth, 1)
            val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
            val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

            // Espacios para días vacíos al inicio del mes
            val dayOffset = if (firstDayOfWeek == Calendar.SUNDAY) 6 else firstDayOfWeek - 2

            for (week in 0..5) { // Máximo 6 filas
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    for (day in 1..7) { // 7 días en una semana
                        if (week == 0 && day <= dayOffset) {
                            Spacer(modifier = Modifier.width(48.dp)) // Espaciado para días vacíos
                        } else {
                            val dayOfMonth = week * 7 + day - dayOffset
                            if (dayOfMonth <= daysInMonth) {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .size(48.dp) // Tamaño de los días
                                        .background(Color(0xFFECE6F0), shape = RoundedCornerShape(12.dp)) // Fondo con color
                                        .border(1.dp, Color(0xFF1D1B20), shape = RoundedCornerShape(12.dp)) // Borde
                                ) {
                                    Text(
                                        text = dayOfMonth.toString(),
                                        color = Color(0xFF49454F),
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            } else {
                                Spacer(modifier = Modifier.width(48.dp)) // Espaciado para días vacíos
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCalendarScreen() {
    CalendarScreen()
}
