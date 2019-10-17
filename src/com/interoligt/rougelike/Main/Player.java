package com.interoligt.rougelike.Main;

public class Player {
    int baseHP;
    int baseSpeed;
    int level;
    int upgradePoints = 0;
    int money;
    int maxInventory;
    int experience = 0;

    public Player(int baseHP, int baseSpeed, int level, int maxInventory){
        this.baseHP = baseHP;
        this.baseSpeed = baseSpeed;
        this.level = level;
        this.maxInventory = maxInventory;
    }

    public int getBaseHP(){
        return baseHP;
    }

    public int getSpeed(){
        return baseSpeed;
    }

    public int getLevel(){
        return level;
    }
    public int getPoints(){
        return upgradePoints;
    }
    public int getMoney(){
        return money;
    }
    public int getMaxInventory(){
        return maxInventory;
    }
}
