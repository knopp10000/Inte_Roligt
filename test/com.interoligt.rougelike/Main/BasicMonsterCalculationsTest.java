package com.interoligt.rougelike.Main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BasicMonsterCalculationsTest {
    BasicMonster monster;

    @Test
    void getExperienceRewardTest(){
        monster = new BasicMonster("Bat", 25, 12,Element.GROUND,1500, 30,25,5);
        assertEquals(monster.getExperienceReward(),300);
    }

}
