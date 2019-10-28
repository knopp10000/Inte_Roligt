package com.interoligt.rougelike.Main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EffectTest {

    private Target target;
    @BeforeEach
    void createTarget() {
        target = new BasicMonster("Bowser", 50, 15000, Element.GROUND, 7000, 50, 75, 10);
    }



    @Test
    void effectConstructorTest(){
        Effect speed = new Effect(target,"Speed Increase",'s', '+', false, 5, 5);
        assertEquals(speed.toString(),"Target: Bowser, Name: Speed Increase, Stat: Speed, Effect: Add 5, Duration: 5 turns");
    }
    @Test
    void effectAddedToCharacterEffectListTest() {
        Effect speed = new Effect(target, "Speed Increase", 's', '+', false, 5, 5);
        //TODO check target effect list to make sure effect is added correctly
    }
    @Test
    void effectRemovedFromCharacterEffectListTest() {
        Effect speed = new Effect(target, "Speed Increase", 's', '+', false, 5, 5);
        //TODO check target effect list to make sure effect is removed correctly
    }
    @Test
    void effectConstructorContTest(){
        Effect health = new Effect(target,"Health Regen",'h', '+', true, 5, 5);
        assertEquals(health.toString(),"Target: Bowser, Name: Health Regen, Stat: Health, Effect: Add 5 each turn, Duration: 5 turns");
    }

    @Test
    void effectConstructorWrongStatInputTest(){
        assertThrows(IllegalArgumentException.class, () -> { new Effect(target,"Health Regen",'b','+',true,5,5);});
    }

    @Test
    void effectConstructorWrongOperatorInputTest(){
        assertThrows(IllegalArgumentException.class, () -> { new Effect(target,"Health Regen",'h','*',true,5,5);});
    }
    @Test
    void effectConstructorWrongValueInputTest(){
        assertThrows(IllegalArgumentException.class, () -> { new Effect(target,"Health Regen",'h','+',true,0,5);});
    }
    @Test
    void effectConstructorWrongDurationTest(){
        assertThrows(IllegalArgumentException.class, () -> {new Effect(target,"Health Regen",'h','+',true,5,0);});
    }
    @Test
    void effectConstructorBlankNameTest(){
        assertThrows(NullPointerException.class, () -> {new Effect(target,"    ",'h','+',true,5,0);});
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
    void getStatCharDTest(){
        Effect damage = new Effect(target,"Increase Damage", 'd', '+',false, 1);
        assertEquals(damage.getStat(),'d');
    }
    @Test
    void getStatusNameDamageTest(){
        Effect damage = new Effect(target,"Increase damage", 'd', '+',false, 1);
        assertEquals(damage.getStatusName(),"Damage");
    }
    @Test
    void getStatusNameSpeedTest(){
        Effect health = new Effect(target,"Increase Speed", 's', '+',false, 1);
        assertEquals(health.getStatusName(),"Speed");
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
       new Effect(target,"Decrease health", 'h', '-', false, 3000).applyEffect();
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

    @Test
    void removeSpeedDecreaseTest(){
        Effect damage = new Effect(target,"Decrease health", 'h', '-', false, 1000);
    }
    @Test
    void removeContinuousEffectSpeedDecreaseWithDurationTest() {
        Effect speed = new Effect(target, "Speed Decrease", 's', '-', true, 1, 5);
        speed.applyEffect();
        speed.applyEffect();
        speed.applyEffect();
        speed.applyEffect();
        speed.applyEffect();
        speed.applyEffect();
        speed.applyEffect();
        speed.applyEffect();
        assertEquals(target.getCurrentSpeed(), 5);
    }
    @Test
    void removeDamageIncrease() {
        Effect damage = new Effect(target,"Increase Damage", 'd', '+', false, 15, 1);
        damage.applyEffect();
        assertEquals(target.getCurrentDamage(), 90);
        damage.applyEffect();
        assertEquals(target.getCurrentDamage(), 75);
    }
    @Test
    void removeSpeedIncrease() {
        Effect speed = new Effect(target,"Increase Damage", 's', '+', false, 15, 1);
        speed.applyEffect();
        assertEquals(target.getCurrentSpeed(), 25);
        speed.applyEffect();
        assertEquals(target.getCurrentSpeed(), 10);
    }
}
