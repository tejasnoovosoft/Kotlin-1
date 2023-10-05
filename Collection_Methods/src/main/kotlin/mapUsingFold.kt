fun <T, R> List<T>.foldImplementation(initialValue: R, operation: (R, T) -> R): R {
    var accumalatorValue = initialValue
    for (element in this) {
        accumalatorValue = operation(accumalatorValue, element)
    }
    return accumalatorValue
}

fun <T, R> mapImplementationUsingFold(list: List<T>, operation: (T) -> R): List<R> {
    return list.foldImplementation(mutableListOf()) { accumulator, element ->
        accumulator.apply { add(operation(element)) }
    }
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val result = numbers.foldImplementation(0) { acc, element -> acc + element }
    println(result)

    val res = mapImplementationUsingFold(numbers) { it * it }
    println(res)
}