//Sequences are useful when you need to perform multiple operations on a collection without creating intermediate
// collections at each step.

fun findMostExpensiveProductBy(customer: Customer): Product? {
    return customer.orders.asSequence().filter(Order::isDelivered).flatMap(Order::products).maxByOrNull(Product::price)
}

fun Customer.getOrderedProducts(): Sequence<Product> = orders.asSequence().flatMap(Order::products)

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)

    val result = numbers.filter { it % 2 == 0 }.map { it * 2 }.toList()

    println(result)

    val numbers1 = sequenceOf(1, 2, 3, 4, 5)

    val result1 = numbers1.filter { it % 2 == 0 }.map { it * 2 }.toList()

    println(result1)

    // cannot create a intermediate collection until call to the toList() function

    println(findMostExpensiveProductBy(CustomerObject.customer))
    println(CustomerObject.customer.getOrderedProducts().toList())
}