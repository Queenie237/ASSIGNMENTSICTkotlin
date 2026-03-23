package com.studentgrade.service

import com.studentgrade.model.Student

val gradeLambda: (Int?) -> String = {
    when (it) {
        null -> "N/A"
        in 80..100 -> "A"
        in 70..79 -> "B"
        in 60..69 -> "C"
        in 50..59 -> "D"
        else -> "F"
    }
}

fun applyGrading(students: List<Student>, grader: (Int?) -> String): List<Student> {
    return students.map {
        it.copy(grade = grader(it.score))
    }
}