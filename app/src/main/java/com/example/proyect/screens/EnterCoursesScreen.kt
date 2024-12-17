package com.example.proyect.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyect.R
import com.example.proyect.components.CustomButton
import com.example.proyect.viewmodel.CourseFormViewModel

@Composable
fun EnterCoursesScreen(
    viewModel: CourseFormViewModel,
    onBackClick: () -> Unit,
    onDoneClick: () -> Unit
) {
    val courseName = remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.arrow_left),
            contentDescription = "Back",
            modifier = Modifier
                .size(65.dp)
                .padding(start = 20.dp, top = 30.dp)
                .clickable { onBackClick() }
                .align(Alignment.TopStart)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .width(360.dp)
                .padding(horizontal = 30.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Por favor, ingresa el nombre del curso para una mejor organización",
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = LightOnPrimary,
                modifier = Modifier.padding(top = 123.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(40.dp))

            CourseInputField(
                label = "Curso",
                value = courseName.value,
                onValueChange = { courseName.value = it }
            )

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 55.dp),
                contentAlignment = Alignment.Center
            ) {
                CustomButton(
                    text = "Continuar",
                    onClick = {
                        if (courseName.value.isNotBlank()) {
                            viewModel.addCourse(courseName.value) // Agregar el curso al ViewModel
                            onDoneClick() // Volver a AddCourses
                        } else {
                            // Mostrar un mensaje de error si el campo está vacío
                            // Puedes implementar un Snackbar o un mensaje visual
                        }
                    },
                    icon = R.drawable.arrow_right
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseInputField(label: String, value: String, onValueChange: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        // Etiqueta encima del campo de texto
        Text(
            text = label,
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            ),
            modifier = Modifier.padding(start = 8.dp)
        )

        // Campo de texto con borde
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = null, // Ya no necesitamos el label predeterminado
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(1.dp),
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Gray
            )
        )
    }
}
