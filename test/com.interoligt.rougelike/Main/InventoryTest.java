package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    Item gun = new Item("gun", 5, 20);
    Item sword = new Item("sword", 50, 30);
    Item boots = new Item("Boots", 15, 15);
    ArrayList<Item> items = new ArrayList<Item>(Arrays.asList(gun, sword, boots));


    Inventory inventoryToTest = new Inventory( 3, items);

   //Test to see if weight is not toomutch
    @Test
    void testGetWeight(){
    int weight = inventoryToTest.getWeight();
    assertTrue(weight == 70);
    }

    //Test to see how many Items are in inventory
    @Test
    void testGetItemCount() {
        int itemCount = inventoryToTest.getItemCount();
        assertTrue(itemCount == 3);
    }

    //Test to see how max Items in inventory
    @Test
    void testGetMaxItemCount() {
        int maxItemCount = inventoryToTest.getMaxItemCount();
        assertTrue(maxItemCount == 3);
    }

    @Test
    void testToManyItems(){
        Item hat = new Item("hat", 5, 20);
        assertThrows(Exception.class, () -> inventoryToTest.addItem(hat));
    }

    @Test
    void testTooManyItemsConstructor(){
        assertThrows(Exception.class, () -> new Inventory(2, items));
    }

    @Test
    void testFailItemCounter(){ assertThrows(Exception.class, () -> new Inventory(-1, items)); }

    @Test
    void testRemoveItem(){
       ArrayList<Item> whatShouldRemain = new ArrayList<>(Arrays.asList(sword, boots));
        inventoryToTest.removeItem(gun);
        assertEquals(whatShouldRemain,        inventoryToTest.showAllItems());
    }

    @Test
    void testRemoveNonExistingItem(){
        Item phone = new Item("phone", 5, 20);
        assertFalse(inventoryToTest.removeItem(phone));

    }

}
