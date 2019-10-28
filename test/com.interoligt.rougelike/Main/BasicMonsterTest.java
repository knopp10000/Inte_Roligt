package com.interoligt.rougelike.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicMonsterTest {
    BasicMonster monster;
    @BeforeEach
    void setMonster(){
        monster = new BasicMonster("Spider", 5, 12, Element.FIRE, 50, 4, 2);
    }

    @Test
    void isAliveTest(){
        assertTrue(monster.isAlive);
    }

    @Test
    void isActiveTest(){
        assertTrue(monster.isActive());
    }

    @Test
    void setActiveTest(){
        monster.setActive(false);
        assertFalse(monster.isActive());
        monster.setActive(true);
        assertTrue(monster.isActive());
    }

    @Test
    void setAliveTest(){
        monster.isAlive = false;
        assertFalse(monster.isAlive);
        monster.isAlive = true;
        assertTrue(monster.isAlive);
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
        assertEquals(monster.getCurrentHP(), 50);
    }

    @Test
    void getBaseDamageTest(){
        assertEquals(monster.getBaseDamage(),4);
    }

    @Test
    void getBaseSpeedTest(){
        assertEquals(monster.getBaseSpeed(),2);
    }


    @Test
    void getSpeedTest(){
        assertEquals(monster.getSpeed(),2);
    }

}
