interface A {
    fun method() {
        println("Hiii")
    }
}

class B : A {
    override fun method() {
        super.method()
        println("In B Class Method")
    }
}

fun main() {
    val obj = B()
    obj.method()
}

//In Kotlin, functional interfaces are interfaces with exactly one abstract function.