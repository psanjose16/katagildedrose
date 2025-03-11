package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(Math.max(0, app.items[0].quality), app.items[0].quality);
    }

    @Test
    void agedBrieIncreasesInQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void backstagePassesIncreaseInQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(14, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void backstagePassesIncreaseInQualityBy3When5DaysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
    }

    @Test
    void backstagePassesDropToZeroQualityAfterConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void sulfurasNeverDecreasesInQualityOrSellIn() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void qualityNeverExceedsFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void qualityNeverNegative() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void conjuredItemsDegradeTwiceAsFast() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void conjuredItemsDegradeTwiceAsFastAfterSellIn() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void agedBrieIncreasesInQualityAfterSellIn() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void multipleItemsUpdateCorrectly() {
        Item[] items = new Item[] {
            new Item("Aged Brie", 2, 0),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("foo", 0, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(14, app.items[1].sellIn);
        assertEquals(21, app.items[1].quality);
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[2].name);
        assertEquals(0, app.items[2].sellIn);
        assertEquals(80, app.items[2].quality);
        assertEquals("foo", app.items[3].name);
        assertEquals(-1, app.items[3].sellIn);
        assertEquals(0, app.items[3].quality);
    }

    @Test
    void agedBrieQualityIncreasesTwiceAsFastAfterSellIn() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void normalItemDegradesTwiceAsFastAfterSellIn() {
        Item[] items = new Item[] { new Item("foo", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
void normalItemDegradesQualityBeforeSellIn() {
    Item[] items = new Item[] { new Item("foo", 5, 10) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("foo", app.items[0].name);
    assertEquals(4, app.items[0].sellIn);
    assertEquals(9, app.items[0].quality);
}

    @Test
    void normalItemDegradesQualityBeforeSellInToZero() {
        Item[] items = new Item[] { new Item("foo", 5, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void normalItemDegradesQualityAfterSellInToZero() {
        Item[] items = new Item[] { new Item("foo", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
void normalItemDegradesQualityAfterSellIn() {
    Item[] items = new Item[] { new Item("foo", -1, 10) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("foo", app.items[0].name);
    assertEquals(-2, app.items[0].sellIn);
    assertEquals(8, app.items[0].quality);
}

@Test
void backstagePassesIncreaseInQualityBy2When10DaysOrLess() {
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
    assertEquals(9, app.items[0].sellIn);
    assertEquals(22, app.items[0].quality);
}

}