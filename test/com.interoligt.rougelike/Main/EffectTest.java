package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class EffectTest {

    Target target = new BasicMonster("Bowser", 50, 15000, Element.GROUND, 7000, 75, 10);;
//    @BeforeEach
//    void createTarget() {
//        target = new BasicMonster("Bowser", 50, 15000, Element.GROUND, 7000, 50, 10);
//    }
//    @Test
//    void effectConstructorTest(){
//        Effect speed = new Effect(target,"Speed Increase",'s', '+', false, 5, 5);
//        assertEquals(speed.toString(),"Target: Bowser, Name: Speed Increase, Stat: Speed, Effect: Add 5, Duration: 5 turns");
//    }
//    @Test
//    void effectConstructorContTest(){
//        Effect health = new Effect(target,"Health Regen",'h', '+', true, 5, 5);
//        assertEquals(health.toString(),"Target: Bowser, Name: Health Regen, Stat: Health, Effect: Add 5 each turn, Duration: 5 turns");
//    }
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

        @Test
    void applyEffectDamageIncreaseWithoutDurationTest(){
        Effect damage = new Effect(target,"Increase Damage", 'd', '+', false, 50);
        damage.applyEffect();
        damage.applyEffect();
        assertEquals(target.getCurrentDamage(),125);
    }
    @Test
    void getValueWithSignPosTest(){
        Effect health = new Effect(target,"Health Regen", 'h', '+', false, 500);
        assertEquals(health.getValueWithSign(),500);
    }
    @Test
    void getValueWithSignNegTest(){
        Effect health = new Effect(target,"Health Drain", 'h', '-', false, 500);
        assertEquals(health.getValueWithSign(),-500);
    }

    @Test
    void applyContinuousEffectHealthIncreaseWithoutDurationTest(){
        Effect damage = new Effect(target,"Decrease health", 'h', '-', false, 3000);
        damage.applyEffect();
        Effect health = new Effect(target,"Health Regen", 'h', '+', true, 500);
        health.applyEffect();
        health.applyEffect();
        health.applyEffect();
        health.applyEffect();

        assertEquals(target.getCurrentHP(), 6000);


    }

    @Test
    void applyContinuousEffectSpeedDecreaseWithDurationTest(){
        Effect speed = new Effect(target, "Speed Decrease",'s','-',true,1,5);
        speed.applyEffect();
        speed.applyEffect();
        speed.applyEffect();
        speed.applyEffect();
        assertEquals(target.getCurrentSpeed(),6);

    }
    @Test
    void applyEffectSpeedDecreaseWithDurationTest(){
        Effect damage = new Effect(target,"Decrease health", 'h', '-', false, 1000);
        damage.applyEffect();
        Effect health = new Effect(target, "Health boost", 'h','+',false,500,2);
        health.applyEffect();
        health.applyEffect();
        assertEquals(target.getCurrentHP(), 6500);
        health.applyEffect();
        assertEquals(target.getCurrentHP(), 6000);
    }

}
