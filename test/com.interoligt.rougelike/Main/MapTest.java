package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    Monster anka = new BasicMonster("Anka", 3, 1, Element.FIRE, 4, 2, 1, 200);
    Room room = new Room(anka);
    Room room2 = new Room(anka);
    Room[][] roomArray = {{room, room}, null};
    Map map = new Map(roomArray);

    @Test
    void testmoving(){
        assertTrue(map.move('u') == room);
    }
}