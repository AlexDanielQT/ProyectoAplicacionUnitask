package com.example.proyect.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.proyect.R
import com.example.proyect.data.model.Task

@Composable
fun TaskCard(
    tasks: List<Task>,
    onAddTaskClick: () -> Unit // Recibe la función de navegación
) {
    val cardBackgroundColor = MaterialTheme.colorScheme.surface // Color de fondo del card
    val textColor = MaterialTheme.colorScheme.onSurface // Color del texto

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(cardBackgroundColor, shape = RoundedCornerShape(15.dp)) // Fondo lila claro
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "Tareas pendientes",
                style = MaterialTheme.typography.titleLarge,
                color = textColor // Texto en gris oscuro
            )

            Spacer(modifier = Modifier.height(8.dp))

            tasks.forEach { task ->
                TaskItem(taskName = task.name, subject = task.description, isChecked = task.completed)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Agregar",
                    color = textColor,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(8.dp))

                FloatingActionButton(
                    onClick = onAddTaskClick, // Llama a la función de navegación
                    containerColor = MaterialTheme.colorScheme.primary, // Color del botón flotante
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.plus_square),
                        contentDescription = "Agregar",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}
