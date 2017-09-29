package katas.gildedrose

class GildedRose(internal var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            val item = items[i]

            if (item.name === "Aged Brie") {
                decreaseSellIn(item)
                if (item.quality < 50) {
                    increaseQuality(item)
                    if (item.sellIn < 0) {
                        increaseQuality(item)
                    }
                }
            } else if(item.name === "Backstage passes to a TAFKAL80ETC concert"){
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
            } else if(item.name === "Sulfuras, Hand of Ragnaros"){

            } else {
                if (item.quality > 0) {
                    decreaseQuality(item)
                }
                decreaseSellIn(item)
                if (item.sellIn < 0 && item.quality > 0) {
                    decreaseQuality(item)
                }
            }

            /*
            if (item.name != "Aged Brie" && item.name != "Backstage passes to a TAFKAL80ETC concert") {
                if (item.quality > 0 && item.name != "Sulfuras, Hand of Ragnaros") {
                    decreaseQuality(item)
                }
            } else if (item.quality < 50) {
                increaseQuality(item)

                if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                    if (item.sellIn < 11) {
                        increaseQuality(item)

                        if (item.sellIn < 6) {
                            increaseQuality(item)
                        }
                    }
                }
            }

            if (item.name != "Sulfuras, Hand of Ragnaros") {
                decreaseSellIn(item)
            }

            if (item.sellIn < 0) {
                if (item.name != "Aged Brie") {
                    if (item.name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (item.quality > 0 && item.name != "Sulfuras, Hand of Ragnaros") {
                            decreaseQuality(item)
                        }
                    } else {
                        item.quality = 0
                    }
                } else if (item.quality < 50) {
                    increaseQuality(item)
                }
            }
            */
        }
    }

    private fun decreaseSellIn(item: Item) {
        item.sellIn = item.sellIn - 1
    }

    private fun decreaseQuality(item: Item) {
        item.quality = item.quality - 1
    }

    private fun increaseQuality(item: Item) {
        item.quality = item.quality + 1
    }
}
