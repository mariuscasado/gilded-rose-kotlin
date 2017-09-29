package katas.gildedrose.items

import katas.gildedrose.Item

class Backstage: AbstractItem(){

    override fun updateQuality(item: Item) {
        if (item.quality < 50) {
            increaseQuality(item)
            if (item.sellIn < 11) {
                increaseQuality(item)

                if (item.sellIn < 6) {
                    increaseQuality(item)
                }
            }
        }
        decreaseSellIn(item)
        if (item.sellIn < 0) {
            item.quality = 0
        }
    }
}