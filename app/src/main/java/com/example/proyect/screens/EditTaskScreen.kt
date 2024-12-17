package com.example.proyect.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.proyect.R
import com.example.proyect.utils.ButtonUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreviewEditTaskScreen(
    onDoneClick: () -> Unit,
    navController: NavHostController  // Agregamos navController para la navegación
) {
    // Estado para la fecha y hora
    val dateAndTime = remember { mutableStateOf("Jun 10, 2024 - 9:41 AM") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBackground) // Usamos LightBackground como fondo principal
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            // Imagen en la parte superior a 30 píxeles del margen superior
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.x_square),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .background(LightPrimary, shape = MaterialTheme.shapes.small)  // Usamos LightPrimary para el fondo del ícono
                        .clickable { navController.popBackStack() }  // Regresar a TaskDetailsScreen
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Curso
            Text(text = "Curso", color = LightOnPrimary) // Usamos LightOnPrimary para el color del texto
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(LightSurface)  // Usamos LightSurface para el fondo
                    .border(
                        width = 1.dp,
                        color = LightSecondary,  // Usamos LightSecondary para el borde
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Fisica", color = LightOnPrimary) // Usamos LightOnPrimary para el color del texto
                    Icon(
                        painter = painterResource(id = R.drawable.chevron_down), // Verifica el nombre del recurso
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Fecha de entrega
            Text(text = "Fecha de entrega", color = LightOnPrimary)
            TextField(
                value = dateAndTime.value,
                onValueChange = { dateAndTime.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(2.dp, LightSecondary, shape = RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.textFieldColors(containerColor = LightBackground)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Descripción
            Text(text = "Descripción", color = LightOnPrimary)
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("") }, // No se necesita etiqueta dentro
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp) // Altura duplicada
                    .border(2.dp, LightSecondary, shape = RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.textFieldColors(containerColor = LightBackground)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Notas
            Text(text = "Detalles", color = LightOnPrimary)
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("") }, // No se necesita etiqueta dentro
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp) // Altura duplicada
                    .border(2.dp, LightSecondary, shape = RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.textFieldColors(containerColor = LightBackground)
            )

            Spacer(modifier = Modifier.weight(1f))

            // Botón de confirmar alineado a la derecha
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 65.dp), // 20px del margen derecho y 70px del margen inferior
                contentAlignment = Alignment.BottomCenter // Alineado a la derecha
            ) {
                ButtonUtils(
                    text = "Confirmar",
                    onClick = { navController.popBackStack() }, // Regresar a TaskDetailsScreen al confirmar
                    icon = R.drawable.arrow_right
                )
            }
        }
    }
}
