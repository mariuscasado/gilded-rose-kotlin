package katas.gildedrose.items

import katas.gildedrose.Item
import katas.gildedrose.PerishableItem

class AgedBrie(item: Item) : PerishableItem(item) {

    override fun update() {
        if (item.quality < 50) {
            item.quality = item.quality + 1
        }

        item.sellIn = item.sellIn - 1

        if (item.sellIn < 0 && item.quality < 50) {
            item.quality = item.quality + 1
        }
    }
}