fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val listIterator = numbers.listIterator()
    while (listIterator.hasNext()) {
        println(listIterator.next())
    }
    println("Iterating backwards:")
    while (listIterator.hasPrevious()) {
        print("Index: ${listIterator.previousIndex()}")
        println(", value: ${listIterator.previous()}")
    }

    val num = mutableListOf(1, 2, 3, 4, 5)
    val mutableIterator = num.iterator()
    mutableIterator.next()
    mutableIterator.remove()
    println(num)
}