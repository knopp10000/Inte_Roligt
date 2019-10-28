package com.interoligt.rougelike.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MonsterEffectTest {
    BasicMonster monster;
    @BeforeEach
    void setMonster(){
        monster = new BasicMonster("Turtle",3,50,Element.WATER,500,50,1);
    }
    @Test
    void speedEffectTest(){

    }

    @Test
    void armourEffectTest(){

    }
    @Test
    void healthEffectTest(){

    }
    @Test
    void damageEffectTest(){

    }
    @Test
    void inactiveEffectTest(){

    }
    @Test
    void deathEffectTest(){

    }
}
