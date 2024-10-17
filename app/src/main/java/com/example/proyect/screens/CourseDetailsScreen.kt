package com.example.proyect.screens

import androidx.compose.foundation.Image
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

@Composable
fun CourseDetailsScreen() {
    var selectedCourse by remember { mutableStateOf("Física") }
    var selectedClassroom by remember { mutableStateOf("301") }
    var selectedTeacher by remember { mutableStateOf("Lic Antonio") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFef7ff)) // Color de fondo
            .padding(16.dp)
    ) {
        // Encabezado con flecha de retroceso
        BackButton()

        // Detalle del curso
        Text(text = "Curso")
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

            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Detalle de Aula
        Text(text = "Aula", textAlign = TextAlign.Left, modifier = Modifier.fillMaxWidth())
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
                Text(text = selectedClassroom)

            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Detalle de Docente
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

            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Mostrar Horas de Inicio y Fin
        Text(text = "Horas", textAlign = TextAlign.Left, modifier = Modifier.fillMaxWidth())
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            TimeBox(time = "9:00 AM")
            Spacer(modifier = Modifier.width(8.dp))
            TimeBox(time = "10:00 AM")
        }



        Spacer(modifier = Modifier.height(20.dp))

        // Tareas del curso
        TaskList()
    }
}

@Composable
fun TimeBox(time: String) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(text = time, color = Color.Black)
    }
}

@Composable
fun BackButton() {
    Icon(
        painter = painterResource(id = R.drawable.arrow_left), // Asegúrate de tener el ícono en tu recurso
        contentDescription = "Back",
        modifier = Modifier
            .size(40.dp)
            .clickable { /* Navegación hacia atrás */ }
            .background(Color(0xFFD0BCFF), shape = MaterialTheme.shapes.small)
    )
}

@Composable
fun TaskList() {
    // Código existente para la lista de tareas
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFef7ff)) // Color de fondo
            .padding(16.dp),
    ) {
        
        // Lista de cursos
        Column {
            TaskItem2(taskName = "Física", subject = "Materia", isChecked = false)
            TaskItem2(taskName = "Matemáticas", subject = "Cálculo", isChecked = true)
            TaskItem2(taskName = "Química", subject = "Orgánica", isChecked = false)
        }
    }
}

@Composable
fun TaskItem2(taskName: String, subject: String, isChecked: Boolean) {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .background(Color(0xFFF3E3FA), shape = RoundedCornerShape(16.dp)) // Fondo con color
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
fun PreviewCourseDetailsScreen() {
    CourseDetailsScreen()
}
