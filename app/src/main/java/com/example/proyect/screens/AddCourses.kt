package com.example.proyect.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.proyect.R
import com.example.proyect.components.CustomButton
import com.example.proyect.components.PlusSquare
import com.example.proyect.utils.ButtonUtils // Asegúrate de importar la clase

@Composable
fun AddCourses(onDoneClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFef7ff)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .size(width = 360.dp, height = 800.dp)
                .background(Color(0xFFFef7ff)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Primero, necesitamos que ingreses tus cursos o materias para personalizar tu experiencia.",
                modifier = Modifier.padding(top = 57.dp, start = 30.dp, end = 30.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Primera fila: dos cards lado a lado
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(
                    modifier = Modifier
                        .width(160.dp)
                        .height(200.dp)
                        .border(2.dp, Color.Gray, RoundedCornerShape(16.dp)) // Borde gris
                        .clip(RoundedCornerShape(16.dp)) // Esquinas redondeadas
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    PricingCard(courseName = "Curso", teacherName = "Fisica", teacherTitle = "Lic Andres")
                }

                Box(
                    modifier = Modifier
                        .width(160.dp)
                        .height(200.dp)
                        .border(2.dp, Color.Gray, RoundedCornerShape(16.dp))
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    PricingCard(courseName = "Curso", teacherName = "Fisica", teacherTitle = "Lic Andres")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Segunda fila: una card y el botón "Plus" lado a lado
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(
                    modifier = Modifier
                        .width(160.dp)
                        .height(200.dp)
                        .border(2.dp, Color.Gray, RoundedCornerShape(16.dp))
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    PricingCard(courseName = "Curso", teacherName = "Fisica", teacherTitle = "Lic Andres")
                }

                Box(
                    modifier = Modifier
                        .width(160.dp)
                        .height(200.dp)
                        .border(2.dp, Color.Gray, RoundedCornerShape(16.dp))
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFFef7ff)),
                    contentAlignment = Alignment.Center // Centrar el botón en el medio del Box
                ) {
                    PlusSquare(onClick = {
                        // Acción al hacer clic en el botón
                        println("Añadir curso")
                    })
                }
            }

            Spacer(modifier = Modifier.weight(1f)) // Ocupa el espacio restante

            // Alinear el botón "Continuar" al fondo
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 55.dp), // Este padding establece el margen inferior deseado
                contentAlignment = Alignment.Center // Centramos el botón
            ) {
                ButtonUtils(
                    text = "Continuar", // Texto del botón
                    onClick = onDoneClick, // Lógica para continuar
                    icon = R.drawable.arrow_right // Icono opcional
                )
            }
        }
    }
}


@Composable
fun PricingCard(courseName: String, teacherName: String, teacherTitle: String) {
    Column(
        modifier = Modifier
            .fillMaxSize(), // Llenar el Box que contiene esta card
        verticalArrangement = Arrangement.SpaceBetween, // Espaciado entre los elementos
        horizontalAlignment = Alignment.Start
    ) {
        // Título del curso
        Text(
            text = courseName,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp)) // Separación entre título y contenido

        // Lista de profesores
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) { // Espacio entre textos de profesores
            Text(text = teacherName, fontSize = 16.sp)
            Text(text = teacherTitle, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.weight(1f)) // Empuja el botón hacia abajo

        // Botón para editar
        Button(
            onClick = { /* Acción de editar */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp) // Espacio desde el borde inferior del card
        ) {
            Text("Editar")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewAddCourses() {
    AddCourses(onDoneClick = {}) // Llama a la función que deseas previsualizar
}
