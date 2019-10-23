package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    Item firstItem = new Item("Sword", 2,2);
    Item secondItem = new Item("Shield", 2,2);
    Item thirdItem = new Item("Stone", 2,2);



    @Test
    void testExceededMaximumItems(){

        Shop emptyShop = new Shop(2);
        emptyShop.addItem(firstItem);
        emptyShop.addItem(secondItem);
        assertFalse(emptyShop.addItem(thirdItem));

    }

    @Test
    void testExceedMaximumItemsWithArrayList(){
        ArrayList<Item> items = new ArrayList<>();
        items.add(firstItem);
        items.add(secondItem);
        items.add(thirdItem);
        assertThrows(IllegalArgumentException.class, () -> new Shop(items, 2));
    }


}