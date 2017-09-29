package katas.gildedrose

import katas.gildedrose.items.AgedBrie

class GildedRose(internal var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            item(items[i]).update()
        }
    }

    private fun item(item: Item) = when {
        item.name.equals("Aged Brie") -> AgedBrie(item)
        else -> TemporaryItem(item)
    }
}
