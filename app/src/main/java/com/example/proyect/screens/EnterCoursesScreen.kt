package com.example.proyect.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyect.R
import com.example.proyect.utils.ButtonUtils

@Composable
fun EnterCoursesScreen(onBackClick: () -> Unit, onDoneClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFef7ff)), // Fondo color rosa
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .width(360.dp)
                .padding(horizontal = 30.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Texto de información
            Text(
                text = "Por favor, asegúrate de ingresar la información correcta para una mejor organización",
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                modifier = Modifier.padding(top = 123.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Input de curso y docente
            CourseInputField(label = "Curso", value = "Cálculo")
            Spacer(modifier = Modifier.height(16.dp))
            CourseInputField(label = "Docente", value = "Elvis")
            Spacer(modifier = Modifier.height(16.dp))
            CreditsInputField(label = "Créditos", value = "1")

            Spacer(modifier = Modifier.weight(1f)) // Este Spacer ocupa el espacio disponible

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

            // Eliminar el Spacer adicional que estaba después del botón
        }

        // Icono de flecha izquierda (regresar) en la parte superior derecha
        Image(
            painter = painterResource(id = R.drawable.arrow_left),
            contentDescription = "Back",
            modifier = Modifier
                .size(70.dp)
                .padding(start = 20.dp, top = 30.dp) // Margen de 20px a la izquierda y 30px arriba
                .clickable { onBackClick() }
                .align(Alignment.TopStart) // Alinear al extremo superior derecho
        )
    }
}

@Composable
fun CourseInputField(label: String, value: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = label, fontSize = 16.sp, color = Color.Black, fontWeight = FontWeight.Bold)
        OutlinedTextField(
            value = value,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color.White)
        )
    }
}

@Composable
fun CreditsInputField(label: String, value: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = label, fontSize = 16.sp, color = Color.Black, fontWeight = FontWeight.Bold)
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = value,
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(end = 40.dp) // Espacio para el icono a la derecha
                    .background(Color.White)
            )
            // Imagen chevron_down dentro del campo de créditos
            Image(
                painter = painterResource(id = R.drawable.chevron_down),
                contentDescription = "Dropdown",
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterEnd) // Alinear al final (derecha) del Box
                    .padding(end = 8.dp) // Espacio de separación del borde
                    .clickable { /* Acción del ícono */ } // Puedes agregar una acción si es necesario
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEnterCoursesScreen() {
    EnterCoursesScreen(onBackClick = {}, onDoneClick = {})
}
