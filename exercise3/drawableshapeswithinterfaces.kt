// Exercise 3: Drawable Shapes

interface Drawable {
    fun draw()
}

class Circle(private val radius: Int) : Drawable {
    override fun draw() {
        println("Circle (radius = $radius)")
        println(" *** ")
        println(" *   * ")
        println(" *** ")
        println()
    }
}

class Square(private val side: Int) : Drawable {
    override fun draw() {
        println("Square (side = $side)")
        repeat(side) {
            println("* ".repeat(side))
        }
        println()
    }
}

fun main() {
    val shapes: List<Drawable> = listOf(
        Circle(3),
        Square(3)
    )

    shapes.forEach { it.draw() }
}