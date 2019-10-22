package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private final Room room = new Room();

    @Test
    void assertActivatedIsInitiallyFalse() {
        assertFalse(room.isActivated());

    }

    @Test
    void testActivation(){
        room.activate();
        assertTrue(room.isActivated());
    }

}
