package com.example.proyect.data.model

data class Schedule(
    val id: Int,
    val courseId: Int,  // Relaciona el horario con un curso específico
    val day: String,
    val startTime: String,
    val endTime: String,
    val classroom: String
)
