package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EffectTest {
    @Test
    void effectConstructorTest(){
        Effect armour = new Effect("Armour Increase",'a', '+', 5, 5);
        assertEquals(armour.toString(),"Name: Armour Increase, Stat: Armour, Effect: Add 5, Duration: 5 turns");
    }
    @Test
    void effectHasDurationTrueTest(){
        Effect speed = new Effect("Speed",'s','*','o',1.5,3);
        assertTrue(speed.hasDuration());
    }
    @Test
    void effectHasDurationFalseTest(){
        Effect armour = new Effect("Armour",'a','-','o',10);
        assertFalse(armour.hasDuration());
    }
    @Test
    void effectAppliedEachTurnTrue(){
        Effect health = new Effect("Health Drain", 'h', '-', 'c');
        assertTrue(health.isContinuous());
    }
    @Test
    void effectAppliedEachTurnFalse(){
        Effect damage = new Effect("Increase Damage", 'd', '*','o');
        assertFalse(damage.isContinuous());
    }
}
