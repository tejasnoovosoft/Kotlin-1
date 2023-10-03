fun moneySpendBy(customer: Customer): Double = customer.orders.flatMap { it.products }.sumOf { it.price }


fun main() {
    println(moneySpendBy(CustomerObject.customer))
}