fun Shop.getCustomersSortedByOrders(): List<Customer> {
    customers.sortedByDescending() { it.orders.size }
    for (customer in customers) {
        println(customer.orders)
    }

    customers.forEach {
        println(it.orders)
    }
    return customers
}

fun main() {
    println(ShopObject.shop.getCustomersSortedByOrders())
}