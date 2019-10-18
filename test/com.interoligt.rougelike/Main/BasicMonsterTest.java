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

    @Test
    void toStringTest(){
        assertEquals(monster.toString(),"Name: Spider, Level: 5, Element: Fire");
    }

    @Test
    void getNameTest(){
        assertEquals(monster.getName(),"Spider");
    }

    @Test
    void getLevelTest(){
        assertEquals(monster.getLevel(),5);
    }

    @Test
    void getElementTest(){
        assertEquals(monster.getElement(),Element.FIRE);
    }

    @Test
    void getBaseHealthTest(){
        assertEquals(monster.getBaseHealth(), 50);
    }

    @Test
    void getBaseArmourTest(){
        assertEquals(monster.getBaseArmour(),8);
    }

    @Test
    void getBaseDamageTest(){
        assertEquals(monster.getBaseDamage(),4);
    }

    @Test
    void getBaseSpeedTest(){
        assertEquals(monster.getBaseSpeed(),2);
    }
}
