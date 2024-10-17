package com.example.proyect.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proyect.R
import com.example.proyect.components.CustomTopBar
import com.example.proyect.components.TaskCard
import com.example.proyect.viewmodel.TaskViewModel
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

@Composable
fun MainPage(viewModel: TaskViewModel = viewModel()) {
    val tasks = viewModel.tasks.collectAsState(initial = emptyList()).value

    val backgroundColor = MaterialTheme.colorScheme.background // Fondo dependiendo del modo
    val onPrimaryColor = MaterialTheme.colorScheme.onPrimary // Color de texto sobre fondo primario

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor) // Fondo del modo actual
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            CustomTopBar(
                title = "Cursos de hoy",
                onNavigationClick = {
                    // Acción del menú
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 400.dp, max = 600.dp) // Altura predeterminada para el minihorario
                    .background(Color.White)
                    .border(2.dp, MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(8.dp))
                    .padding(10.dp)
            ) {
                val currentDay = getCurrentDayName()
                Column(
                    modifier = Modifier.align(Alignment.TopCenter)
                ) {
                    Text(
                        text = currentDay,
                        color = onPrimaryColor,
                        style = MaterialTheme.typography.titleLarge
                    )
                }

                val listState = rememberLazyListState(initialFirstVisibleItemIndex = 7)
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 32.dp),
                    state = listState
                ) {
                    for (hour in 0..23) {
                        item {
                            HourItem(hour = hour)
                        }
                    }
                }

                IconButton(
                    onClick = { /* Acción del botón de expandir */ },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                        .border(0.5.dp, MaterialTheme.colorScheme.onSurface) // Borde de las horas

                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.maximize_square),
                        contentDescription = "Expandir",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (tasks.isEmpty()) {
                Text(
                    text = "¡Bien hecho! No tienes tareas pendientes.",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSecondary, // Color del texto
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            } else {
                TaskCard(
                    tasks = tasks,
                    onAddTaskClick = { /* Acción para agregar tarea */ }
                )
            }
        }
    }
}

fun getCurrentDayName(): String {
    val currentDate = LocalDate.now()
    return currentDate.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())
}

@Composable
fun HourItem(hour: Int) {
    Column(modifier = Modifier.padding(vertical = 20.dp)) {
        Text(
            text = "$hour:00",
            modifier = Modifier.padding(horizontal = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        Divider(color = Color.Gray, thickness = 1.dp)
    }
}
