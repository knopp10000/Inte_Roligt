package com.interoligt.rougelike.Main;

import java.util.ArrayList;
import java.util.HashMap;

public class Player extends Target{

    int upgradePoints = 0;
    int money = 0;
    Inventory inventory;

    boolean alive = true;

    HashMap<Slot, Equippable> equipment = new HashMap<>();

   //Create character
    public Player(int baseHP, int baseSpeed, int baseDamage, Inventory inventory){
        if(baseHP > 0) {
            this.baseHP = baseHP;
            currentHP = baseHP;
        }else{
            throw new IllegalArgumentException("HP needs to be above 0");
        }
        if(baseSpeed > 0) {
            this.baseSpeed = baseSpeed;
            this.currentSpeed = baseSpeed;
        }else{
            throw new IllegalArgumentException("Speed needs to be above 0");
        }
        if(baseDamage > 0) {
            this.baseDamage = baseDamage;
            this.currentDamage = currentDamage;
        }else{
            throw new IllegalArgumentException("Base damage needs to be above 0");
        }
        this.inventory = inventory;
        level = 1;
    }

    public int getBaseHP(){
        return baseHP;
    }

    public int getSpeed(){
        return currentSpeed;
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
    public void addMoney(int m){
        money += m;
    }
    public void withdrawMoney(int m){
        money -= m; 
    }

   public Inventory getInventory(){
        return inventory;
    }


    public HashMap<Slot, Equippable> getEquipment() {
        return equipment;
    }

//    public void equipItem(Equippable newEquipment){
//        for(i = 0; i < inventory.length; i++){
//            if(i.equals(newEquipment)){
//                inventory[i] = null;
//                break;
//            }
//        }
//        if(!equipment.containsKey(newEquipment.getSlot())){
//            unEquipItem(newEquipment.getSlot());
//        }
//    }

//    public void unEquipItem(Slot slot){
//        for(Item i : inventory){
//            if(i == null){
//                i = equipment.get(slot);
//                break;
//            }
//        }
//        equipment.remove(slot);
//    }

    public void changeHealth(int health){
        if(alive){
            currentHP += health;
            if(currentHP <= 0) {
                currentHP = 0;
                alive = false;
            }
        }
    }


    public boolean isAlive(){
        return alive;
    }

//    public void setSpeed(int speed){
//        currentSpeed += speed;
//        if(currentSpeed < 0){
//            currentSpeed = 0;
//        }
//    }
//
//    public void setDamage(int damage){
//        currentDamage += damage;
//        if(currentDamage < 0){
//            currentDamage = 0;
//        }
//    }
}
