package com.example.proyect.data.repository

import com.example.proyect.data.model.Schedule

class ScheduleRepository {
    private val schedules = mutableListOf<Schedule>()

    // Obtener todos los horarios
    fun getAllSchedules(): List<Schedule> = schedules

    // Agregar un horario
    fun addSchedule(schedule: Schedule) {
        schedules.add(schedule)
    }

    // Eliminar un horario
    fun deleteSchedule(schedule: Schedule) {
        schedules.remove(schedule)
    }
}
