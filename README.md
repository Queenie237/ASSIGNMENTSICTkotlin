ICT University Assignments Repository

This repository contains multiple assignments:

- Exercise 1: Model Zoo
# Zoo Model – Kotlin OOP Exercise

.Overview

This project implements a simple **Zoo Animal Model** using Object-Oriented Programming (OOP) concepts in Kotlin.
The goal of the exercise is to demonstrate how inheritance, abstraction, and polymorphism can be used to represent real-world entities such as animals.

The program defines an abstract `Animal` class and two concrete subclasses (`Dog` and `Cat`). Each subclass implements its own sound behavior.

This exercise is part of **SE 3242 – Android Application Development** coursework at **The ICT University**.

---

.Objectives

The exercise focuses on practicing the following Kotlin concepts:

* Abstract classes
* Inheritance
* Method overriding
* Properties in classes
* Polymorphism using collections

---

.Project Structure

```
ZooModel
│
├── Animal.kt
├── Dog.kt
├── Cat.kt
└── Main.kt
```

Description

**Animal (Abstract Class)**

* Represents a general animal.
* Contains the properties:

  * `name`
  * `legs`
* Declares the abstract function `makeSound()`.

**Dog Class**

* Inherits from `Animal`.
* Implements the `makeSound()` function.
* Produces the sound **"Woof!"**.

**Cat Class**

* Inherits from `Animal`.
* Implements the `makeSound()` function.
* Produces the sound **"Meow!"**.

**Main Function**

* Creates instances of `Dog` and `Cat`.
* Stores them in a list of `Animal`.
* Iterates through the list and calls `makeSound()` on each object.

---

.Sample Code

```kotlin
abstract class Animal(
    val name: String,
    open val legs: Int
) {
    abstract fun makeSound()
}

class Dog(name: String) : Animal(name, 4) {
    override fun makeSound() {
        println("$name says Woof!")
    }
}

class Cat(name: String) : Animal(name, 4) {
    override fun makeSound() {
        println("$name says Meow!")
    }
}

fun main() {
    val animals: List<Animal> = listOf(
        Dog("Buddy"),
        Cat("Whiskers")
    )

    animals.forEach { it.makeSound() }
}
```

---

.Expected Output

```
Buddy says Woof!
Whiskers says Meow!
```

---

Key Concepts Demonstrated

1. Abstraction

The `Animal` class defines a common structure but leaves the implementation of `makeSound()` to subclasses.

2. Inheritance

`Dog` and `Cat` inherit properties and behavior from `Animal`.

3. Polymorphism

Different subclasses (`Dog`, `Cat`) are treated as objects of the same parent type (`Animal`) and stored in a single list.

 4. Method Overriding

Each subclass provides its own implementation of `makeSound()`.

---

 How to Run

1. Open the project in **IntelliJ IDEA**.
2. Navigate to the `main()` function.
3. Click **Run** or press:

- Exercise 2
- Exercise 2 – Network Request State with Sealed Class

Overview

This project demonstrates how to use **Sealed Classes in Kotlin** to model different states of a network request.

In many applications (especially Android apps), a network request can have multiple possible states such as:

* Loading
* Success
* Error

Using a **sealed class** allows us to represent these states in a **type-safe and structured way**, ensuring that all possible cases are handled when processing the request result.

This exercise is part of **SE 3242 – Android Application Development** coursework at **The ICT University**.

---

Objectives

The goal of this exercise is to practice the following Kotlin concepts:

* Sealed classes
* Data classes
* Object declarations
* Pattern matching with `when`
* Polymorphism

---

Project Structure

```
NetworkStateExercise
│
└── NetworkState.kt
```

---

Implementation

1. Sealed Class

The `NetworkState` sealed class represents all possible states of a network request.

* `Loading` → request is in progress
* `Success` → request completed successfully
* `Error` → request failed

2. Data Classes and Objects

* `Success` and `Error` are **data classes** because they contain data.
* `Loading` is defined as an **object** since it represents a single state without additional data.

---

Code Example

```kotlin
sealed class NetworkState {

    object Loading : NetworkState()

    data class Success(val data: String) : NetworkState()

    data class Error(val message: String) : NetworkState()
}

fun handleState(state: NetworkState) {
    when (state) {

        is NetworkState.Loading ->
            println("Loading...")

        is NetworkState.Success ->
            println("Success: ${state.data}")

        is NetworkState.Error ->
            println("Error: ${state.message}")
    }
}

fun main() {

    val states = listOf(
        NetworkState.Loading,
        NetworkState.Success("User data loaded successfully"),
        NetworkState.Error("Network timeout occurred")
    )

    states.forEach {
        handleState(it)
    }
}
```

---

Expected Output

```
Loading...
Success: User data loaded successfully
Error: Network timeout occurred
```

---

Key Concepts Demonstrated

1. Sealed Classes

A sealed class restricts the hierarchy of subclasses to a fixed set known at compile time.
This ensures safer code and allows Kotlin to verify that all cases are handled in `when` expressions.

2. Data Classes

`Success` and `Error` store information about the request result and automatically generate useful methods like:

* `toString()`
* `equals()`
* `hashCode()`
* `copy()`

3. Object Declaration

`Loading` is implemented as a singleton object because it represents a single shared state.

