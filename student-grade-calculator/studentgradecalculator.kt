import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileOutputStream

// Data class
data class Student(val name: String, val score: Int?)

// Grade function (clean when expression)
fun getGrade(score: Int?): String = when (score) {
    null -> "No Grade"
    in 90..100 -> "A"
    in 80..89 -> "B"
    in 70..79 -> "C"
    in 60..69 -> "D"
    else -> "F"
}

fun main() {

    val students = listOf(
        Student("Queenie", 95),
        Student("Tracy", 78),
        Student("Jojo", 87),
        Student("Junior", 67),
        Student("Dina", 54),
        Student("Gerard", null)
    )

    val workbook = XSSFWorkbook()
    val sheet = workbook.createSheet("Student Grades")

    // Header
    listOf("Name", "Score", "Grade")
        .forEachIndexed { i, title ->
            sheet.createRow(0).createCell(i).setCellValue(title)
        }

    // Fill rows
    students.forEachIndexed { index, student ->
        val row = sheet.createRow(index + 1)

        row.createCell(0).setCellValue(student.name)

        student.score?.let {
            row.createCell(1).setCellValue(it.toDouble())
        } ?: row.createCell(1).setCellValue("No Score")

        row.createCell(2).setCellValue(getGrade(student.score))
    }

    FileOutputStream("Student_Grades.xlsx").use { workbook.write(it) }
    workbook.close()

    println("Excel file created successfully.")
}