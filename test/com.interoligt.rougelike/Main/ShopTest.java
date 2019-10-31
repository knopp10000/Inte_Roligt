package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    Item firstItem = new Item("Sword", 2,2);
    Item secondItem = new Item("Shield", 2,2);
    Item thirdItem = new Item("Stone", 2,2);

    Item itemWithWorth100 = new Item("Sword", 2, 100);
    ArrayList<Item> items = new ArrayList<>();
    Inventory inventory = new Inventory(100, items);
    Player player = new Player(100, 100, 100, inventory);
    Shop shop = new Shop(1);




    @Test
    void testPurchaseMoneyEqualsItemWorth() {
        shop.setPlayer(player);
        shop.addItem(itemWithWorth100);
        player.addMoney(100);
        shop.buyItem(itemWithWorth100);
        assertEquals(0, player.getMoney());
    }


    @Test
    void testPurchaseWhileItemIsNull(){
        shop.setPlayer(player);
        player.addMoney(100);
        assertThrows(NullPointerException.class,
                ()->{
                   shop.buyItem(null);
                });
    }


    @Test
    void testPurchaseWithoutRequieredMoneyAmount(){
        shop.setPlayer(player);
        shop.addItem(firstItem);
        assertFalse(shop.buyItem(firstItem));
    }

    @Test
    void testPurchaseWithRequieredMoneyAmount(){
        shop.setPlayer(player);
        player.addMoney(100);
        shop.addItem(firstItem);
        assertTrue(shop.buyItem(firstItem));
        assertEquals(98, player.getMoney());
    }


    @Test
    void testExceededMaximumItems(){

        Shop emptyShop = new Shop(2);
        emptyShop.addItem(firstItem);
        emptyShop.addItem(secondItem);
        assertFalse(emptyShop.addItem(thirdItem));

    }

    @Test
    void testExceedMaximumItemsWithArrayList(){
        items.add(firstItem);
        items.add(secondItem);
        items.add(thirdItem);
        assertThrows(IllegalArgumentException.class, () -> new Shop(items, 2));
    }


}