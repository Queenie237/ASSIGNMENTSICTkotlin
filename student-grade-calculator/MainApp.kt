package com.studentgrade.ui

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import javafx.stage.FileChooser
import javafx.stage.Stage

import com.studentgrade.service.*
import java.io.File

class MainApp : Application() {

    override fun start(stage: Stage) {

        val label = Label("Student Grade Calculator")

        val button = Button("Select Student File")

        button.setOnAction {

            val chooser = FileChooser()
            chooser.title = "Open Student File"

            val file: File? = chooser.showOpenDialog(stage)

            if(file != null){

                val students = readStudents(file)

                val processed = students.map { student ->

                    val gradeMessage = student.score?.let { score ->

                        val grade = getGrade(score)

                        Triple(student.name, score, grade.toString())

                    } ?: Triple(student.name, null, "No Score")

                    gradeMessage
                }

                val output = "Student_Grades.xlsx"

                exportExcel(processed, output)

                label.text = "Excel file created successfully!"
            }
        }

        val root = VBox(20.0, label, button)

        val scene = Scene(root, 400.0, 200.0)

        stage.scene = scene
        stage.title = "Student Grade Calculator"
        stage.show()
    }
}

fun main(){
    Application.launch(MainApp::class.java)
}