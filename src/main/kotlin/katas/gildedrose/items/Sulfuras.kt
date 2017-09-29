package katas.gildedrose.items

import katas.gildedrose.Item
import katas.gildedrose.PerishableItem

class Sulfuras(item: Item) : PerishableItem(item) {

    override fun update() {
        // Empty? Fishy...
    }
}