//fun Customer.getOrderedProducts(): List<Product> =
//    orders.flatMap(Order::products)

fun main() {
    val numbers = listOf(listOf(1, 2, 3, 4), listOf(5, 6, 7, 8))
    val flatmap = numbers.flatMap { it }
    println(flatmap)

    val normalMap = numbers.map { it }
    println(normalMap)

    println(numbers)

//    println(CustomerObject.customer.getOrderedProducts())
}