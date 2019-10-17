package com.interoligt.rougelike.Main;


abstract class Monster {
    private int baseHealth, baseArmour, baseDamage, level, baseSpeed;
    private String name;
    private boolean Active = true, Alive = true;
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

    boolean isActive(){
        return Active;
    }

    boolean isAlive(){
        return Alive;
    }
    abstract int getExperienceReward();

    @Override
    public String toString(){
        return "Name: " + name + ", Level: " + level + ", Element: " + element.toString().substring(0,1) + element.toString().substring(1).toLowerCase();
    }
}
