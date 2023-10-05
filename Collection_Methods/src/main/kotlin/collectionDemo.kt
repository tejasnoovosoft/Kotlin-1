fun <T, C> mapImplementation(list: List<T>, operation: (T) -> C): List<C> {
    val result = mutableListOf<C>()
    for (element in list) {
        result.add(operation(element))
    }
    return result
}

fun <T> filterImplementation(list: List<T>, operation: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (element in list) {
        if (operation(element)) {
            result.add(element)
        }
    }
    return result
}

fun <T> reduceImplementation(list: List<T>, operation: (T, T) -> T): T {

//    if (list.isEmpty()) throw UnsupportedOperationException("List is Empty")
//
//    var accumulatorValue = list[0]
//    for (element in 1..<list.size) {
//        accumulatorValue = operation(accumulatorValue, list[element])
//    }
//    return accumulatorValue
    val iterator = list.iterator()
    if (!iterator.hasNext()) throw UnsupportedOperationException("Empty Collection")
    var accumulatorValue: T = iterator.next()
    while (iterator.hasNext()) {
        accumulatorValue = operation(accumulatorValue, iterator.next())
    }
    return accumulatorValue
}

fun <T, R> foldIndexedImplementation(initialValue: R, list: List<T>, operation: (Int, R, T) -> R): R {
    var accumulatorValue: R = initialValue
    var index = 0
    for (element in list) {
        accumulatorValue = operation(index++, accumulatorValue, element)
    }
    return accumulatorValue
}

fun <T, R> foldRightImplementation(initialValue: R, list: List<T>, operation: (R, T) -> R): R {
    var accumulatorValue = initialValue
    val itr = list.listIterator(list.size)
    while (itr.hasPrevious()) {
        accumulatorValue = operation(accumulatorValue, itr.previous())
    }
    return accumulatorValue
}

fun <T, R> foldRightIndexedImplementation(initialValue: R, list: List<T>, operation: (Int, R, T) -> R): R {

//    var accumulatorValue = initialValue
//    var index = list.size - 1
//    for (element in list.asReversed()) {
//        accumulatorValue = operation(index--, accumulatorValue, element)
//    }
//    return accumulatorValue

    var accumulatorValue = initialValue
    val itr = list.listIterator(list.size)
    while (itr.hasPrevious()) {
        accumulatorValue = operation(itr.previousIndex(), accumulatorValue, itr.previous())
    }
    return accumulatorValue
}

fun <T> filterImplementationUsingFold(list: List<T>, operation: (T) -> Boolean): List<T> {
    return list.fold(mutableListOf<T>()) { result, element ->
        if (operation(element)) {
            result.add(element)
        }
        result
    }
}

fun main() {

    val number = listOf(2, 2, 3, 4, 5)
    val names = listOf("av", "acx", "dfg", "xyz")
    val words = listOf("Hello", " ", "Kotlin", " ", "World")
//    val words = emptyList<String>()
    val sumNumbers = number.reduce { sum, element ->
        sum + element
    }

    println(sumNumbers)

    val multipleByThree = mapImplementation(number) { a -> 3 * a }
    println(multipleByThree)

    val getLength = mapImplementation(names) { b -> b.length }
    println(getLength)

    val getEvenNumbers = filterImplementation(number) { value -> value % 2 == 0 }
    println(getEvenNumbers)

    val sumOfElements = number.foldImplementation(0) { acc, element -> acc + element }
    println(sumOfElements)

    val getLengthOfListElements = names.foldImplementation(0) { acc, user -> acc + user.length }
    println(getLengthOfListElements)

    val multiplicationOfElements = reduceImplementation(number) { acc, element -> acc * element }
    println(multiplicationOfElements)

    val sentence = reduceImplementation(words) { acc, word -> acc + word }
    println(sentence)

    val sumOfNumbers = foldIndexedImplementation(0, number) { _, acc, element -> acc + element }
    println(sumOfNumbers)

    val concatNumbers = foldRightImplementation("", number) { acc, element -> "$acc$element " }
    println(concatNumbers)

    val concatWords = foldRightIndexedImplementation("", words) { _, acc, word -> "$acc$word " }
    println(concatWords)

    val getSquareOfNumbers = mapImplementationUsingFold(number) { it * it }
    println(getSquareOfNumbers)

    val getOddNumbers = filterImplementationUsingFold(number) { it % 2 != 0 }
    println(getOddNumbers)
}
