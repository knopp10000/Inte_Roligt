package com.interoligt.rougelike.Main;

public class SampleBossMonster extends BossMonster {

    public SampleBossMonster() {
        super("Bowser", 100, 15000, Element.FIRE, 1000, 100, 1);
    }

    public SampleBossMonster(String name, int level, int experienceReward, Element element, int baseHealth, int baseDamage, int baseSpeed) throws IllegalArgumentException {
        super(name, level, experienceReward, element, baseHealth, baseDamage, baseSpeed);
    }


    @Override
    void die() {

    }

    @Override
    Move chooseMove() {
        return Move.ATTACK;
    }
}
