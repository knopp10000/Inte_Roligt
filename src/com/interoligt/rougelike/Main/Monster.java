package com.interoligt.rougelike.Main;

public abstract class Monster {
    int baseHealth, baseArmour, baseDamage, level, baseSpeed;
    String name;
    boolean isActive, isAlive;
    Element element;

    protected Monster(String name, int level, Element element, int baseHealth, int baseArmour, int baseDamage, int baseSpeed){
        this.name = name;
        this.element = element;
        this.baseArmour = baseArmour;
        this.baseHealth = baseHealth;
        this.baseDamage = baseDamage;
        this.baseSpeed = baseSpeed;
        this.level = level;
    }
}
