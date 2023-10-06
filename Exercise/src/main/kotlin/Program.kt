import kotlin.math.ceil

data class Item(val width: Int, val length: Int, val isStackable: Boolean, val quantity: Int)

fun normalizeDimension(value: Int): Int {
    return (20 * ceil(value.toDouble() / 20)).toInt()
}

fun createUnitMap(width: Int, length: Int, isStackable: Boolean, isStacked: Boolean): Map<String, Any> {
    return mutableMapOf(
        "width" to width, "length" to length, "isStackable" to isStackable, "isStacked" to isStacked
    )
}

fun calculateNormalizedUnits(items: List<Item>): List<Map<String, Any>> {

    val normalizedUnits = mutableListOf<Map<String, Any>>()
    items.map { item ->
        if (item.isStackable) {
            val normalizedWidth = normalizeDimension(item.width)
            val normalizedLength = normalizeDimension(item.length)

            val halfQuantity = item.quantity / 2

            repeat(halfQuantity) {
                normalizedUnits.add(createUnitMap(normalizedWidth, normalizedLength, item.isStackable, true))
            }

            if (item.quantity % 2 != 0) {
                normalizedUnits.add(createUnitMap(normalizedWidth, normalizedLength, item.isStackable, false))
            }
        } else {
            repeat(item.quantity) {
                normalizedUnits.add(createUnitMap(item.width, item.length, item.isStackable, false))
            }
        }
    }
    return normalizedUnits
}

fun main() {
    val items = listOf(
        Item(99, 35, true, 10), Item(85, 37, true, 5), Item(100, 55, false, 20), Item(45, 67, true, 17)
    )
    val normalizedUnits = calculateNormalizedUnits(items)
    normalizedUnits.map { println(it) }
}