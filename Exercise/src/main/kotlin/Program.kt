import kotlin.math.ceil

data class Item(val width: Int, val length: Int, val isStackable: Boolean, val quantity: Int)

fun normalizeDimension(value: Int): Int {
    return (20 * ceil(value.toDouble() / 20)).toInt()
}

fun createUnit(width: Int, length: Int, isStackable: Boolean, isStacked: Boolean): Map<String, Any> {
    return mapOf(
        "width" to width, "length" to length, "isStackable" to isStackable, "isStacked" to isStacked
    )
}

/*fun calculateNormalizedUnits(items: List<Item>): List<Map<String, Any>> {

    val normalizedUnits = mutableListOf<Map<String, Any>>()
    items.map { item ->
        if (item.isStackable) {
            val normalizedWidth = normalizeDimension(item.width)
            val normalizedLength = normalizeDimension(item.length)

            val halfQuantity = item.quantity / 2

            repeat(halfQuantity) {
                normalizedUnits.add(createUnit(normalizedWidth, normalizedLength, item.isStackable, true))
            }

            if (item.quantity % 2 != 0) {
                normalizedUnits.add(createUnit(normalizedWidth, normalizedLength, item.isStackable, false))
            }
        } else {
            repeat(item.quantity) {
                normalizedUnits.add(createUnit(item.width, item.length, item.isStackable, false))
            }
        }
    }
    return normalizedUnits
}*/

fun List<Item>.calculateNormalizedUnits(): List<Map<String, Any>> {
    return this.flatMap { item ->
        val normalizedWidth = normalizeDimension(item.width)
        val normalizedLength = normalizeDimension(item.length)
        val halfQuantity = item.quantity / 2

        val stackedUnits = if (item.isStackable) {
            List(halfQuantity) {
                createUnit(normalizedWidth, normalizedLength, item.isStackable, true)
            }
        } else {
            emptyList()
        }

        val unstackedUnit = if (item.isStackable && item.quantity % 2 != 0) {
            listOf(createUnit(normalizedWidth, normalizedLength, item.isStackable, false))
        } else {
            emptyList()
        }

        val nonStackableUnits = if (!item.isStackable) {
            List(item.quantity) {
                createUnit(normalizedWidth, normalizedLength, item.isStackable, false)
            }
        } else {
            emptyList()
        }
        stackedUnits + unstackedUnit + nonStackableUnits
    }
}

fun main() {
    val items = listOf(
        Item(99, 35, true, 10), Item(85, 37, true, 5), Item(100, 55, false, 20), Item(45, 67, true, 17)
    )
    val normalizedUnits = items.calculateNormalizedUnits()
    normalizedUnits.forEach { println(it) }
}