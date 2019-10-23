package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EffectTest {
    //TODO Change to Target target;
    BasicMonster target;
    @BeforeEach
    void createTarget() {
        target = new BasicMonster("Bowser", 50, 15000, Element.GROUND, 7000, 50, 75, 4);
    }
    @Test
    void effectConstructorTest(){
        Effect speed = new Effect(target,"Speed Increase",'s', '+', false, 5, 5);
        assertEquals(speed.toString(),"Target: Bowser, Name: Speed Increase, Stat: Speed, Effect: Add 5, Duration: 5 turns");
    }
    @Test
    void effectConstructorContTest(){
        Effect health = new Effect(target,"Health Regen",'h', '+', true, 5, 5);
        assertEquals(health.toString(),"Target: Bowser, Name: Health Regen, Stat: Health, Effect: Add 5 each turn, Duration: 5 turns");
    }
    @Test
    void effectHasDurationTrueTest(){
        Effect speed = new Effect(target,"Increased speed",'s','-',false,1,3);
        assertTrue(speed.hasDuration());
    }
    @Test
    void effectHasDurationFalseTest(){
        Effect damage = new Effect(target,"Damage Reduction",'d','-',false,10);
        assertFalse(damage.hasDuration());
    }
    @Test
    void effectAppliedEachTurnTrue(){
        Effect health = new Effect(target,"Health Drain", 'h', '-', true, 5);
        assertTrue(health.isContinuous());
    }
    @Test
    void effectAppliedEachTurnFalse(){
        Effect damage = new Effect(target,"Increase Damage", 'd', '+',false, 1);
        assertFalse(damage.isContinuous());
    }
    @Test
    void getValueTest(){
        Effect damage = new Effect(target,"Increase Damage", 'd', '+',false, 1);
        assertEquals(damage.getValue(),1);
    }
    @Test
    void getStatCharTest(){
        Effect damage = new Effect(target,"Increase Damage", 'd', '+',false, 1);
        assertEquals(damage.getStat(),'d');
    }
    @Test
    void getCounterNoCounterTest(){
        Effect damage = new Effect(target,"Increase Damage", 'd', '+',false, 1);
        assertThrows(NullPointerException.class,()-> {damage.getCounter();});
    }
    @Test
    void getCounterTest(){
        Effect damage = new Effect(target,"Increase Damage", 'd', '+',false, 1,4);
        assertEquals(damage.getCounter(),4);
    }
    @Test
    void getDurationNoDurationTest(){
        Effect damage = new Effect(target,"Increase Damage", 'd', '+',false, 1);
        assertThrows(NullPointerException.class,()-> damage.getDuration());
    }
    @Test
    void getDurationTest() {
        Effect damage = new Effect(target,"Increase Damage", 'd', '+', false, 1, 4);
        assertEquals(damage.getDuration(), 4);
    }

    //    @Test
//    void applyEffectDamageIncreaseWithoutDurationTest(){
//        Effect damage = new Effect(target,"Increase Damage", 'd', '+', false, 50, 4);
//        damage.applyEffect();
//        assertEquals(target.getCurrentDamage(),125);
//    }
    void applyContinuousEffectHealthIncreaseWithoutDurationTest(){
        Effect health = new Effect(target,"Health Regen", 'h', '+', true, 500);
        health.applyEffect();
        health.applyEffect();
        health.applyEffect();
        health.applyEffect();
        assertEquals(target.getCurrentHealth(), 9000);

    }


}