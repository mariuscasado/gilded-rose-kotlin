package katas.gildedrose.items

import katas.gildedrose.Item

abstract class AbstractItem {

    public abstract fun updateQuality(item: Item)

    protected fun decreaseSellIn(item: Item) {
        item.sellIn = item.sellIn - 1
    }

    protected fun decreaseQuality(item: Item) {
        item.quality = item.quality - 1
    }

    protected fun increaseQuality(item: Item) {
        item.quality = item.quality + 1
    }
}