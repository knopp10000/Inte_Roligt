package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player playerToTest = new Player();

    //Test HP when creating player
    @Test
    void testBaseHP(){
        int baseHP = playerToTest.getBaseHP();
        assertTrue(baseHP > 0);
    }
    //Test Speed
    @Test
    void testBaseSpeed(){
        int baseSpeed = playerToTest.getSpeed();
        assertTrue(baseSpeed > 0);
    }

    //Test that item is equipped when equipped
    @Test
    void testEquip(){
        
    }
    //Test that inventory is either empty or within max limit
}
