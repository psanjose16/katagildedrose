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
}