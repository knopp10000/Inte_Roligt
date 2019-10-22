package com.interoligt.rougelike.Main;

public class BossMonster extends Monster {
    private int experienceReward;

    public BossMonster(String name, int level, int experienceReward, Element element, int baseHealth, int baseArmour, int baseDamage, int baseSpeed) throws IllegalArgumentException{
        super(name,level,element, baseHealth, baseArmour, baseDamage, baseSpeed);
        if(experienceReward <= 0){
            throw new IllegalArgumentException("All integers need to be greater than 0");
        }
        this.experienceReward = experienceReward;
    }

    @Override
    int getExperienceReward() {
        return experienceReward;
    }

}
