package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasicMonsterConstructorTest {

    @Test
    void constructorNameNullTest() {
        assertThrows(NullPointerException.class, () -> {
            new BasicMonster(null, 5, 12, Element.FIRE, 50, 8, 4, 2);
        });
    }

    @Test
    void constructorNameEmptyTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BasicMonster("", 5, 12, Element.FIRE, 50, 8, 4, 2);
        });
    }

    @Test
    void constructorNameSpacesTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BasicMonster("   ", 5, 12, Element.FIRE, 50, 8, 4, 2);
        });
    }

    @Test
    void constructorLevel0Test() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BasicMonster("Spider", 0, 12, Element.FIRE, 50, 8, 4, 2);
        });
    }

    @Test
    void constructorLevelNegativeTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BasicMonster("Spider", -5, 12, Element.FIRE, 50, 8, 4, 2);
        });
    }

    @Test
    void constructorExpPL0Test() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BasicMonster("Spider", 5, 0, Element.FIRE, 50, 8, 4, 2);
        });
    }

    @Test
    void constructorExpPLNegativeTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BasicMonster("Spider", 5, -12, Element.FIRE, 50, 8, 4, 2);
        });
    }
    @Test
    void constructorElementNullTest() {
        assertThrows(NullPointerException.class, () -> {
            new BasicMonster("Spider", 5, 12,null, 50, 8, 4, 2);
        });
    }
    @Test
    void constructorBaseHealth0Test() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BasicMonster("Spider", 5, 12, Element.FIRE, 0, 8, 4, 2);
        });
    }

    @Test
    void constructorBaseHealthNegativeTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BasicMonster("Spider", 5, 12, Element.FIRE, -50, 8, 4, 2);
        });
    }

    @Test
    void constructorBaseArmour0Test() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BasicMonster("Spider", 5, 12, Element.FIRE, 50, 0, 4, 2);
        });
    }

    @Test
    void constructorBaseArmourNegativeTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BasicMonster("Spider", 5, 12, Element.FIRE, 50, -8, 4, 2);
        });
    }

    @Test
    void constructorBaseDamage0Test() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BasicMonster("Spider", 5, 12, Element.FIRE, 50, 8, 0, 2);
        });
    }

    @Test
    void constructorBaseDamageNegativeTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BasicMonster("Spider", 5, 12, Element.FIRE, 50, 8, -4, 2);
        });
    }

    @Test
    void constructorSpeed0Test() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BasicMonster("Spider", 5, 12, Element.FIRE, 50, 8, 4, 0);});
    }
    @Test
    void constructorSpeedNegativeTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BasicMonster("Spider", 5, 12, Element.FIRE, 50, 8, 4, -2);});
    }

}
