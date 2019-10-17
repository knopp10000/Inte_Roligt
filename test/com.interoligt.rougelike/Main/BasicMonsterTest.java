package com.interoligt.rougelike.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicMonsterTest {
    BasicMonster monster = new BasicMonster("Spider", 5, Element.FIRE, 50, 8, 4, 2);

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

    @Test
    void isAliveTest(){
        assertTrue(monster.isAlive());
    }

    @Test
    void isActiveTest(){
        assertTrue(monster.isActive());
    }
}
