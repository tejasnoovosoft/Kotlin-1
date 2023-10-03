fun main() {
    val names = listOf("fox", "lion", "tiger")
    val colors = listOf("red", "yellow", "orange")
    println(names zip colors)

    val names1 = listOf("fox", "lion", "tiger", "cat")
    val colors1 = listOf("red", "yellow", "orange")
    println(colors1 zip names1)
}