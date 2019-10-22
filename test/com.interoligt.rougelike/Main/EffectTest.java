package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EffectTest {
    @Test
    void effectConstructorTest(){
        Effect armour = new Effect("Armour Increase",'a', '+', false, 5, 5);
        assertEquals(armour.toString(),"Name: Armour Increase, Stat: Armour, Effect: Add 5, Duration: 5 turns");
    }
    @Test
    void effectConstructorContTest(){
        Effect health = new Effect("Health Regen",'h', '+', true, 5, 5);
        assertEquals(health.toString(),"Name: Health Regen, Stat: Health, Effect: Add 5 each turn, Duration: 5 turns");
    }
    @Test
    void effectHasDurationTrueTest(){
        Effect speed = new Effect("Speed",'s','*',false,1.5,3);
        assertTrue(speed.hasDuration());
    }
    @Test
    void effectHasDurationFalseTest(){
        Effect armour = new Effect("Armour",'a','-',false,10);
        assertFalse(armour.hasDuration());
    }
    @Test
    void effectAppliedEachTurnTrue(){
        Effect health = new Effect("Health Drain", 'h', '-', true, 5);
        assertTrue(health.isContinuous());
    }
    @Test
    void effectAppliedEachTurnFalse(){
        Effect damage = new Effect("Increase Damage", 'd', '*',false, 1);
        assertFalse(damage.isContinuous());
    }
}
