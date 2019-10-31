
package com.interoligt.rougelike.Main;

import com.interoligt.rougelike.Mocks.UIPlayerMoveMock;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class CombatTest {
    Player player = new Player(1,12, 2, new Inventory(10));
    Player strongPlayer = new Player(50, 50, 50, new Inventory(1));
    Monster spider = new BasicMonster("Spider", 5, 5, Element.FIRE, 10, 2, 2);
    Monster pyttiPanna = new BasicMonster("Pytti-Panna", 2, 5, Element.WATER, 700, 300, 10);
    Monster[] monsters = {spider, pyttiPanna};
    Combat itemCombat = new Combat(monsters, player, new UIPlayerMoveMock(new ArrayList<Move> (Arrays.asList(Move.ITEM, Move.ATTACK))));
    Combat normalCombat = new Combat(new Monster[] {spider}, player, new UIPlayerMoveMock(new ArrayList<Move> (Arrays.asList(Move.ATTACK))));
    Combat winningCombat = new Combat(new Monster[] {spider}, strongPlayer, new UIPlayerMoveMock(new ArrayList<Move> (Arrays.asList(Move.ATTACK))));

    //Check that fetched player is not null
    @Test
    void checkPlayer(){
        assertTrue(normalCombat.getPlayer() == player);
    }

    @Test
    void checkPlayerThrows(){
        assertThrows(IllegalArgumentException.class, () -> new Combat(monsters, null, new UIPlayerMoveMock(new ArrayList<Move> (Arrays.asList(Move.ITEM, Move.ATTACK)))));
    }

    @Test
    void checkMonsterThrows(){
        assertThrows(IllegalArgumentException.class, () -> new Combat(null, player, new UIPlayerMoveMock(new ArrayList<Move> (Arrays.asList(Move.ITEM, Move.ATTACK)))));
    }


    //Check that fetched monster array is not empty
    @Test
    void checkMonsterArray(){
        Monster[] monsters = normalCombat.getMonsters();
        assertTrue(monsters.length > 0);
    }

    @Test
    void checkTurnOrder(){
        Target[] turnOrder = normalCombat.getTurnOrder();
        Target[] expectedTurnOrder = {player, spider};
        assertTrue(Arrays.equals(turnOrder, expectedTurnOrder));
    }

    @Test
    void testCombatWherePlayerDies(){
        normalCombat.start();
        assertFalse(normalCombat.getPlayer().isAlive);
    }

    @Test
    void testCombatWhereEnemiesDie(){
        winningCombat.start();
        assertTrue(winningCombat.getPlayer().isAlive);
        assertTrue(winningCombat.isCombatFinished());
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
        player.setChosenItem(grenade);

        itemCombat.start();
        assertFalse(player.getInventory().getItemsCopy().contains(grenade));
        assertFalse(itemCombat.getPlayer().isAlive);



    }
}

