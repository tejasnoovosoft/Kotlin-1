fun Shop.getCustomerWithMaxOrder(): Customer? = customers.maxByOrNull { it.orders.size }
fun getExpensiveProduct(customer: Customer): Product? =
    customer.orders.flatMap(Order::products).maxByOrNull(Product::price)

fun main() {
    println(ShopObject.shop.getCustomerWithMaxOrder())
    CustomerObject.customers.forEach {
        println(getExpensiveProduct(it))
    }
}