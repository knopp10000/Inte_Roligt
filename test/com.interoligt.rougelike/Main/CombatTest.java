
package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class CombatTest {
    Player player = new Player(1,12, 2, new Inventory(10));
    Monster spider = new BasicMonster("Spider", 5, 5, Element.FIRE, 10, 2, 2);
    Monster[] monsters = {spider};
    Combat validCombat = new Combat(monsters, player);

    //Check that fetched player is not null
    @Test
    void checkPlayer(){
        assertTrue(validCombat.getPlayer() != null);
    }

    //Check that fetched monster array is not empty
    @Test
    void checkMonsterArray(){
        Monster[] monsters = validCombat.getMonsters();
        assertTrue(monsters.length > 0);
    }

    //Check that turn order is correct
    @Test
    void checkTurnOrder(){
        Target[] turnOrder = validCombat.getTurnOrder();
        Target[] expectedTurnorder = {player, spider};
        //SKAPA EQUALS FÖR PLAYER
//        assertTrue(turnOrder[0].getSpeed() >= turnOrder[1].getSpeed());
        assertTrue(Arrays.equals(turnOrder, expectedTurnorder));
    }

    //Test that combat executes and finishes
    @Test
    void testCombatExecution(){

        while(!validCombat.combatFinished()) {
                validCombat.setChosenTarget(spider);
                validCombat.setChosenMove(Move.ATTACK);
                validCombat.runTurn();
            }

        assertFalse(validCombat.getPlayer().isAlive);

    }

    //Test using item in combat
    @Test
    void testItemInCombat(){
        player.getInventory().addItem(new Item("Grenade", 1, 1, new Effect("Flat damage", 'h', '-', false, 5));
    }




}

