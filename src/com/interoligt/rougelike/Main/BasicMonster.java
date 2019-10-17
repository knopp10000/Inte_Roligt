package com.interoligt.rougelike.Main;

public class BasicMonster extends Monster {
    private int expPerLevel;

    public BasicMonster(String name, int level, int expPerLevel, Element element, int baseHealth, int baseArmour, int baseDamage, int baseSpeed){
        super(name,level,element, baseHealth, baseArmour, baseDamage, baseSpeed);
        this.expPerLevel = expPerLevel;
;    }

    @Override
    int getExperienceReward() {
        return expPerLevel*super.getLevel();
    }



}
