package com.interoligt.rougelike.Main;

public class Target {
    int baseHP;
    int baseSpeed;
    int baseDamage;
    int currentHP;
    int level;
    String name;

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

    public int getCurrentDamage(){
        return baseDamage;
    }

    int getSpeed(){
        // ToDo: add speed effect to calc of speed when accessible
        return baseSpeed;
    }
}
