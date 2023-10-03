//fold() and reduce() are used to combine the elements of a collection into a single result
fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    val sum = numbers.fold(10) { acc, value ->
        acc + value
    }
    println(sum)

    val num = listOf(10, 20, 30, 40, 50)
    val add = num.reduce { acc, i -> acc + i }
    println(add)
}