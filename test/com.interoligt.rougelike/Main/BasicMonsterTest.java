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
    void getElement(){
        assertEquals(monster.getElement(),Element.FIRE);
    }

    @Test
    void getBaseHealth(){
        assertEquals(monster.getBaseHealth(), 50);
    }

    @Test
    void getBaseArmour(){
        assertEquals(monster.getBaseArmour(),8);
    }

    @Test
    void getBaseDamage(){
        assertEquals(monster.getBaseDamage(),4);
    }
    
    void getBaseSpeed(){
        assertEquals(monster.getBaseSpeed(),2);
    }
}
