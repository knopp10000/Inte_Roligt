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
        if(baseHP > 0) {
            this.baseHP = baseHP;
        }else{
            throw new IllegalArgumentException(baseHP + " needs to be above 0");
        }
        if(baseSpeed > 0) {
            this.baseSpeed = baseSpeed;
        }else{
            throw new IllegalArgumentException(baseSpeed + " needs to be above 0");
        }
        this.inventory = inventory;
    }

    public Player(int baseHP, int baseSpeed){
        if(baseHP > 0) {
            this.baseHP = baseHP;
        }else{
            throw new IllegalArgumentException(baseHP + " needs to be above 0");
        }
        if(baseSpeed > 0) {
            this.baseSpeed = baseSpeed;
        }else{
            throw new IllegalArgumentException(baseSpeed + " needs to be above 0");
        }
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
