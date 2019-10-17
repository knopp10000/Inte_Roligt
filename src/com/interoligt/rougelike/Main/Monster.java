package com.interoligt.rougelike.Main;

import static com.interoligt.rougelike.Main.Element.FIRE;

abstract class Monster {
    private int baseHealth, baseArmour, baseDamage, level, baseSpeed, experienceReward;
    private String name;
    private boolean isActive, isAlive;
    private Element element;

    Monster(String name, int level, Element element, int baseHealth, int baseArmour, int baseDamage, int baseSpeed){
        this.name = name;
        this.element = element;
        this.baseArmour = baseArmour;
        this.baseHealth = baseHealth;
        this.baseDamage = baseDamage;
        this.baseSpeed = baseSpeed;
        this.level = level;
        this.experienceReward = experienceReward;
    }

    String getName(){
        return name;
    }
    int getLevel(){
        return level;
    }
    Element getElement(){
        return element;
    }
}
