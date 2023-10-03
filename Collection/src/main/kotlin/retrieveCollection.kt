fun main() {

    val nums = listOf(1, 2, 3, 4, 5, 6)
    println(nums.slice(0..2))
    println(nums.take(4))
    println(nums.takeLast(4))
    println(nums.drop(1))
    println(nums.dropLast(3))

    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.takeWhile { !it.startsWith('f', ignoreCase = true) })
    println(numbers.takeLastWhile { it != "three" })
    println(numbers.dropWhile { it.length == 3 })
    println(numbers.dropLastWhile { it.contains('i') })

    // chunked

    val digit = (1..13).toList()
    println(digit.chunked(4))
    println(digit.windowed(2))
}