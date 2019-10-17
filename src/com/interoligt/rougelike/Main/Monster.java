package com.interoligt.rougelike.Main;


abstract class Monster {
    private int baseHealth, baseArmour, baseDamage, level, baseSpeed, experienceReward;
    private String name;
    private boolean Active, Alive;
    private Element element;

    Monster(String name, int level, Element element, int baseHealth, int baseArmour, int baseDamage, int baseSpeed){
        this.name = name;
        this.element = element;
        this.baseArmour = baseArmour;
        this.baseHealth = baseHealth;
        this.baseDamage = baseDamage;
        this.baseSpeed = baseSpeed;
        this.level = level;
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

    int getBaseHealth(){
        return baseHealth;
    };

    int getBaseArmour(){
        return baseArmour;
    }

    int getBaseDamage(){
        return baseDamage;
    }

    int getBaseSpeed(){
        return baseSpeed;
    }

}
