package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    Monster anka = new BasicMonster("Anka", 3, 1, Element.FIRE, 4, 2, 1, 200);
    Room room00 = new Room(anka);
    Room room01 = new Room(anka);
    Room room02 = new Room(anka);
    Room room10 = new Room(anka);
    Room room20 = new Room(anka);
    Room room11 = new Room(anka);
    Room room12 = new Room(anka);
    Room room21 = new Room(anka);
    Room room22 = new Room(anka);


    Room[][] roomArray = {{room00, room01, room02}, {room10, room11, room12}, {room20, room21, room22}};
    Map map = new Map(roomArray, 1, 1);

    @Test
    void testMoveUp(){
        assertTrue(map.move('u') == room12);
    }

    @Test
    void testMoveUpNull(){
        map.move('u');
        assertTrue(map.move('u') == null);
    }

    @Test
    void testMoveDown(){
        assertTrue(map.move('d') == room10);
    }

    @Test
    void testMoveDownNull(){
        map.move('d');
        assertTrue(map.move('d') == null);
    }

    @Test
    void testMoveLeft(){
        assertTrue(map.move('l') == room01);
    }

    @Test
    void testMoveLeftNull(){
        map.move('l');
        assertTrue(map.move('l') == null);
    }

    @Test
    void testMoveRight(){
        assertTrue(map.move('r') == room21);
    }

    @Test
    void testMoveRightNull(){
        map.move('r');
        assertTrue(map.move('r') == null);
    }

    @Test
    void testIllegalMove(){
        assertThrows(IllegalArgumentException.class, () -> map.move('k'));
    }


}