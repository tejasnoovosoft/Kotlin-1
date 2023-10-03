fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, null, 6, 7, 8, 9)
    println(numbers.filter { it != null && it % 2 != 0 })
    println(numbers.filterIndexed { index, i -> i != null && index != 0 && i % 2 != 0 })
    println(numbers.filterNotNull())
    println(numbers.filterNot { it == null })
}