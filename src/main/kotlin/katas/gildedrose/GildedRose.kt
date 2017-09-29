package katas.gildedrose

class GildedRose(internal var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            TemporaryItem(items[i]).update()
        }
    }
}
