package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EffectTest {
    @Test
    void effectConstructorTest(){
        Effect speed = new Effect("Speed Increase",'s', '+', false, 5, 5);
        assertEquals(speed.toString(),"Name: Speed Increase, Stat: Armour, Effect: Add 5, Duration: 5 turns");
    }
    @Test
    void effectConstructorContTest(){
        Effect health = new Effect("Health Regen",'h', '+', true, 5, 5);
        assertEquals(health.toString(),"Name: Health Regen, Stat: Health, Effect: Add 5 each turn, Duration: 5 turns");
    }
    @Test
    void effectHasDurationTrueTest(){
        Effect speed = new Effect("Speed Multiplication",'s','*',false,1.5,3);
        assertTrue(speed.hasDuration());
    }
    @Test
    void effectHasDurationFalseTest(){
        Effect damage = new Effect("Damage Reduction",'d','-',false,10);
        assertFalse(damage.hasDuration());
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
    @Test
    void getValueTest(){
        Effect damage = new Effect("Increase Damage", 'd', '*',false, 1);
        assertEquals(damage.getValue(),1);
    }
    @Test
    void getStatCharTest(){
        Effect damage = new Effect("Increase Damage", 'd', '*',false, 1);
        assertEquals(damage.getStat(),'d');
    }

    @Test
    void getCounterNoCounterTest(){
        Effect damage = new Effect("Increase Damage", 'd', '*',false, 1);
        assertThrows(NullPointerException.class,()-> {damage.getCounter();});
    }

    @Test
    void getCounterTest(){
        Effect damage = new Effect("Increase Damage", 'd', '*',false, 1,4);
        assertEquals(damage.getCounter(),4);
    }
    @Test
    void getDurationNoDurationTest(){
        Effect damage = new Effect("Increase Damage", 'd', '*',false, 1);
        assertThrows(NullPointerException.class,()-> damage.getDuration());
    }

    @Test
    void getDurationTest() {
        Effect damage = new Effect("Increase Damage", 'd', '*', false, 1, 4);
        assertEquals(damage.getDuration(), 4);
    }

    @Test
    void getOperatorTest(){
        Effect damage = new Effect("Increase Damage", 'd', '*',false, 1);
        assertEquals(damage.getOperator(),'*');
    }


}
