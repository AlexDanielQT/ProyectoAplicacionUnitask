package com.example.proyect.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyect.R

@Composable
fun CoursesScreen() {
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

        // Título de la pantalla
        Text(
            text = "Cursos",
            color = Color(0xFF1D1B20),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(top = 16.dp) // Espaciado entre el icono y el título
        )

        Spacer(modifier = Modifier.height(16.dp)) // Espaciado entre el título y la lista

        // Lista de cursos
        Column {
            CoursesList(taskName = "Física", subject = "Materia", isChecked = false)
            CoursesList(taskName = "Matemáticas", subject = "Cálculo", isChecked = true)
            CoursesList(taskName = "Química", subject = "Orgánica", isChecked = false)
        }
    }
}

@Composable
fun CoursesList(taskName: String, subject: String, isChecked: Boolean) {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .background(Color(0xFFECE6F0), shape = RoundedCornerShape(16.dp)) // Fondo con color
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = taskName, modifier = Modifier.weight(1f), color = Color(0xFF1D1B20)) // Color del texto
            Text(text = subject, color = Color(0xFF49454F)) // Color gris
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(checked = isChecked, onCheckedChange = { /* Acción del checkbox */ })
        }
    }
    Divider(color = Color.Gray, thickness = 1.dp)
}

@Preview(showBackground = true)
@Composable
fun PreviewCoursesScreen() {
    CoursesScreen()
}
