package com.example.proyect.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CoursesViewModel : ViewModel() {
    // Mantener lista de cursos
    val courses = mutableStateOf<List<String>>(emptyList())

    // Función para agregar un nuevo curso
    fun addCourse(courseName: String) {
        // Agregar el nuevo curso a la lista
        courses.value = courses.value + courseName
    }
}
