package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicMonsterConstructorTest {
    BasicMonster monster = new BasicMonster("Spider", 5, 12, Element.FIRE, 50, 8, 4, 2);

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
