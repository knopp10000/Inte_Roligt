package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player validPlayer = new Player(1, 1, 1, new Inventory(10));


    //Test HP when creating player
    @Test
    void testBaseHP(){
        int baseHP = validPlayer.getMaxHP();
        assertTrue(baseHP > 0);
    }
    //Test Speed when creating player
    @Test
    void testBaseSpeed(){
        int baseSpeed = validPlayer.getSpeed();
        assertTrue(baseSpeed > 0);
    }
    //Test exception for invalid HP
    @Test
    void testHPThrow(){
        assertThrows(IllegalArgumentException.class, () -> new Player(0, 1,1, new Inventory(10)));
    }
    //Test exception for invalid speed
    @Test
    void testSpeedThrow(){
        assertThrows(IllegalArgumentException.class, () -> new Player( 1, 0,1, new Inventory(10)));
    }
}
