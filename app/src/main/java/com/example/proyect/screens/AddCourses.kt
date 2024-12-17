package com.example.proyect.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.example.proyect.R
import com.example.proyect.components.CustomButton
import com.example.proyect.components.PlusSquare
import com.example.proyect.viewmodel.CoursesViewModel

@Composable
fun AddCourses(
    onDoneClick: () -> Unit,
    navController: NavHostController,
    viewModel: CoursesViewModel
) {
    val backgroundColor = LightBackground
    val textColor = LightOnPrimary

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor), // Fondo fijo
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .size(width = 360.dp, height = 800.dp)
                .background(backgroundColor),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Primero, necesitamos que ingreses tus cursos o materias para personalizar tu experiencia.",
                modifier = Modifier.padding(top = 57.dp, start = 30.dp, end = 30.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = textColor, // Color fijo
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

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
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    PricingCard(courseName = "Curso", teacherName = "Fisica", teacherTitle = "Lic Andres")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

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
                        .clip(RoundedCornerShape(16.dp))
                        .background(backgroundColor),
                    contentAlignment = Alignment.Center
                ) {
                    PlusSquare(onClick = {
                        navController.navigate("enter_courses_screen") // Navegar a la pantalla EnterCoursesScreen
                    })
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 55.dp),
                contentAlignment = Alignment.Center
            ) {
                CustomButton(
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
    val textColor = LightOnPrimary

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = courseName,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = textColor
        )

        Spacer(modifier = Modifier.height(8.dp))

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(text = teacherName, fontSize = 16.sp, color = textColor)
            Text(text = teacherTitle, fontSize = 16.sp, color = textColor)
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { /* Acción de editar */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text("Editar")
        }
    }
}

