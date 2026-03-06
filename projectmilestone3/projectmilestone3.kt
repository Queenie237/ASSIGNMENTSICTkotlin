// Milestone3_LareineTracy.kt

// Abstract class defining common behavior
abstract class User(
    open val id: Int,
    open val name: String
) {
    abstract fun getRole(): String

    override fun toString(): String {
        return "User(id=$id, name='$name', role='${getRole()}')"
    }
}

// Data class (automatically generates toString, equals, hashCode, copy)
data class Course(
    val courseId: Int,
    val title: String,
    val instructor: String
)

// Student class inheriting from User
class Student(
    override val id: Int,
    override val name: String,
    val enrolledCourses: MutableList<Course> = mutableListOf()
) : User(id, name) {

    override fun getRole(): String = "Student"

    fun enroll(course: Course) {
        enrolledCourses.add(course)
    }
}

// Instructor class inheriting from User
class Instructor(
    override val id: Int,
    override val name: String,
    val coursesTeaching: MutableList<Course> = mutableListOf()
) : User(id, name) {

    override fun getRole(): String = "Instructor"

    fun assignCourse(course: Course) {
        coursesTeaching.add(course)
    }
}

// Main function demonstrating polymorphism
fun main() {

    val kotlinCourse = Course(101, "Kotlin Programming", "Daniel MOUNE")
    val androidCourse = Course(102, "Android Development", "Daniel MOUNE")

    val student = Student(1, "Tracy")
    student.enroll(kotlinCourse)

    val instructor = Instructor(2, "Mr. Daniel")
    instructor.assignCourse(androidCourse)

    // Polymorphism: different subclasses stored as User
    val users: List<User> = listOf(student, instructor)

    users.forEach { println(it) }
}