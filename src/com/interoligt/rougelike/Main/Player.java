package com.interoligt.rougelike.Main;

import java.util.ArrayList;

public class Player {
    private int baseHP;
    private int baseSpeed;
    int level = 1;
    int upgradePoints = 0;
    int money = 0;
    private int baseDamage;
    int currentHP;
    int currentSpeed;
    int currentDamage;
    Inventory[] inventory;

    boolean alive = true;
    ArrayList<Effect> effects = new ArrayList<Effect>();
    HashMap<Slot, Equippable> equipment = new HashMap<Slot, Equippable>;

   //Create character
    public Player(int baseHP, int baseSpeed, int baseDamage, Inventory[] inventory){
        if(baseHP > 0) {
            this.baseHP = baseHP;
            currentHP = baseHP;
        }else{
            throw new IllegalArgumentException("HP needs to be above 0");
        }
        if(baseSpeed > 0) {
            this.baseSpeed = baseSpeed;
            currentSpeed = baseSpeed;
        }else{
            throw new IllegalArgumentException("Speed needs to be above 0");
        }
        if(baseDamage > 0) {
            this.baseDamage = baseSpeed;
            currentDamage = baseDamage;
        }else{
            throw new IllegalArgumentException("Base damage needs to be above 0");
        }
        this.inventory = inventory;

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
    public Inventory[] getInventory(){
        return inventory;
    }

    public int getCurrentDamage(){
        return currentDamage;
    }

    public HashMap<Slot, Equippable> getEquipment() {
        return equipment;
    }

    public void equipItem(Equippable newEquipment){
        for(i = 0; i < inventory.length; i++){
            if(i.equals(newEquipment)){
                inventory[i] = null;
                break;
            }
        }
        if(!equipment.containsKey(newEquipment.getSlot())){
            unEquipItem(newEquipment.getSlot());
        }
    }

    public void unEquipItem(Slot slot){
        for(Item i : inventory){
            if(i == null){
                i = equipment.get(slot);
                break;
            }
        }
        equipment.remove(slot);
    }

    public void addEffect(Effect effect){
        effects.add(effect);
    }

    public void removeEffect(Effect effect){
        effects.remove(effect);
    }

    public void setHP(int health){
        currentHP += health;

        if(currentHP <= 0){
            alive = false;
        }

    }

    public boolean isAlive(){
        return alive;
    }

    public void setSpeed(int speed){
        currentSpeed += speed;
        if(currentSpeed < 0){
            currentSpeed = 0;
        }
    }

    public void setDamage(int damage){
        currentDamage += damage;
        if(currentDamage < 0){
            currentDamage = 0;
        }
    }



}
