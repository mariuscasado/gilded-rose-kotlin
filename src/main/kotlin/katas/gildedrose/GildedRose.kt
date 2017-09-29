package katas.gildedrose

import katas.gildedrose.items.AbstractItem
import katas.gildedrose.items.AgedBrie
import katas.gildedrose.items.Backstage
import katas.gildedrose.items.NormalItem

class GildedRose(internal var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            val item = items[i]

            if(item.name === "Sulfuras, Hand of Ragnaros"){
                continue;
            }

            when {
                item.name.equals("Aged Brie") -> AgedBrie()
                item.name.equals("Backstage passes to a TAFKAL80ETC concert") -> Backstage()
                else -> NormalItem()
            }.updateQuality(item)

        }
    }
}
