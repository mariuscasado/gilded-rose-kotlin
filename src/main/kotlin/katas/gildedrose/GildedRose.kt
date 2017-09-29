package katas.gildedrose

import katas.gildedrose.items.AgedBrie
import katas.gildedrose.items.BackstagePass
import katas.gildedrose.items.Sulfuras

class GildedRose(internal var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            item(items[i]).update()
        }
    }

    private fun item(item: Item) = when {
        item.name.equals("Aged Brie") -> AgedBrie(item)
        item.name.equals("Backstage passes to a TAFKAL80ETC concert") -> BackstagePass(item)
        item.name.equals("Sulfuras, Hand of Ragnaros") -> Sulfuras(item)
        else -> TemporaryItem(item)
    }
}
