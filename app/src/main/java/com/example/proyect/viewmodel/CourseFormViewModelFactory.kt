package com.example.proyect.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.proyect.data.repository.CourseRepository

class CourseFormViewModelFactory(
    private val repository: CourseRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CourseFormViewModel(repository) as T // Pasa el repository aquí
    }
}


