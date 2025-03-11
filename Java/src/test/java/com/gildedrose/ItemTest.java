package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;



public class ItemTest {

    @Test
    public void testItemConstructor() {
        Item item = new Item("Test Item", 10, 20);
        assertEquals("Test Item", item.name);
        assertEquals(10, item.sellIn);
        assertEquals(20, item.quality);
    }

    @Test
    public void testToString() {
        Item item = new Item("Test Item", 10, 20);
        assertEquals("Test Item, 10, 20", item.toString());
    }

@Test
public void testItemConstructorWithZeroValues() {
    Item item = new Item("Test Item", 0, 0);
    assertEquals("Test Item", item.name);
    assertEquals(0, item.sellIn);
    assertEquals(0, item.quality);
}

@Test
public void testItemConstructorWithNegativeValues() {
    Item item = new Item("Test Item", -1, -1);
    assertEquals("Test Item", item.name);
    assertEquals(-1, item.sellIn);
    assertEquals(-1, item.quality);
}

@Test
public void testUpdateQualityNormalItem() {
    Item[] items = new Item[] { new Item("Normal Item", 10, 20) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(9, app.items[0].sellIn);
    assertEquals(19, app.items[0].quality);
}

@Test
public void testUpdateQualityAgedBrie() {
    Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(9, app.items[0].sellIn);
    assertEquals(21, app.items[0].quality);
}

@Test
public void testUpdateQualityBackstagePasses() {
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(9, app.items[0].sellIn);
    assertEquals(22, app.items[0].quality);
}

@Test
public void testUpdateQualitySulfuras() {
    Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(10, app.items[0].sellIn);
    assertEquals(80, app.items[0].quality);
}

@Test
public void testUpdateQualityConjuredItem() {
    Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 20) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(9, app.items[0].sellIn);
    assertEquals(18, app.items[0].quality);
}

@Test
public void testUpdateQualityExpiredNormalItem() {
    Item[] items = new Item[] { new Item("Normal Item", 0, 20) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(-1, app.items[0].sellIn);
    assertEquals(18, app.items[0].quality);
}

@Test
public void testUpdateQualityExpiredAgedBrie() {
    Item[] items = new Item[] { new Item("Aged Brie", 0, 20) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(-1, app.items[0].sellIn);
    assertEquals(22, app.items[0].quality);
}

@Test
public void testUpdateQualityExpiredBackstagePasses() {
    Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(-1, app.items[0].sellIn);
    assertEquals(0, app.items[0].quality);
}

@Test
public void testUpdateQualityExpiredConjuredItem() {
    Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 20) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(-1, app.items[0].sellIn);
    assertEquals(16, app.items[0].quality);
}
}