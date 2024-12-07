package com.example.proyect.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.proyect.R
import com.example.proyect.components.CustomTopBar
import com.example.proyect.components.TaskCard
import com.example.proyect.viewmodel.TaskViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

@Composable
fun MainPage(navController: NavHostController, viewModel: TaskViewModel = viewModel()) {
    val tasks = viewModel.tasks.collectAsState(initial = emptyList()).value
    val backgroundColor = MaterialTheme.colorScheme.background
    val onPrimaryColor = MaterialTheme.colorScheme.onPrimary

    var isDrawerOpen by remember { mutableStateOf(false) }
    var screenTitle by remember { mutableStateOf("Cursos de hoy") }
    val topBarHeight = 56.dp // Altura de la barra superior
    val topBarPadding = 8.dp // Padding superior para la barra


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        // 🔹 Barra superior fija con espacio superior
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(topBarHeight) // Mantener la altura total de la barra
                .padding(top = topBarPadding) // Espacio superior
                .zIndex(1f) // Se asegura de que esté por encima del contenido
        ) {
            CustomTopBar(
                title = screenTitle,
                onClick = {
                    isDrawerOpen = !isDrawerOpen
                }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = topBarHeight + topBarPadding) // Desplazar el contenido debajo de la barra superior
        ) {
            // 🔹 Barra lateral con visibilidad controlada
            AnimatedVisibility(visible = isDrawerOpen) {
                DrawerContent(onItemClick = { item ->
                    isDrawerOpen = false
                    screenTitle = item // Cambiar título dinámicamente
                })
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 400.dp, max = 600.dp)
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
                        onClick = {
                            // Acción para este botón (aún no definida)
                        },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(8.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.maximize_square),
                            contentDescription = "Expandir",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                TaskCard(
                    tasks = tasks,
                    onAddTaskClick = {
                        navController.navigate("add_task")
                    }
                )
            }
        }
    }
}


// 🔹 Contenido de la barra lateral
@Composable
fun DrawerContent(onItemClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .width(80.dp) // Ancho compacto de la barra
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        // Elementos de la barra de navegación
        DrawerItem(text = "Tareas", icon = R.drawable.edit_square, onClick = { onItemClick("Tareas") })
        DrawerItem(text = "Cursos", icon = R.drawable.navbar, onClick = { onItemClick("Cursos") })
        DrawerItem(text = "Calendario", icon = R.drawable.check_square, onClick = { onItemClick("Calendario") })
    }
}

// 🔹 Elemento individual de la barra lateral
@Composable
fun DrawerItem(text: String, icon: Int, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = text,
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

// 🔹 Función para obtener el día de la semana actual
fun getCurrentDayName(): String {
    val currentDate = LocalDate.now()
    return currentDate.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())
}

// 🔹 Componente para los elementos de la lista de horas
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
