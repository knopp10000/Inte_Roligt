package com.interoligt.rougelike.Main;

public class Player {
    int baseHP;
    int baseSpeed;
    int level = 1;
    int upgradePoints = 0;
    int money;
    Item[] inventory;

   //Create character
    public Player(int baseHP, int baseSpeed, Item[] inventory){
        this.baseHP = baseHP;
        this.baseSpeed = baseSpeed;
        this.inventory = inventory;
    }

    public Player(int baseHP, int baseSpeed){
        this.baseHP = baseHP;
        this.baseSpeed = baseSpeed;
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
    public Item[] getInventory(){
        return inventory;
    }
}
