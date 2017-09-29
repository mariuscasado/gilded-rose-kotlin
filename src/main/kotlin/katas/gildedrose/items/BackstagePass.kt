package katas.gildedrose.items

import katas.gildedrose.Item
import katas.gildedrose.PerishableItem

class BackstagePass(item: Item) : PerishableItem(item) {

    override fun update() {
        increaseQuality()

        if (item.sellIn < 11) {
            increaseQuality()
        }

        if (item.sellIn < 6) {
            increaseQuality()
        }

        item.sellIn--

        if (item.sellIn < 0) {
            item.quality = 0
        }
    }
}