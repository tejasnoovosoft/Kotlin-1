data class Item(val width: Int, val length: Int, val isStackable: Boolean, val quantity: Int)
data class NormalizedUnits(val width: Int, val length: Int, val isStackable: Boolean, val isStacked: Boolean)

fun normalize(n: Int): Int = ((n + 19) / 20) * 20

fun createUnit(item: Item): NormalizedUnits {
    return NormalizedUnits(
        width = normalize(item.width),
        length = normalize(item.length),
        isStackable = item.isStackable,
        isStacked = false
    )
}

fun main() {
    val items = listOf(
        Item(99, 35, true, 10),
        Item(85, 37, true, 5),
        Item(100, 55, false, 20),
        Item(45, 67, true, 17)
    )

    val units = items.flatMap { item ->
        List(item.quantity) { createUnit(item) }
    }

    val (stackable, unStackable) = units.partition { it.isStackable }

    val stackableGroups = stackable.groupBy { "${it.width}x${it.length}" }.values

    fun stack(normalizedUnits: List<NormalizedUnits>): List<NormalizedUnits> {
        return normalizedUnits.chunked(2).map { chunk ->
            if (chunk.size == 2) chunk[0].copy(isStacked = true) else chunk[0]
        }
    }

    val stacked = stackableGroups.flatMap { stack(it) }

    val result = stacked + unStackable
    result.forEach { println(it) }
}
