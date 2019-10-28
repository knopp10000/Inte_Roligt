package com.interoligt.rougelike.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class BossMonsterTest {
    BossMonster monster;

    @Test
    void constructorTest(){
        monster = new SampleBossMonster();
        assertEquals(monster.getExperienceReward(),15000);
    }

//    @Test
//    void constructorExpReward0Test(){
//        assertThrows(IllegalArgumentException.class, () -> {
//            new BossMonster("Bowser",50,-25,Element.GROUND,7000,50,4);
//        });
//    }

    @Test
    void constructorExpRewardNegativeTest(){
        assertThrows(IllegalArgumentException.class, () -> {
            new SampleBossMonster("Bowser",50,-15000,Element.GROUND,7000,50,4);
        });
    }
}
