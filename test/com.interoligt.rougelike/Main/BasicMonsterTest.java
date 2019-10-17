package com.interoligt.rougelike.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicMonsterTest {


    @Test
    void isAliveTest(){
        assertTrue(monster.isAlive());
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
        monster.setAlive(false);
        assertFalse(monster.isAlive());
        monster.setAlive(true);
        assertTrue(monster.isAlive());
    }
}
