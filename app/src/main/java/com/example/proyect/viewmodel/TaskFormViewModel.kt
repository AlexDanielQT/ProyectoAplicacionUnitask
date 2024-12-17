package com.example.proyect.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyect.data.model.Task
import com.example.proyect.data.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskFormViewModel : ViewModel() {
    private val repository = TaskRepository()

    var taskName = ""
    var taskDescription = ""
    var taskDueDate = ""

    // Función para agregar una tarea
    fun addTask() {
        val task = Task(
            id = (0..1000).random(), // Aquí deberías generar un ID único
            name = taskName,
            description = taskDescription,
            dueDate = taskDueDate,
            completed = false
        )
        viewModelScope.launch {
            repository.addTask(task)
        }
    }
}
