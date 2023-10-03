fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> =
    customers.filter { it ->
        val (delivered, undelivered) =
            it.orders.partition { it.isDelivered }
        undelivered.size > delivered.size
    }.toSet()

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
    val (odd, even) = numbers.partition { it % 2 != 0 }
    println(odd)
    println(even)
    println(ShopObject.shop.getCustomersWithMoreUndeliveredOrders())
}