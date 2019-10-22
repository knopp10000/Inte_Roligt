package com.interoligt.rougelike.Main;


abstract class Monster {
    private int baseHealth, baseArmour, baseDamage, level, baseSpeed;
    private int currentHealth;
    private String name;
    private boolean active = true, alive = true;
    private Element element;

    Monster(String name, int level, Element element, int baseHealth, int baseArmour, int baseDamage, int baseSpeed) throws NullPointerException, IllegalArgumentException{
        if(name == null || element == null) {
            throw new NullPointerException("Neither name nor element is allowed to be null");
        }
        else if(name.isBlank() || level <= 0 || baseHealth <= 0 || baseArmour <= 0 || baseDamage <= 0 || baseSpeed <= 0){
            throw new IllegalArgumentException("Name cannot be blank, and all integers need to be greater than 0");
        }
        this.name = name;
        this.element = element;
        this.baseArmour = baseArmour;
        this.baseHealth = baseHealth;
        this.baseDamage = baseDamage;
        this.baseSpeed = baseSpeed;
        this.level = level;

        currentHealth = baseHealth;
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

    int getSpeed(){
        // ToDo: add speed effect to calc of speed when accessible
        return baseSpeed;
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

    int getCurrentHealth(){
        return currentHealth;
    }

    void damage(int dmg){
        if (!alive){
            return;
        }
        else if(currentHealth <= dmg){
            currentHealth = 0;
            alive = false;
        }
        else{
            currentHealth -= dmg;
        }
    }

    void heal(int hp){
        if (!alive){
            return;
        }
        else if(hp + currentHealth >= baseHealth){
            currentHealth = baseHealth;
        }
        else{
            currentHealth += hp;
        }
    }

    @Override
    public String toString(){
        return "Name: " + name + ", Level: " + level + ", Element: " + element.toString().substring(0,1) + element.toString().substring(1).toLowerCase();
    }
}
