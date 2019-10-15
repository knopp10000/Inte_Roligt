package com.interoligt.rougelike.Main;

import static org.junit.jupiter.api.Assertions.*;

class TestbarKlassTest {

    TestbarKlass instanceOfTheClassToTest = new TestbarKlass();

    @org.junit.jupiter.api.Test
    void testTestMe() {
        assertTrue(TestbarKlass.testMe());
    }

    @org.junit.jupiter.api.Test
    void testInstanceMe() {
        assertTrue(instanceOfTheClassToTest.instanceMe());
    }

    @org.junit.jupiter.api.Test
    void testProtectedMethod() {
        assertTrue(instanceOfTheClassToTest.imProtected());
    }
}