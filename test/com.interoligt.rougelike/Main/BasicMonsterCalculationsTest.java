package com.interoligt.rougelike.Main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicMonsterCalculationsTest {
    BasicMonster monster;
    @BeforeEach
    void setMonster(){
        monster = new BasicMonster("Bat", 25, 12,Element.GROUND,1500, 30,25,5);
    }

    @Test
    void getExperienceRewardTest(){
        assertEquals(monster.getExperienceReward(),300);
    }

    @Test
    void getCurrentHealthTest(){
        assertEquals(monster.currentHP, 1500);
    }

    @Test
    void takeDamageTest(){
        monster.damage(500);
        assertEquals(monster.currentHP,1000);
        assertTrue(monster.isAlive());
    }

    @Test
    void takeDeadlyDamageTest(){
        monster.damage(3000);
        assertEquals(monster.currentHP,0);
        assertFalse(monster.isAlive());
    }

    @Test
    void getHealedTest(){
        monster.damage(200);
        assertEquals(monster.currentHP,1300);
        monster.heal(150);
        assertEquals(monster.currentHP,1450);
    }

    @Test
    void getOverHealedTest(){
        monster.damage(200);
        monster.heal(400);
        assertEquals(monster.currentHP,1500);
    }

    @Test
    void getHealedWhileDeadTest(){
        monster.damage(1500);
        monster.heal(500);
        assertEquals(monster.currentHP,0);
    }

}
