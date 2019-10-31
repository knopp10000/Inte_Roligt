package com.interoligt.rougelike.Main;

import com.interoligt.rougelike.Mocks.UIPlayerMoveMock;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class CombatTest {
    Effect poison = new Effect("Poison", 'h', '-', false, 500);
    Effect explosion =  new Effect("Flat damage", 'h', '-', false, 500);
    Item poisonInABottle = new Item("P4",1, 1, poison);
    Item grenade = new Item("Grenade", 1, 1, explosion);

    ArrayList<Item> items = new ArrayList<>(Arrays.asList(poisonInABottle, grenade));
    Inventory inventoryWithStuff = new Inventory(5, items);

    Player weakPlayer = new Player(1,12, 2, inventoryWithStuff);
    Player strongPlayer = new Player(2000, 50, 1, inventoryWithStuff);


    Monster weakMonster = new BasicMonster("Spider", 5, 5, Element.FIRE, 10, 2, 2);
    Monster strongMonster = new BasicMonster("Pytti-Panna", 2, 5, Element.WATER, 100, 50, 10);
    Monster[] monsters = {weakMonster, strongMonster};

    ArrayList<Move> onlyAttackMove = new ArrayList<> (Arrays.asList(Move.ATTACK));
    Combat itemCombat = new Combat(new Monster[] {strongMonster}, weakPlayer, new UIPlayerMoveMock(new ArrayList<> (Arrays.asList(Move.ITEM))));
    Combat losingCombat = new Combat(new Monster[] {strongMonster}, weakPlayer, new UIPlayerMoveMock(onlyAttackMove));
    Combat winningCombat = new Combat(new Monster[] {weakMonster}, strongPlayer, new UIPlayerMoveMock(new ArrayList<> (Arrays.asList(Move.ATTACK))));

    @Test
    void checkGetPlayer(){
        assertTrue(losingCombat.getPlayer() == weakPlayer);
    }

    @Test
    void checkPlayerIsNullThrows(){
        assertThrows(IllegalArgumentException.class, () -> new Combat(monsters, null, new UIPlayerMoveMock(new ArrayList<Move> (Arrays.asList(Move.ITEM, Move.ATTACK)))));
    }

    @Test
    void checkMonsterIsNullThrows(){
        assertThrows(IllegalArgumentException.class, () -> new Combat(null, weakPlayer, new UIPlayerMoveMock(new ArrayList<Move> (Arrays.asList(Move.ITEM, Move.ATTACK)))));
    }

    @Test
    void checkGetMonsters(){
        Monster[] monsters = losingCombat.getMonsters();
        assertTrue(monsters.length > 0);
    }

    @Test
    void checkTurnOrder(){
        Target[] turnOrder = losingCombat.getTurnOrder();
        Target[] expectedTurnOrder = {weakPlayer, strongMonster};
        assertTrue(Arrays.equals(turnOrder, expectedTurnOrder));
    }

    @Test
    void testCombatWherePlayerLose(){
        losingCombat.start();
        assertFalse(losingCombat.getPlayer().isAlive);
        assertTrue(losingCombat.isCombatFinished());
    }

    @Test
    void testCombatWherePlayerWin(){
        winningCombat.start();
        assertTrue(winningCombat.getPlayer().isAlive);
        assertTrue(winningCombat.isCombatFinished());
    }

    @Test
    void testItemInCombat(){
        weakPlayer.setChosenItem(grenade);
        itemCombat.start();
        assertFalse(weakPlayer.getInventory().getItemsCopy().contains(grenade));
        assertTrue(itemCombat.getPlayer().isAlive);
    }

    @Test
    void testAllTrueStateDiagram(){
        winningCombat.start();
        assertTrue(winningCombat.getPlayer().isAlive);
    }

    @Test
    void testTrueFalseStateDiagram(){
        weakPlayer.addEffect(poison);
        poison.setTarget(weakPlayer);
        itemCombat.start();
        assertFalse(weakPlayer.isAlive);
        assertTrue(itemCombat.isCombatFinished());
    }

    @Test
    void testFalseStateDiagram(){
        Player deadPlayer = strongPlayer;
        deadPlayer.isAlive = false;
        Combat combatWithDeadPlayer = new Combat(monsters, deadPlayer, new UIPlayerMoveMock(onlyAttackMove));
        itemCombat.start();
        assertFalse(weakPlayer.isAlive);
        assertTrue(Arrays.equals(combatWithDeadPlayer.getMonsters(), monsters));
        assertTrue(combatWithDeadPlayer.isCombatFinished());
    }
}

