package com.example.proyect.data.repository

import com.example.proyect.data.model.Course

class CourseRepository {
    private val courses = mutableListOf<Course>()

    // Obtener todos los cursos
    fun getAllCourses(): List<Course> = courses

    // Agregar un curso
    fun addCourse(course: Course) {
        courses.add(course)
    }

    // Actualizar un curso
    fun updateCourse(course: Course) {
        val index = courses.indexOfFirst { it.id == course.id }
        if (index != -1) {
            courses[index] = course
        }
    }

    // Eliminar un curso
    fun deleteCourse(course: Course) {
        courses.remove(course)
    }
}
