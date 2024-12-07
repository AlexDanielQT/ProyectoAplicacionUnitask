package com.example.proyect.screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyect.R
import com.example.proyect.utils.ButtonUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(
    onDoneClick: () -> Unit,
    navController: NavController // Ahora pasamos el navController como parámetro
) {
    // Estado para la fecha y hora
    val dateAndTime = remember { mutableStateOf("Jun 10, 2024 - 9:41 AM") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background) // Color de fondo según el tema
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                contentAlignment = Alignment.TopStart
            ) {
                // Icono de retroceso con la funcionalidad de retroceder
                Image(
                    painter = painterResource(id = R.drawable.arrow_left), // Reemplaza con el ID correcto de tu recurso
                    contentDescription = "Volver",
                    modifier = Modifier
                        .size(70.dp)
                        .padding(start = 10.dp, top = 30.dp) // Espaciado específico
                        .clickable {
                            // Acción de retroceder
                            navController.popBackStack()  // Regresa a la pantalla anterior
                        }
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Curso
            Text(text = "Curso", color = MaterialTheme.colorScheme.onSurface)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface) // Fondo de superficie
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Fisica", color = MaterialTheme.colorScheme.onSurface)
                    Icon(
                        painter = painterResource(id = R.drawable.chevron_down), // Verifica el nombre del recurso
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Fecha de entrega
            Text(text = "Fecha de entrega", color = MaterialTheme.colorScheme.onSurface)
            TextField(
                value = dateAndTime.value,
                onValueChange = { dateAndTime.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(2.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f), shape = RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.surface)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Descripción
            Text(text = "Descripción", color = MaterialTheme.colorScheme.onSurface)
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("") }, // No se necesita etiqueta dentro
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp) // Altura duplicada
                    .border(2.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f), shape = RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.surface)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Notas
            Text(text = "Detalles", color = MaterialTheme.colorScheme.onSurface)
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("") }, // No se necesita etiqueta dentro
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp) // Altura duplicada
                    .border(2.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f), shape = RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.surface)
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
                    onClick = onDoneClick, // Realiza la acción definida (navegar hacia atrás)
                    icon = R.drawable.arrow_right
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAddTaskScreen() {
    AddTaskScreen(onDoneClick = {}, navController = rememberNavController()) // Pasa un navController de ejemplo
}

