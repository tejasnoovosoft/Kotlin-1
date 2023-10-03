fun Shop.checkAllCustomer(city: City): Boolean = customers.all { it.city == city }

fun Shop.checkAnyCustomer(city: City): Boolean = customers.any { it.city == city }

fun Shop.checkCountOfCustomers(city: City): Int = customers.count { it.city == city }

fun Shop.findCustomer(city: City): Customer? = customers.find { it.city == city && it.name == "Shreyas" }

fun main() {
    println(ShopObject.shop.checkAllCustomer(City("Pune")))
    println(ShopObject.shop.checkAnyCustomer(City("Pune")))
    println(ShopObject.shop.checkCountOfCustomers(City("Pune")))
    println(ShopObject.shop.findCustomer(City("Pune")))
}
