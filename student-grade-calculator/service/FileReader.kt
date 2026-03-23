package com.studentgrade.service

import com.studentgrade.model.Student
import java.io.File

fun readStudents(file: File): List<Student> {
    return file.readLines().drop(1).mapNotNull { line ->
        val parts = line.split(",")

        if (parts.size < 5) return@mapNotNull null

        Student(
            parts[0].trim(),
            parts[1].trim(),
            parts[2].trim(),
            parts[3].trim(),
            parts[4].trim().toIntOrNull()
        )
    }
}