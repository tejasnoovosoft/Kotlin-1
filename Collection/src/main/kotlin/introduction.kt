object ShopObject {
    val shop = Shop("Shop1", customers)
}


object CustomerObject {
    var customer = Customer(
        "Sadid", City("Solapur"), listOf(
            Order(listOf(Product("Charger", 730.00), Product("Cable", 500.00)), false), Order(
                listOf(Product("Iphone", 38000.00)), true
            )
        )
    )

    val customers = listOf(
        Customer(
            "Sadid", City("Solapur"), listOf(
                Order(listOf(Product("Charger", 730.00), Product("Cable", 500.00)), false), Order(
                    listOf(Product("Iphone", 38000.00)), true
                )
            )
        ),
        Customer(
            "Vaishnav", City("Akola"), listOf(Order(listOf(Product("MacBook", 83000.00)), true))
        ),
        Customer(
            "Harshit", City("Rajkot"), listOf(Order(listOf(Product("Bulb", 100.00)), false))
        ),
        Customer(
            "Pulkit",
            City("Rajstan"),
            listOf(Order(listOf(Product("Mobile", 23500.00), Product("Cover", 200.00)), true))
        ),
        Customer(
            "Tejas", City("Pune"), listOf(Order(listOf(Product("Airbuds", 1800.00)), true))
        ),
        Customer(
            "Shreyas", City("Pune"), listOf(Order(listOf(Product("Shirt", 1500.00)), true))
        ),
    )
}

fun Shop.getSetOfCustomers(): Set<Customer> =
    customers.toSet()

val customers = listOf(
    Customer(
        "Sadid", City("Solapur"), listOf(
            Order(listOf(Product("Charger", 730.00), Product("Cable", 500.00)), false), Order(
                listOf(Product("Iphone", 38000.00)), true
            )
        )
    ),
    Customer(
        "Vaishnav", City("Akola"), listOf(Order(listOf(Product("MacBook", 83000.00)), true))
    ),
    Customer(
        "Harshit", City("Rajkot"), listOf(Order(listOf(Product("Bulb", 100.00)), false))
    ),
    Customer(
        "Pulkit", City("Rajstan"), listOf(Order(listOf(Product("Mobile", 23500.00), Product("Cover", 200.00)), true))
    ),
    Customer(
        "Tejas", City("Pune"), listOf(Order(listOf(Product("Airbuds", 1800.00)), true))
    ),
    Customer(
        "Shreyas", City("Pune"), listOf(Order(listOf(Product("Shirt", 1500.00)), true))
    ),
)

fun main() {
    val shop = Shop(
        "Shop1", customers
    )
    println(shop.getSetOfCustomers())
}