enum class DAYS {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}

enum class RGB { RED, GREEN, BLUE }

fun main() {
    for (day in DAYS.entries) {
        println("${day.ordinal} = ${day.name}")
    }

    println("The first color is: ${RGB.valueOf("GREEN")}")
}
