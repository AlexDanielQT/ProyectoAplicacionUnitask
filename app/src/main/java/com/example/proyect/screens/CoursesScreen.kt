package com.example.proyect.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.proyect.components.CustomTopBar

@Composable
fun CoursesScreen(navController: NavHostController) {
    var isDrawerOpen by remember { mutableStateOf(false) }
    var screenTitle by remember { mutableStateOf("Cursos") }

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
                // Lista de cursos, con un clic que lleva a CourseDetailsScreen
                CoursesList(
                    taskName = "Física",
                    subject = "Materia",
                    isChecked = false,
                    onCourseClick = {
                        navController.navigate("course_details_screen/Física")
                    }
                )
                CoursesList(
                    taskName = "Matemáticas",
                    subject = "Cálculo",
                    isChecked = true,
                    onCourseClick = {
                        navController.navigate("course_details_screen/Matemáticas")
                    }
                )
                CoursesList(
                    taskName = "Química",
                    subject = "Orgánica",
                    isChecked = false,
                    onCourseClick = {
                        navController.navigate("course_details_screen/Química")
                    }
                )
            }
        }
    }
}

@Composable
fun CoursesList(taskName: String, subject: String, isChecked: Boolean, onCourseClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .background(Color(0xFFECE6F0), shape = RoundedCornerShape(16.dp))
            .clickable { onCourseClick() } // Agregar el clic
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
                color = MaterialTheme.colorScheme.onPrimary
            )
            Text(text = subject, color = MaterialTheme.colorScheme.onSurface)
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(checked = isChecked, onCheckedChange = { /* Acción del checkbox */ })
        }
    }
    Divider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f), thickness = 1.dp)
}
