package com.example.proyect.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyect.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskDetailsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFef7ff))
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(76.dp)) // Espacio para el icono de volver

            // Campo de curso
            Text(text = "Curso", textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth())
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Text(text = "Física", color = Color.Gray)
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Fecha de entrega
            Text(text = "Fecha de entrega", textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth())
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                DateAndTime(month = "Jun", day = 10, year = 2024, time = "9:41 AM")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Descripción
            Text(text = "Descripción", textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth())
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(16.dp)
                    .height(119.dp) // Altura fija para la descripción
            ) {
                Text(
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Notas
            Text(text = "Notas", textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth())
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(16.dp)
                    .height(119.dp) // Altura fija para las notas
            ) {
                Text(
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
        }

        // Icono de volver
        Icon(
            painter = painterResource(id = R.drawable.arrow_left),
            contentDescription = "Volver",
            modifier = Modifier
                .size(70.dp)
                .padding(start = 20.dp, top = 30.dp)
                .align(Alignment.TopStart)
                .background(Color(0xFFD0BCFF), shape = MaterialTheme.shapes.small)
                .clickable { /* Acción para volver */ }
        )

        // Icono de editar
        Icon(
            painter = painterResource(id = R.drawable.edit_square),
            contentDescription = "Editar",
            modifier = Modifier
                .size(70.dp)
                .padding(end = 20.dp, top = 30.dp)
                .align(Alignment.TopEnd)
                .background(Color(0xFFD0BCFF), shape = MaterialTheme.shapes.small)
                .clickable { /* Acción para editar */ }
        )
    }
}

@Composable
fun DateAndTime(month: String, day: Int, year: Int, time: String) {
    Text(text = "$month $day, $year at $time", color = Color.Gray)
}

@Preview(showBackground = true)
@Composable
fun PreviewTaskDetailsScreen() {
    TaskDetailsScreen()
}
