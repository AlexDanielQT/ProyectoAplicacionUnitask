package com.example.proyect.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyect.R
import com.example.proyect.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskDetailsScreen(
    onBackClick: () -> Unit,  // Parámetro para manejar el botón de regresar
    onEditClick: () -> Unit        // Para ir hacia atrás
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBackground) // Color de fondo general
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(76.dp)) // Espacio para el ícono de volver

            // Campo de curso
            Text(
                text = "Curso",
                textAlign = TextAlign.Start,
                color = LightOnPrimary,
                modifier = Modifier.fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(LightSurface, RoundedCornerShape(8.dp))
                    .border(1.dp, LightSecondary, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Text(text = "Física", color = LightOnTertiary)
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Fecha de entrega
            Text(
                text = "Fecha de entrega",
                textAlign = TextAlign.Start,
                color = LightOnPrimary,
                modifier = Modifier.fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(LightSurface, RoundedCornerShape(8.dp))
                    .border(1.dp, LightSecondary, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                DateAndTime(month = "Jun", day = 10, year = 2024, time = "9:41 AM")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Descripción
            Text(
                text = "Descripción",
                textAlign = TextAlign.Start,
                color = LightOnPrimary,
                modifier = Modifier.fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(LightSurface, RoundedCornerShape(8.dp))
                    .border(1.dp, LightSecondary, RoundedCornerShape(8.dp))
                    .padding(16.dp)
                    .height(119.dp)
            ) {
                Text(
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                    color = LightOnTertiary
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Notas
            Text(
                text = "Notas",
                textAlign = TextAlign.Start,
                color = LightOnPrimary,
                modifier = Modifier.fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(LightSurface, RoundedCornerShape(8.dp))
                    .border(1.dp, LightSecondary, RoundedCornerShape(8.dp))
                    .padding(16.dp)
                    .height(119.dp)
            ) {
                Text(
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                    color = LightOnTertiary
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
        }

        // Icono de volver
        Image(
            painter = painterResource(id = R.drawable.arrow_left),
            contentDescription = "Back",
            modifier = Modifier
                .size(65.dp)
                .padding(start = 20.dp, top = 30.dp)
                .clickable { onBackClick() } // Acción para regresar
                .align(Alignment.TopStart)
        )

        // Botón de editar
        Image(
            painter = painterResource(id = R.drawable.edit_square),
            contentDescription = "Editar",
            modifier = Modifier
                .size(70.dp)
                .padding(end = 20.dp, top = 30.dp)
                .clickable { onEditClick() } // Acción para ir a EditTaskScreen
                .align(Alignment.TopEnd)
        )
    }
}

@Composable
fun DateAndTime(month: String, day: Int, year: Int, time: String) {
    Text(text = "$month $day, $year at $time", color = LightOnSecondary)
}
