package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player validPlayer = new Player(1, 1);

    //Test HP when creating player
    @Test
    void testBaseHP(){
        int baseHP = validPlayer.getBaseHP();
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
        assertThrows(IllegalArgumentException.class, () -> new Player(0, 1));
    }
    //Test exception for invalid speed
    @Test
    void testSpeedThrow(){
        assertThrows(IllegalArgumentException.class, () -> new Player( 1, 0));
    }

    //Test character is naked
    @Test
    void testEmptyEquipment(){
        HashMap<Slot, Equippable> equipment = validPlayer.getEquipment();
        for(HashMap.Entry slot : equipment.entrySet()){
            assertTrue(slot.getValue() == null);
        }
    }
}
