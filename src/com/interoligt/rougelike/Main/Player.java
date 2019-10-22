package com.interoligt.rougelike.Main;

import java.util.ArrayList;

public class Player {
    int baseHP;
    int baseSpeed;
    int level = 1;
    int upgradePoints = 0;
    int money = 0;
    ArrayList<Effect> offEffect = new ArrayList<Effect>();
    ArrayList<Effect> defEffect = new ArrayList<Effect>();
    ArrayList<Effect> continEffect = new ArrayList<Effect>();

    Item[] inventory = new Item[10];
    HashMap<Slot, Equippable> equipment = new HashMap<Slot, Equippable>;

    equipment.put(WEAPON, null);
    equipment.put(HEAD, null);
    equipment.put(SHOULDERS, null);
    equipment.put(CHEST, null);
    equipment.put(HANDS, null);
    equipment.put(LEGS, null);
    equipment.put(FEET, null);


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
        if(equipment.get(newEquipment.getSlot()) != null){
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
        equipment.replace(slot, null);
    }

}
