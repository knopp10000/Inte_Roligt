package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestItem {

    Item itemToTest = new Item("qwer", 1, 1);

    //Check name contains letters
    @Test
    void testName(){
        String name = itemToTest.getName();
        assertFalse(name.isBlank() && name.isEmpty());
    }
    //Check item has worth
    @Test
    void testWorth(){
        int worth = itemToTest.getWorth();
        assertTrue(worth > 0);
    }
    //Check item has weight
    @Test
    void testWeight(){
        int weight = itemToTest.getWeight();
        assertTrue(weight > 0);
    }

    //Assert throws
    @Test
    void assertEmptyNameThrow(){
        assertThrows(IllegalArgumentException.class, () -> new Item("", 1, 1));
    }
    @Test
    void assertBlankNameThrow(){
        assertThrows(IllegalArgumentException.class, () -> new Item(" ", 1, 1));
    }

    @Test
    void assertWorthThrow(){
        assertThrows(IllegalArgumentException.class, () -> new Item("qwer", 1, 0));
    }
    @Test
    void assertWeightThrow(){
        assertThrows(IllegalArgumentException.class, () -> new Item("qwer", 0, 1));
    }
}
