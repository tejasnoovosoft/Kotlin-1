fun Shop.getGivenCustomerCity(city: City): List<Customer> = customers.filter { it.city == city }
fun Shop.getCustomerCities(): Set<City> = customers.map { it.city }.toSet()


fun main() {
    println(ShopObject.shop.getCustomerCities())
    println(ShopObject.shop.getGivenCustomerCity(City("Pune")))
}