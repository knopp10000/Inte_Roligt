package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private Room roomToTest;
    Monster monsterToTest = new BasicMonster("Spider", 5, 12, Element.FIRE, 50, 8, 4, 2);

    @BeforeEach
    void resetRoom(){
        roomToTest = new Room();
    }

    @Test
    void testAssertActivatedIsInitiallyFalse() {
        assertFalse(roomToTest.isActivated());
    }

    @Test
    void testActivation(){
        roomToTest.activate();
        assertTrue(roomToTest.isActivated());
    }

    @Test
    void testDeActivate(){
        roomToTest.activate();
        roomToTest.deActivate();
        assertFalse(roomToTest.isActivated());
    }

    @Test
    void testAddMonsterToRoom(){
        roomToTest.addMonsterToRoom(monsterToTest);
        assertEquals(monsterToTest, roomToTest.showAllMonsters().get(0));

    }

    @Test
    void removeMonsterFromRoom(){
        roomToTest.addMonsterToRoom(monsterToTest);
        Monster monsterToRemove = new BasicMonster("Spider", 5, 12, Element.FIRE, 50, 8, 4, 2);
        roomToTest.addMonsterToRoom(monsterToRemove);
        ArrayList<Monster> whatShouldRemain = new ArrayList<>(Arrays.asList(monsterToTest));
        roomToTest.removeMonsterFromRoom(monsterToRemove);
        assertEquals(whatShouldRemain,        roomToTest.showAllMonsters());
    }
}