package com.studentgrade.model

data class Student(
    val matricule: String,
    val name: String,
    val courseName: String,
    val courseCode: String,
    val score: Int?,
    var grade: String? = null
)