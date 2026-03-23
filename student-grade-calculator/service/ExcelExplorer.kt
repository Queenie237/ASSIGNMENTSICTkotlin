package com.studentgrade.service

import com.studentgrade.model.Student
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileOutputStream

fun exportToExcel(students: List<Student>, file: File) {

    val workbook = XSSFWorkbook()
    val sheet = workbook.createSheet("Grades")

    val headerStyle = workbook.createCellStyle().apply {
        fillForegroundColor = IndexedColors.BLUE.index
        fillPattern = FillPatternType.SOLID_FOREGROUND
        borderTop = BorderStyle.THIN
        borderBottom = BorderStyle.THIN
        borderLeft = BorderStyle.THIN
        borderRight = BorderStyle.THIN
        alignment = HorizontalAlignment.CENTER
    }

    val font = workbook.createFont().apply {
        color = IndexedColors.WHITE.index
        bold = true
    }
    headerStyle.setFont(font)

    val dataStyle = workbook.createCellStyle().apply {
        borderTop = BorderStyle.THIN
        borderBottom = BorderStyle.THIN
        borderLeft = BorderStyle.THIN
        borderRight = BorderStyle.THIN
    }

    val headers = listOf("Matricule", "Name", "Course", "Code", "Score", "Grade")

    val headerRow = sheet.createRow(0)
    headers.forEachIndexed { i, h ->
        val cell = headerRow.createCell(i)
        cell.setCellValue(h)
        cell.cellStyle = headerStyle
    }

    students.forEachIndexed { i, s ->
        val row = sheet.createRow(i + 1)

        val values = listOf(
            s.matricule,
            s.name,
            s.courseName,
            s.courseCode,
            s.score?.toString() ?: "",
            s.grade ?: ""
        )

        values.forEachIndexed { j, v ->
            val cell = row.createCell(j)
            cell.setCellValue(v)
            cell.cellStyle = dataStyle
        }
    }

    for (i in headers.indices) sheet.autoSizeColumn(i)

    FileOutputStream(file).use { workbook.write(it) }
    workbook.close()
}