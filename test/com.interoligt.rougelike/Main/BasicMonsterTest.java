package com.interoligt.rougelike.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicMonsterTest {
BasicMonster monster;

    @Test
    void isAliveTest(){
        monster = new BasicMonster("Spider", 5, 12, Element.FIRE, 50, 8, 4, 2);
        assertTrue(monster.isAlive());
    }

    @Test
    void isActiveTest(){
        monster = new BasicMonster("Spider", 5, 12, Element.FIRE, 50, 8, 4, 2);
        assertTrue(monster.isActive());
    }

    @Test
    void setActiveTest(){
        monster = new BasicMonster("Spider", 5, 12, Element.FIRE, 50, 8, 4, 2);
        monster.setActive(false);
        assertFalse(monster.isActive());
        monster.setActive(true);
        assertTrue(monster.isActive());
    }

    @Test
    void setAliveTest(){
        monster = new BasicMonster("Spider", 5, 12, Element.FIRE, 50, 8, 4, 2);
        monster.setAlive(false);
        assertFalse(monster.isAlive());
        monster.setAlive(true);
        assertTrue(monster.isAlive());
    }
}
