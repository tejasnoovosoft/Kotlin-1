fun main() {
    val numbers = listOf("one", "two", "three", "four")
    println(numbers)
    println(numbers.joinToString())
    println(numbers.joinToString(separator = " | ", prefix = "Start ", postfix = " End"))
    println(numbers.joinToString(limit = 3, truncated = "<...>"))

    val listString = StringBuffer("The List of Numbers : ")
    println("$listString ${numbers.joinToString()}")
    numbers.joinTo(listString)
    println(listString)
}