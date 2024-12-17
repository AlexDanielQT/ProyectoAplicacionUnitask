package com.example.proyect.data.repository

import com.example.proyect.data.model.Course

class CourseRepository {
    private val courses = mutableListOf<Course>()

    fun getAllCourses(): List<Course> {
        return courses.toList()
    }

    fun addCourse(course: Course) {
        courses.add(course)
    }

    fun updateCourse(updatedCourse: Course) {
        val index = courses.indexOfFirst { it.id == updatedCourse.id }
        if (index != -1) {
            courses[index] = updatedCourse
        }
    }

    fun deleteCourse(courseId: Int) {
        courses.removeAll { it.id == courseId }
    }
}
