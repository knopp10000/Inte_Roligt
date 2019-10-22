package com.interoligt.rougelike.Main;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombatTest {

    Combat validCombat = new Combat(new Monster[new Monster("Spider", 5, 5, Element.FIRE, 10, 2, 5, 2)], new Player(1, 12, new Item[]));
    validCombat.initialize();

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
    void checkTurnorder(){
        Monster[] monsters = validCombat.getMonsters();
        int monsterSpeed = monsters[0].getSpeed();
        Player player = validCombat.getPlayer();
        int playerSpeed = player.getSpeed();
        assertTrue(playerSpeed > monsterSpeed);
    }

    //Check end

}
