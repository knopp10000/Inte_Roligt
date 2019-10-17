package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player playerToTest = new Player(1, 1);

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
}
