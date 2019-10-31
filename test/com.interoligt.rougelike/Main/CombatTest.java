
package com.interoligt.rougelike.Main;

import com.interoligt.rougelike.Mocks.UIPlayerMoveMock;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class CombatTest {
    Player player = new Player(1,12, 2, new Inventory(10));
    Monster spider = new BasicMonster("Spider", 5, 5, Element.FIRE, 10, 2, 2);
    Monster pyttiPanna = new BasicMonster("Pytti-Panna", 2, 5, Element.WATER, 700, 300, 10);
    Monster[] monsters = {spider, pyttiPanna};
    Combat validCombat = new Combat(monsters, player, new UIPlayerMoveMock());

    //Check that fetched player is not null
    @Test
    void checkPlayer(){
        assertTrue(validCombat.getPlayer() == player);
    }

    //Check that fetched monster array is not empty
    @Test
    void checkMonsterArray(){
        Monster[] monsters = validCombat.getMonsters();
        assertTrue(monsters.length > 0);
    }

    @Test
    void checkTurnOrder(){
        Target[] turnOrder = validCombat.getTurnOrder();
        Target[] expectedTurnorder = {player, pyttiPanna, spider};
        assertTrue(Arrays.equals(turnOrder, expectedTurnorder));
    }

    @Test
    void testCombatWherePlayerDies(){
        validCombat.start();
        assertFalse(validCombat.getPlayer().isAlive);
    }

    @Test
    void testItemInCombat(){
        Effect effect =  new Effect("Flat damage", 'h', '-', false, 5);
        Item grenade = new Item("Grenade", 1, 1,effect);
        try{
            player.getInventory().addItem(grenade);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

