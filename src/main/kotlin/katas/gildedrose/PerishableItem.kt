package katas.gildedrose

open class PerishableItem(val item: Item) {

    private val MIN_QUALITY = 0
    private val MAX_QUALITY = 50

    open fun update() {
        decreaseQuality()

        item.sellIn--

        if (item.sellIn < 0) {
            decreaseQuality()
        }
    }

    private fun decreaseQuality() {
        if (item.quality > MIN_QUALITY) {
            item.quality--
        }
    }

    protected fun increaseQuality() {
        if (item.quality < MAX_QUALITY) {
            item.quality++
        }
    }
}