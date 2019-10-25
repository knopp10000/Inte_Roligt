package com.interoligt.rougelike.Main;


import java.util.ArrayList;

abstract class Monster extends Target{
    private boolean active = true, alive = true;
    private Element element;


    Monster(String name, int level, Element element, int baseHealth, int baseArmour, int baseDamage, int baseSpeed) throws NullPointerException, IllegalArgumentException{
        if(name == null || element == null) {
            throw new NullPointerException("Neither name nor element is allowed to be null");
        }
        else if(name.isBlank() || level <= 0 || baseHealth <= 0 || baseArmour <= 0 || baseDamage <= 0 || baseSpeed <= 0){
            throw new IllegalArgumentException("Name cannot be blank, and all integers need to be greater than 0");
        }
        this.element = element;
        super.name = name;
        super.baseHP = baseHealth;
        super.baseDamage = baseDamage;
        super.baseSpeed = baseSpeed;
        super.level = level;
        super.currentHP = baseHealth;
        super.currentDamage = baseDamage;
        super.currentSpeed = baseSpeed;
    }

    Element getElement(){
        return element;
    }

    boolean isActive(){
        return active;
    }

    boolean isAlive(){
        return alive;
    }
    abstract int getExperienceReward();

    void setAlive(boolean bool){
        alive = bool;
    }

    void setActive(boolean bool){
        active = bool;
    }

    void changeHealth(int health){
        if(alive){
            currentHP += health;
            if(currentHP<=0){
                currentHP = 0;
                alive = false;
                active = false;
            }
        }
    }

    @Override
    public String toString(){
        return "Name: " + name + ", Level: " + level + ", Element: " + element.toString().substring(0,1) + element.toString().substring(1).toLowerCase();
    }
}
