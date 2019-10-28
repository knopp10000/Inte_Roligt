package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    Monster anka = new BasicMonster("Anka", 3, 1, Element.FIRE, 4, 2, 1, 200);
    Room room00 = new Room(anka);
    Room room01 = new Room(anka);
    Room room10 = new Room(anka);
    Room room11 = new Room(anka);

    Room[][] roomArray = {{room00, room01}, {room10, room11}};
    Map map = new Map(roomArray);

    @Test
    void testMoveUp(){
        assertTrue(map.move('u') == room01);
    }

    @Test
    void testMoveDown(){
        assertTrue(map.move('d') == null);
    }

    @Test
    void testMoveLeft(){
        assertTrue(map.move('l') == null);
    }

    @Test
    void testMoveRight(){
        assertTrue(map.move('r') == room10);
    }

}