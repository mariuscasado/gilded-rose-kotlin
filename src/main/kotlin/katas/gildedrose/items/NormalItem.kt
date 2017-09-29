package katas.gildedrose.items

import katas.gildedrose.Item

class NormalItem : AbstractItem() {

    override fun updateQuality(item: Item) {
        if (item.quality > 0) {
            decreaseQuality(item)
        }
        decreaseSellIn(item)
        if (item.sellIn < 0 && item.quality > 0) {
            decreaseQuality(item)
        }
    }
}