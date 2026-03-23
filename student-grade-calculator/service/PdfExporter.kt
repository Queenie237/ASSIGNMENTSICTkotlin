package com.studentgrade.service

import com.studentgrade.model.Student
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Table
import java.io.File

fun exportToPDF(students: List<Student>, file: File) {

    val pdf = PdfDocument(PdfWriter(file))
    val document = Document(pdf)

    val table = Table(6)

    val headers = listOf("Matricule", "Name", "Course", "Code", "Score", "Grade")
    headers.forEach { table.addHeaderCell(it) }

    students.forEach {
        table.addCell(it.matricule)
        table.addCell(it.name)
        table.addCell(it.courseName)
        table.addCell(it.courseCode)
        table.addCell(it.score?.toString() ?: "")
        table.addCell(it.grade ?: "")
    }

    document.add(table)
    document.close()
}