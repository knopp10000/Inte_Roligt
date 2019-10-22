package com.interoligt.rougelike.Main;

public class BasicMonster extends Monster {
    private int expPerLevel;

    public BasicMonster(String name, int level, int expPerLevel, Element element, int baseHealth, int baseArmour, int baseDamage, int speed) throws IllegalArgumentException{
        super(name,level,element, baseHealth, baseArmour, baseDamage, speed);
        if(expPerLevel <= 0){
            throw new IllegalArgumentException("All integers need to be greater than 0");
        }
        this.expPerLevel = expPerLevel;
;    }

    @Override
    int getExperienceReward() {
        return expPerLevel*super.getLevel();
    }



}
