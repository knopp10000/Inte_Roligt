package com.interoligt.rougelike.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicMonsterTest {

    @Test
    void toStringTest(){
        BasicMonster monster = new BasicMonster("Spider", 5, Element.FIRE,50, 8, 4, 2);
        assertEquals(monster.toString(),"Name: Spider, Level: 5, Element: Fire");
    }


}
