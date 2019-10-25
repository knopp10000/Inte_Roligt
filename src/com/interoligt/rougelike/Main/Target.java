package com.interoligt.rougelike.Main;

import java.util.ArrayList;

abstract public class Target {
    int baseHP;
    int baseSpeed;
    int baseDamage;
    int currentHP;
    int currentSpeed;
    int currentDamage;
    int level;
    String name;
    ArrayList<Effect> effects = new ArrayList<Effect>();

    public void addEffect(Effect effect){
        effects.add(effect);
    }

    public void removeEffect(Effect effect){
        effects.remove(effect);
    }

    String getName(){
        return name;
    }
    int getLevel(){
        return level;
    }
    int getBaseHP(){
        return baseHP;
    };
    int getBaseDamage(){
        return baseDamage;
    }

    int getBaseSpeed(){
        return baseSpeed;
    }

    int getCurrentHP(){
        return currentHP;
    }
    abstract void changeHealth(int health);
    public void changeSpeed(int speed){
        currentSpeed += speed;
        if (currentSpeed<0){
            currentSpeed = 0;
        }
    }
    public void changeDamage(int damage){
        currentDamage += damage;
        if(currentDamage<0){
            currentDamage = 0;
        }
    }

    public int getCurrentDamage(){
        return currentDamage;
    }

    int getSpeed(){
        return baseSpeed;
    }
}
