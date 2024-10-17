package com.example.proyect.data.repository

import com.example.proyect.data.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TaskRepository {
    private val taskList = mutableListOf<Task>()  // Cambié el nombre aquí

    // Usamos StateFlow para notificar cambios a las vistas
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> get() = _tasks

    // Obtener todas las tareas
    fun getAllTasks(): List<Task> = taskList

    // Agregar una tarea
    fun addTask(task: Task) {
        taskList.add(task)
        _tasks.value = taskList // Notificamos el cambio
    }

    // Eliminar una tarea por ID
    fun deleteTask(taskId: Int) {
        taskList.removeAll { it.id == taskId }
        _tasks.value = taskList // Notificamos el cambio
    }

    // Actualizar una tarea
    fun updateTask(updatedTask: Task) {
        val index = taskList.indexOfFirst { it.id == updatedTask.id }
        if (index != -1) {
            taskList[index] = updatedTask
            _tasks.value = taskList // Notificamos el cambio
        }
    }
}
