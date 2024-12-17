package com.example.proyect.screens

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.proyect.components.CustomTopBar

@Composable
fun HistoryScreen(navController: NavHostController) {
    var isDrawerOpen by remember { mutableStateOf(false) }
    var screenTitle by remember { mutableStateOf("Historial de Tareas") }
    val topBarHeight = 56.dp
    val topBarPadding = 8.dp
    val backgroundColor = MaterialTheme.colorScheme.background

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(topBarHeight)
                .padding(top = topBarPadding)
                .zIndex(1f)
        ) {
            CustomTopBar(
                title = screenTitle,
                onClick = { isDrawerOpen = !isDrawerOpen }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = topBarHeight + topBarPadding)
        ) {
            AnimatedVisibility(visible = isDrawerOpen) {
                DrawerContent(navController = navController)
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                // Sección de tareas realizadas
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .border(2.dp, MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(8.dp))
                        .padding(10.dp)
                ) {
                    Column {
                        Text(
                            text = "Tareas Realizadas",
                            color = MaterialTheme.colorScheme.onPrimary,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        HTaskList(
                            taskName = "Física",
                            subject = "Materia",
                            isChecked = true,
                            onClick = { navController.navigate("task_details") }
                        )
                        HTaskList(
                            taskName = "Matemáticas",
                            subject = "Cálculo",
                            isChecked = true,
                            onClick = { navController.navigate("task_details") }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Sección de tareas no realizadas
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .border(2.dp, MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(8.dp))
                        .padding(10.dp)
                ) {
                    Column {
                        Text(
                            text = "Tareas No Realizadas",
                            color = MaterialTheme.colorScheme.onPrimary,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        HTaskList(
                            taskName = "Química",
                            subject = "Orgánica",
                            isChecked = false,
                            onClick = { navController.navigate("task_details") }
                        )
                        HTaskList(
                            taskName = "Biología",
                            subject = "Celular",
                            isChecked = false,
                            onClick = { navController.navigate("task_details") }
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun HTaskList(taskName: String, subject: String, isChecked: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .background(Color(0xFFECE6F0), shape = RoundedCornerShape(16.dp))
            .clickable { onClick() } // Acción al hacer clic
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = taskName,
                modifier = Modifier.weight(1f),
                color = Color(0xFF1D1B20)
            )
            Text(text = subject, color = Color(0xFF49454F))
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(
                checked = isChecked,
                onCheckedChange = { /* Acción del checkbox */ }
            )
        }
    }
    Divider(color = Color.Gray, thickness = 1.dp)
}
