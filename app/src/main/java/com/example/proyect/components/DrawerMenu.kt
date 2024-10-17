package com.example.proyect.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DrawerMenu(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = {
            navController.navigate("tasks") // Navegar a tareas
        }) {
            Text("Tareas")
        }

        Button(onClick = {
            navController.navigate("courses") // Navegar a cursos
        }) {
            Text("Cursos")
        }

        Button(onClick = {
            navController.navigate("calendar") // Navegar al calendario
        }) {
            Text("Calendario")
        }
    }
}
