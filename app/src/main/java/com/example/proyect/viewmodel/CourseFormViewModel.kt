package com.example.proyect.viewmodel

import androidx.lifecycle.ViewModel
import com.example.proyect.data.repository.CourseRepository

class CourseFormViewModel(
    private val repository: CourseRepository
) : ViewModel() {

    // Aquí van las propiedades y métodos del ViewModel

    fun addCourse(courseName: String) {
        // Agregar el curso al repositorio
        // Por ejemplo, algo como repository.addCourse(courseName)
    }
}
