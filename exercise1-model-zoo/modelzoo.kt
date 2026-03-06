abstract class Animal(
    val name: String,
    open val legs: Int
) {
    abstract fun makeSound()

    fun describe() {
        println("$name has $legs legs.")
    }
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

    animals.forEach {
        it.describe()
        it.makeSound()
        println()
    }
}