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
import androidx.navigation.NavController
import com.example.proyect.R

@Composable
fun CourseDetailsScreen(courseName: String, navController: NavController) {
    var selectedClassroom by remember { mutableStateOf("301") }
    var selectedTeacher by remember { mutableStateOf("Lic Antonio") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFef7ff)) // Color de fondo
            .padding(16.dp)
    ) {
        // Encabezado con flecha de retroceso
        BackButton(navController = navController)

        // Detalle del curso
        Text(text = "Curso", color = Color(0xFF1D1B20))
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
                Text(text = courseName, color = Color(0xFF1D1B20)) // Usa courseName en lugar de selectedCourse
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Detalle de Aula
        Text(text = "Aula", textAlign = TextAlign.Left, modifier = Modifier.fillMaxWidth(), color = Color(0xFF1D1B20))
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
                Text(text = selectedClassroom, color = Color(0xFF1D1B20))
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Detalle de Docente
        Text(text = "Docente", textAlign = TextAlign.Left, modifier = Modifier.fillMaxWidth(), color = Color(0xFF1D1B20))
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
                Text(text = selectedTeacher, color = Color(0xFF1D1B20))
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Mostrar Horas de Inicio y Fin
        Text(text = "Horas", textAlign = TextAlign.Left, modifier = Modifier.fillMaxWidth(), color = Color(0xFF1D1B20))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            TimeBox(time = "9:00 AM")
            Spacer(modifier = Modifier.width(8.dp))
            TimeBox(time = "10:00 AM")
        }

        Spacer(modifier = Modifier.height(20.dp))


    }
}

@Composable
fun BackButton(navController: NavController) {
    Icon(
        painter = painterResource(id = R.drawable.arrow_left), // Asegúrate de tener el ícono en tu recurso
        contentDescription = "Back",
        modifier = Modifier
            .size(40.dp)
            .clickable {
                navController.popBackStack() // Regresar a la pantalla anterior
            }
            .background(Color(0xFFD0BCFF), shape = MaterialTheme.shapes.small)
    )
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


