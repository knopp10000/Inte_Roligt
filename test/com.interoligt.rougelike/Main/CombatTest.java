/*
package com.interoligt.rougelike.Main;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class CombatTest {
    Player player = new Player(1,12, 2, new Inventory(10, new ArrayList<Item>()));
    Monster spider = new BasicMonster("Spider", 5, 5, Element.FIRE, 10, 2, 5, 2);
    Monster[] monsters = {spider};
    Combat validCombat = new Combat(monsters, player);

    //Check that fetched player is not null
    @Test
    void checkPlayer(){
        Player player = validCombat.getPlayer();
        assertTrue(player != null);
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
        //SKAPA EQUALS FÖR PLAYER
        assertTrue(turnOrder[0].getSpeed() >= turnOrder[1].getSpeed());
    }
}
*/
