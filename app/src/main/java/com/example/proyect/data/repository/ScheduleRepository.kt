package com.example.proyect.data.repository

import com.example.proyect.data.model.Schedule

class ScheduleRepository {
    private val schedules = mutableListOf<Schedule>()

    fun getAllSchedules(): List<Schedule> {
        return schedules.toList()
    }

    fun addSchedule(schedule: Schedule) {
        schedules.add(schedule)
    }

    fun deleteSchedule(scheduleId: Int) {
        schedules.removeAll { it.id == scheduleId }
    }
}
