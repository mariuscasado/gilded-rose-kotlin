package katas.gildedrose

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GildedRoseTest {
    @Test
    fun sulfuras_is_immutable() {
        val sulfuras = Item("Sulfuras, Hand of Ragnaros", 0, 80)
        gildedRose = aGildedRoseWithItem(sulfuras)

        afterDays(10)

        assertItemsQuality(80, sulfuras)
        assertEquals(0, sulfuras.sellIn)
    }

    @Test
    fun sell_in_decreases_by_one_each_day() {
        val notSulfuras = Item("notSulfuras", 2, 0)
        gildedRose = aGildedRoseWithItem(notSulfuras)

        afterDays(10)

        assertEquals(-8, notSulfuras.sellIn)
    }

    @Test
    fun aged_brie_quality_increases_by_one_each_day_before_sell_date() {
        val agedBrie = Item("Aged Brie", 2, 0)
        gildedRose = aGildedRoseWithItem(agedBrie)

        afterDays(2)

        assertItemsQuality(2, agedBrie)
    }

    @Test
    fun aged_brie_quality_increases_by_two_each_day_after_sell_date() {
        val agedBrie = Item("Aged Brie", 0, 0)
        gildedRose = aGildedRoseWithItem(agedBrie)

        afterDays(2)

        assertItemsQuality(4, agedBrie)
    }

    @Test
    fun quality_Cannot_be_more_than_fifty() {
        val agedBrie = Item("Aged Brie", 2, 0)
        gildedRose = aGildedRoseWithItem(agedBrie)

        afterDays(300)

        assertItemsQuality(50, agedBrie)
    }

    @Test
    fun backstage_passes_quality_increases_by_one_each_day_before_ten_days_to_sell_date() {
        val backstagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 15, 0)
        gildedRose = aGildedRoseWithItem(backstagePasses)

        afterDays(5)

        assertItemsQuality(5, backstagePasses)
    }

    @Test
    fun backstage_passes_quality_increases_by_two_each_day_between_ten_and_five_days_before_sell_date() {
        val backstagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 15, 0)
        gildedRose = aGildedRoseWithItem(backstagePasses)

        afterDays(7)

        assertItemsQuality(9, backstagePasses)
    }

    @Test
    fun backstage_passes_quality_increases_by_three_each_day_between_five_days_and_the_sell_date() {
        val backstagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 15, 0)
        gildedRose = aGildedRoseWithItem(backstagePasses)

        afterDays(15)

        assertItemsQuality(30, backstagePasses)
    }

    @Test
    fun backstage_passes_quality_Is_zero_after_the_sell_date() {
        val backstagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)
        gildedRose = aGildedRoseWithItem(backstagePasses)

        afterDays(16)

        assertItemsQuality(0, backstagePasses)
    }

    @Test
    fun perishable_items_quality_decreases_by_one_each_day_before_sell_date() {
        val regularItem = Item("+5 Dexterity Vest", 10, 20)
        gildedRose = aGildedRoseWithItem(regularItem)

        afterDays(10)

        assertItemsQuality(10, regularItem)
    }

    @Test
    fun perishable_items_quality_decreases_by_two_each_day_after_sell_date() {
        val perishableItem = Item("+5 Dexterity Vest", 10, 20)
        gildedRose = aGildedRoseWithItem(perishableItem)

        afterDays(15)

        assertItemsQuality(0, perishableItem)
    }

    @Test
    fun perishable_items_quality_cannot_be_less_than_zero() {
        val perishableItem = Item("+5 Dexterity Vest", 10, 20)
        gildedRose = aGildedRoseWithItem(perishableItem)

        afterDays(200)

        assertItemsQuality(0, perishableItem)
    }

    private var gildedRose: GildedRose? = null

    private fun afterDays(numberOfDays: Int) {
        for (i in 0..numberOfDays - 1) {
            gildedRose!!.updateQuality()
        }
    }

    private fun assertItemsQuality(quality: Int, item: Item) {
        assertEquals(quality, item.quality)
    }

    private fun aGildedRoseWithItem(items: Item): GildedRose {
        return GildedRose(arrayOf(items))
    }
}
