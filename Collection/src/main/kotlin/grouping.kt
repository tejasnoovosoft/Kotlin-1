fun Shop.groupCustomersByCity(): Map<City, List<Customer>> = customers.groupBy { it.city }

fun main() {
    val result = listOf("a", "b", "ba", "ccc", "ad").groupBy { it.length }

    println(result)

    val numbers = listOf("One", "Two", "Three", "Four", "Five")
    println(numbers.groupBy { it.length })

    println(ShopObject.shop.groupCustomersByCity())
}