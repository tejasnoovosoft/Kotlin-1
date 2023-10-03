data class User(val id: Int, val name: String)

// keys selector
fun Shop.nameToCustomerMap(): Map<String, Customer> = customers.associateBy(Customer::name)

// value selector
fun Shop.customerToCityMap(): Map<Customer, City> = customers.associateWith(Customer::city)

fun main() {

    val users = listOf(User(1, "Alice"), User(2, "Bob"), User(3, "Charlie"))
    val res = users.associateBy { it.id }
    println(res)

    println(ShopObject.shop.nameToCustomerMap())
    println(ShopObject.shop.customerToCityMap())

    val numbers = listOf("one", "two", "three", "four")
    println(numbers.associateBy { it.length })
    println(numbers.associateWith { it.length })
}