package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    Item firstItem = new Item("Sword", 2,100);
    Item secondItem = new Item("Shield", 2,100);
    Item thirdItem = new Item("Stone", 2,100);
    Item fourthItem = new Item("Sword", 2, 100);

    ArrayList<Item> items = new ArrayList<>();
    Inventory inventory = new Inventory(4, items);
    Player player = new Player(100, 100, 100, inventory);
    Shop shop = new Shop(items,1);


    @BeforeEach
    void setPlayer(){
        shop.setPlayer(player);
        player.addMoney(500);
    }

    //T6
    @Test
    void testPurchaseWhilePlayersInventoryHasSpace(){
        shop.buyItem(firstItem);
        shop.buyItem(secondItem);
        shop.buyItem(thirdItem);
        assertTrue(shop.buyItem(fourthItem));
    }

    //T7
    @Test
    void testPurchaseWhilePlayersInventoryIsFull(){
        items.add(firstItem);
        items.add(secondItem);
        items.add(thirdItem);
        items.add(fourthItem);
        assertFalse(shop.buyItem(secondItem));
    }

    //T3
    @Test
    void testPurchaseMoneyEqualsItemWorth() {
        shop.addItem(fourthItem);
        player.withdrawMoney(400);
        shop.buyItem(fourthItem);
        assertEquals(0, player.getMoney());
    }

    //T4
    @Test
    void testPurchaseWhileItemIsNull(){
        assertThrows(NullPointerException.class,
                ()->{
                   shop.buyItem(null);
                });
    }

    //T1
    @Test
    void testPurchaseWithMoneyAmount0(){
        player.withdrawMoney(500);
        shop.addItem(firstItem);
        assertFalse(shop.buyItem(firstItem));
    }

    //T2
    @Test
    void testPurchaseWithoutRequieredMoneyAmount(){
        player.withdrawMoney(450);
        assertFalse(shop.buyItem(firstItem));
    }

    //T5
    @Test
    void testPurchaseWithRequieredMoneyAmount(){
        shop.addItem(firstItem);
        assertTrue(shop.buyItem(firstItem));
        assertEquals(400, player.getMoney());
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