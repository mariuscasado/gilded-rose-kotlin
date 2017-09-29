package katas.gildedrose

open class PerishableItem(val item: Item) {

    open fun update() {
        if (item.quality > 0) {
            item.quality = item.quality - 1
        }

        item.sellIn = item.sellIn - 1

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 1
        }
    }
}