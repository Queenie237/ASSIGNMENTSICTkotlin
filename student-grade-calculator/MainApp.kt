package com.studentgrade.ui

import com.studentgrade.model.Student
import com.studentgrade.service.*
import javafx.application.Application
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.layout.*
import javafx.stage.FileChooser
import javafx.stage.Stage

class MainApp : Application() {

    private val table = TableView<Student>()
    private var students: List<Student> = emptyList()

    override fun start(stage: Stage) {

        val loadBtn = Button("Load File")
        val exportBtn = Button("Export File")
        val statusLabel = Label("No file loaded")

        val columns = listOf(
            createColumn("Matricule", "matricule"),
            createColumn("Name", "name"),
            createColumn("Course", "courseName"),
            createColumn("Code", "courseCode"),
            createColumn("Score", "score"),
            createColumn("Grade", "grade")
        )

        table.columns.addAll(columns)

        loadBtn.setOnAction {
            val file = FileChooser().showOpenDialog(stage)
            if (file != null) {
                val raw = readStudents(file)
                students = applyGrading(raw, gradeLambda)
                table.items.setAll(students)
                statusLabel.text = "Loaded successfully"
            }
        }

        exportBtn.setOnAction {

            val chooser = FileChooser()

            val excel = FileChooser.ExtensionFilter("Excel", "*.xlsx")
            val pdf = FileChooser.ExtensionFilter("PDF", "*.pdf")

            chooser.extensionFilters.addAll(excel, pdf)

            val file = chooser.showSaveDialog(stage)

            if (file != null) {
                when (chooser.selectedExtensionFilter) {
                    excel -> exportToExcel(students, file)
                    pdf -> exportToPDF(students, file)
                }
                statusLabel.text = "File exported successfully!"
            }
        }

        val layout = VBox(15.0, HBox(10.0, loadBtn, exportBtn), table, statusLabel)
        layout.padding = Insets(20.0)

        val scene = Scene(layout, 900.0, 500.0)

        scene.stylesheets.add(javaClass.getResource("/style.css").toExternalForm())

        stage.title = "Student Grade Calculator"
        stage.scene = scene
        stage.show()
    }

    private fun createColumn(title: String, property: String): TableColumn<Student, String> {
        val col = TableColumn<Student, String>(title)
        col.setCellValueFactory {
            SimpleStringProperty(
                it.value.javaClass.getDeclaredField(property).apply { isAccessible = true }
                    .get(it.value)?.toString() ?: ""
            )
        }
        return col
    }
}

fun main() {
    Application.launch(MainApp::class.java)
}