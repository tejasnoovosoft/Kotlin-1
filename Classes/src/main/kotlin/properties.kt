class Example {
    var counter = 0
        set(value) {
            if (value >= 0) {
                field = value // Using the backing field to store the value
            }
        }
}

class TestSubject {
    fun method() {
        println("In Test Subject Class")
    }
}

class MyTest {
    private lateinit var subject: TestSubject

    fun setup() {
        subject = TestSubject()
    }

    fun test() {
        subject.method()  // dereference directly
    }
}

fun main() {
    val example = Example()
    example.counter = 42
    println(example.counter)

    example.counter = -1
    println(example.counter)
}

//In Kotlin, a lazy-initialized property is a property whose value is computed only upon first access.
// This means that the property is not initialized until it's actually used for the first time.
