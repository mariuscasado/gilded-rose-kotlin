package katas.gildedrose

open class PerishableItem(val item: Item) {

    val MAX_QUALITY = 50

    open fun update() {
        if (item.quality > 0) {
            item.quality--
        }

        item.sellIn--

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--
        }
    }

    protected fun increaseQuality() {
        if (item.quality < MAX_QUALITY) {
            item.quality++
        }
    }
}