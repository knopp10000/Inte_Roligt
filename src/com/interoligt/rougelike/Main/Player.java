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

    boolean alive = true;
    ArrayList<Effect> effect = new ArrayList<Effect>();

    Item[] inventory = new Item[10];
    HashMap<Slot, Equippable> equipment = new HashMap<Slot, Equippable>;

   //Create character
    public Player(int baseHP, int baseSpeed, int baseDamage){
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
    public Item[] getInventory(){
        return inventory;
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

    public void addEffect(Effect effect, String effectType){
        switch(effectType){
            case "off":
                offEffect.add(effect);
                break;

            case "def":
                defEffect.add(effect);
                break;

            case "con":
                continEffect.add(effect);
                break;
            default:
                break;
        }
    }

    public void removeEffect(Effect effect){
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
