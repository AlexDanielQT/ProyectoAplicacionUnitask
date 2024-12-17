package com.example.proyect.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyect.data.model.Task
import com.example.proyect.data.repository.TaskRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow

class TaskViewModel : ViewModel() {
    private val repository = TaskRepository()

    // Cambia MutableList<Task> a StateFlow
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> get() = _tasks

    init {
        // Inicializa las tareas desde el repositorio
        viewModelScope.launch {
            _tasks.value = repository.getAllTasks()
        }
    }

    // Función para agregar una tarea
    fun addTask(task: Task) {
        viewModelScope.launch {
            repository.addTask(task)
            _tasks.value = repository.getAllTasks() // Actualiza el flujo de tareas
        }
    }

    // Función para eliminar una tarea
    fun deleteTask(taskId: Int) {
        viewModelScope.launch {
            repository.deleteTask(taskId)
            _tasks.value = repository.getAllTasks() // Actualiza el flujo de tareas
        }
    }

    // Función para actualizar una tarea
    fun updateTask(updatedTask: Task) {
        viewModelScope.launch {
            repository.updateTask(updatedTask)
            _tasks.value = repository.getAllTasks() // Actualiza el flujo de tareas
        }
    }
}