4. Exhaustive `when`

Since all possible subclasses of `NetworkState` are known, Kotlin does not require an `else` branch.

How to Run

1. Open the project in **IntelliJ IDEA**.
2. Locate the `main()` function.
3. Run the program using:

Kotlin Programming Examples Collection

This repository contains a collection of Kotlin programming examples demonstrating various concepts including data classes, inheritance, polymorphism, interfaces, and practical applications like Excel file generation.

 Project Structure

1. Student Grade Calculator (`studentgradecalculator.kt`)
A practical application that demonstrates Kotlin's data classes and Excel file generation using Apache POI.

Key Concepts:
- **Data Class**: `Student` class with name and nullable score properties
- **When Expression**: Clean grade calculation using Kotlin's `when` statement
- **Null Safety**: Handling nullable scores with safe calls (`?.`) and Elvis operator (`?:`)
- **Excel Generation**: Creating Excel files with student grades using Apache POI library

Features:
- Creates an Excel spreadsheet with student names, scores, and calculated grades
- Handles missing scores gracefully
- Grade calculation based on standard grading scale (90-100: A, 80-89: B, etc.)

# 2. SmartQueue - Queue Management System (`milestone1.kt`)
A queue management system implementation for Milestone 1 of the SmartQueue project.

**Key Concepts:
- **Data Class**: `Ticket` class with properties for queue management
- **Immutable Properties**: Using `val` for immutable data
- **Nullable Types**: `serviceTime` as nullable property for unserved tickets

Features:
- Ticket tracking with unique IDs
- Client name and queue position management
- Service status tracking (served/unserved)
- Service time recording for completed services

 3. Education System with Inheritance (`projectmilestone3.kt`)
A comprehensive example demonstrating object-oriented programming concepts in Kotlin.

Key Concepts:
- **Abstract Classes**: `User` abstract class with common properties and behaviors
- **Inheritance**: `Student` and `Instructor` classes extending `User`
- **Polymorphism**: Storing different user types in a collection of type `User`
- **Data Classes**: `Course` class with automatically generated methods
- **Mutable Collections**: Using `MutableList` for enrolled courses and teaching assignments

Features:
- User management system for educational institutions
- Course enrollment for students
- Course assignment for instructors
- Polymorphic behavior demonstration

4. Drawable Shapes with Interfaces (`drawableshapeswithinterfaces.kt`)
An exercise demonstrating interface implementation and polymorphism.

Key Concepts:
- **Interfaces**: `Drawable` interface with `draw()` method
- **Interface Implementation**: `Circle` and `Square` classes implementing `Drawable`
- **Polymorphism**: Treating different shapes uniformly through the `Drawable` interface
- **ASCII Art**: Simple ASCII representation of geometric shapes

Features:
- Circle drawing with ASCII art
- Square drawing with customizable side length
- Polymorphic shape rendering


#Run Student Grade Calculator
kotlin studentgradecalculator.kt

# Run SmartQueue example
kotlin milestone1.kt

# Run Education System example
kotlin projectmilestone3.kt

 #Run Drawable Shapes example
kotlin drawableshapeswithinterfaces.kt

 Student Grade Calculator

 Overview
The **Student Grade Calculator** is a Kotlin-based application with a **graphical user interface (GUI)** that allows educators and students to calculate letter grades from numeric scores. Users can enter multiple students, calculate their grades, and export results to **Excel (.xlsx)** or **PDF** for easy record-keeping and sharing.



 Features
- Calculate letter grades (A, B, C, D, F) from numeric scores.
- GUI interface for interactive input.
- Process multiple students in a single session.
- Export results to **Excel (.xlsx)** or **PDF**.
- Graceful handling of file writing errors.



Technologies Used
- Kotlin – main programming language
- JavaFX – GUI interface
- Apache POI – Excel export
- iText – PDF export
- Gradle – build tool
- JDK 17 or 20 – runtime environment



Installation

1. Clone the repository
```bash
git clone <your-repository-url>
cd student-grade-calculator

Usage
Run via Gradle
./gradlew run

Using the GUI
Launch the application.
Enter student names and numeric scores.
Click Calculate Grades to see letter grades.
Export results using Export → Excel or Export → PDF.
Output Examples
Excel Export (student_grades.xlsx)
Student(Matricule, Name, courseName, CourseCode,	Score,	Grade)
(ICTU123, Alice, MATHs, MATHs234,	85,	B)
(ICTU564, Bob, BIOLOGY, BIO123, 72,	C)
The PDF contains the same table as Excel for printing or sharing.

Project Structure
src/
 └─ main/
     └─ kotlin/
         └─ com/
             └─ student/
                 └─ StudentGradeCalculator.kt
build.gradle.kts
settings.gradle.kts
Future Enhancements
Import student data from external Excel or CSV files.
Add configurable grading scales.
Automated email report generation.

License

This project is licensed under the MIT License. See the LICENSE file for details.


Author:

DJAMBOU NOUBIBOU Lareine Tracy – Student, ICT University


---

If you want, I can also **add professional badges** for Kotlin, Java, Gradle, Excel, and PDF support to make it **look like a polished GitHub project**. This will make your repository look top-tier at first glance.  

Do you want me to do that next?
