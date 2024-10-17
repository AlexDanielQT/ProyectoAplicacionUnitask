package com.example.proyect.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF9FF)) // Fondo blanco
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Top Bar (Encabezado)
            TopAppBar(
                title = { Text("Cursos de hoy") },
                navigationIcon = {
                    IconButton(onClick = { /* Acción del menú */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.navbar),
                            contentDescription = "Menu"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFDEFFF) // Color de barra superior más claro
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Contenedor para el calendario
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.White)
                    .border(2.dp, Color(0xFFE0E0E0), shape = RoundedCornerShape(8.dp)) // Bordes grises suaves
                    .padding(20.dp)
            ) {
                Column(
                    modifier = Modifier.align(Alignment.TopCenter)
                ) {
                    Text(text = "Lunes", color = Color(0xFF333333)) // Texto en gris oscuro
                }

                Column(
                    modifier = Modifier.align(Alignment.TopStart)
                ) {
                    Spacer(modifier = Modifier.height(8.dp))

                    for (hour in 9..22) {
                        Text(
                            text = "$hour:00",
                            color = Color(0xFF757575), // Texto gris claro
                            modifier = Modifier.padding(vertical = 13.dp)
                        )
                        Divider(color = Color(0xFFE0E0E0), thickness = 1.dp) // Línea divisoria gris suave
                    }
                }

                // Icono para expandir calendario
                IconButton(
                    onClick = { /* Acción del botón de expandir */ },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.maximize_square),
                        contentDescription = "Expandir",
                        tint = Color(0xFF333333) // Icono en gris oscuro
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Contenedor para la lista de tareas pendientes
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF3E5F5), shape = RoundedCornerShape(15.dp)) // Fondo lila claro
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = "Tareas pendientes",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(0xFF333333) // Texto en gris oscuro
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Lista de tareas
                    Column {
                        TaskItem(taskName = "Física", subject = "Materia", isChecked = false)
                        TaskItem(taskName = "Matemáticas", subject = "Cálculo", isChecked = true)
                        TaskItem(taskName = "Química", subject = "Orgánica", isChecked = false)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Botón Agregar con icono
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "Agregar",
                            color = Color(0xFF333333), // Texto gris oscuro
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        FloatingActionButton(
                            onClick = { /* Acción de agregar */ },
                            containerColor = Color(0xFF9575CD), // Color púrpura
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
    }
}


@Composable
fun TaskItem(taskName: String, subject: String, isChecked: Boolean) {
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
fun PreviewPaginaPrincipal() {
    MainPage()
}
