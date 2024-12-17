package com.example.proyect.data.repository

import com.example.proyect.data.model.Task

class TaskRepository {
    val tasks = mutableListOf<Task>()

    fun getAllTasks(): List<Task> {
        return tasks.toList()
    }

    fun addTask(task: Task) {
        tasks.add(task)
    }

    fun updateTask(updatedTask: Task) {
        val index = tasks.indexOfFirst { it.id == updatedTask.id }
        if (index != -1) {
            tasks[index] = updatedTask
        }
    }

    fun deleteTask(taskId: Int) {
        tasks.removeAll { it.id == taskId }
    }
}
