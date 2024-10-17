package com.example.proyect.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyect.R
import com.example.proyect.utils.ButtonUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreviewEditTaskScreen(
    onDoneClick: () -> Unit
) {
    // Estado para la fecha y hora
    val dateAndTime = remember { mutableStateOf("Jun 10, 2024 - 9:41 AM") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFef7ff)) // Color de fondo
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
                        .background(Color(0xFFD0BCFF), shape = MaterialTheme.shapes.small)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Curso
            Text(text = "Curso")
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFFFFFF))
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Fisica")
                    Icon(
                        painter = painterResource(id = R.drawable.chevron_down), // Verifica el nombre del recurso
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Fecha de entrega
            Text(text = "Fecha de entrega")
            TextField(
                value = dateAndTime.value,
                onValueChange = { dateAndTime.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(2.dp, Color(0xFFE0E0E0), shape = RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFFFFFFF))
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Descripción
            Text(text = "Descripción")
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("") }, // No se necesita etiqueta dentro
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp) // Altura duplicada
                    .border(2.dp, Color(0xFFE0E0E0), shape = RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFFFFFFF))
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Notas
            Text(text = "Detalles")
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("") }, // No se necesita etiqueta dentro
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp) // Altura duplicada
                    .border(2.dp, Color(0xFFE0E0E0), shape = RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFFFFFFF))
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
                    onClick = onDoneClick,
                    icon = R.drawable.arrow_right
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEditTaskScreen() {
    AddTaskScreen(onDoneClick = {})
}
