package com.interoligt.rougelike.Main;

public class BasicMonster extends Monster {
    private int expPerLevel;

    public BasicMonster(String name, int level, int expPerLevel, Element element, int baseHealth, int baseDamage, int baseSpeed) throws IllegalArgumentException{
        super(name, level, element, baseHealth, baseDamage, baseSpeed);
        if(expPerLevel < 0){
            throw new IllegalArgumentException("EXP/LVL needs to be 0 or greater");
        }
        this.expPerLevel = expPerLevel;
;    }

    public void die(){
        isAlive = false;
    }

    @Override
    int getExperienceReward() {
        return expPerLevel*super.getLevel();
    }



}
