//Kotlin: In Kotlin, all classes are final by default, meaning they cannot be inherited unless explicitly marked with the open keyword
//Java: In Java, classes are non-final by default, which means they can be inherited unless explicitly marked with the final keyword.
// In Kotlin, derived classes need to initialize the base class constructor using the super keyword and in java not need to initialize

open class Shape1 {
    open val vertexCount: Int = 0
}

class Rectangle : Shape1() {
    override val vertexCount = 4
}

interface Radius {
    val radiusOfCircle: Int
}

class Circle1(override val radiusOfCircle: Int = 20) : Radius {

}

open class Base {
    init {
        println("In Base Class")
    }
}


open class Rectangle1 {
    open fun draw() { println("Drawing a rectangle") }
    val borderColor: String get() = "black"
}

class FilledRectangle : Rectangle1() {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }

    val fillColor: String get() = super.borderColor
}
fun main() {
    val obj = Shape1()
    println(obj.vertexCount)
    val obj2 = Rectangle()
    println(obj2.vertexCount)


    val obj3 = FilledRectangle()
    obj3.draw()
    println(obj3.fillColor)
}