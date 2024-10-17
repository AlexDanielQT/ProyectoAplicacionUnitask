package com.example.proyect.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyect.data.model.Task
import com.example.proyect.data.repository.TaskRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {
    private val repository = TaskRepository()
    val tasks: StateFlow<List<Task>> = repository.tasks

    fun addTask(task: Task) {
        viewModelScope.launch {
            repository.addTask(task)
        }
    }

    // Cambié el nombre del método a deleteTask
    fun deleteTask(taskId: Int) {
        viewModelScope.launch {
            repository.deleteTask(taskId)
        }
    }

    fun updateTask(updatedTask: Task) {
        viewModelScope.launch {
            repository.updateTask(updatedTask)
        }
    }
}
