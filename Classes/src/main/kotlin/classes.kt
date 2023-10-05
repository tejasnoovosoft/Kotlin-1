class Demo(name: String) {
    init {
        println("In Init block")
    }

    val getName = name.toUpperCase();
}

class Demo2 {
    private var name: String
    private var rollNo: Int;

    constructor(name: String, rollNo: Int) {
        this.name = name
        this.rollNo = rollNo
    }

}

class DontCreateMe private constructor() {

}

abstract class Square {
    abstract fun area();
}

open class Circle{
    open fun area(){
        println("Area of Circle is 2Unit")
    }
}
class Shape : Square() {
    override fun area() {
        println("Area is Square is .....")
    }
}

fun main() {
    val obj = Demo("tejas")
    println(obj.getName)

//    val obj2 = DontCreateMe()

}