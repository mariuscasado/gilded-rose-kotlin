package katas.gildedrose.items

import katas.gildedrose.Item
import katas.gildedrose.PerishableItem

class AgedBrie(item: Item) : PerishableItem(item) {

    override fun update() {
        if (item.quality < 50) {
            increaseQuality()
        }

        item.sellIn--

        if (item.sellIn < 0) {
            increaseQuality()
        }
    }
}