package com.interoligt.rougelike.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class BossMonsterTest {
    BossMonster monster;

    @Test
    void constructorTest(){
        monster = new BossMonster("Bowser",50,15000,Element.GROUND,7000,50,75,4);
        assertEquals(monster.getExperienceReward(),15000);
    }

    @Test
    void constructorExpReward0Test(){
        assertThrows(IllegalArgumentException.class, () -> {
            new BossMonster("Bowser",50,0,Element.GROUND,7000,50,75,4);
        });
    }

    @Test
    void constructorExpRewardNegativeTest(){
        assertThrows(IllegalArgumentException.class, () -> {
            new BossMonster("Bowser",50,-15000,Element.GROUND,7000,50,75,4);
        });
    }
}
