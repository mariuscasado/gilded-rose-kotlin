package katas.gildedrose.items

import katas.gildedrose.Item

class AgedBrie: AbstractItem() {

    override fun updateQuality(item: Item) {
        decreaseSellIn(item)
        if (item.quality < 50) {
            increaseQuality(item)
            if (item.sellIn < 0) {
                increaseQuality(item)
            }
        }
    }
}