package com.interoligt.rougelike.Main;

import java.util.HashMap;

public class Player extends Target{
    int upgradePoints = 0;
    int money = 0;
    Inventory inventory;
    int exp;

    HashMap<Slot, Equippable> equipment = new HashMap<>();

    public Player(int baseHP, int baseSpeed, int baseDamage, Inventory inventory){
        super(baseHP, baseSpeed, baseDamage);
        this.inventory = inventory;
    }

    public void makeTurn(Monster[] monsters){
        Monster target = chooseTarget(monsters);
    }

    private Monster chooseTarget(Monster[] monsters){
        return monsters[0];
    }

    public int getPoints(){
        return upgradePoints;
    }
    public int getMoney(){
        return money;
    }
    public void addMoney(int amount){
        money += amount;
    }
    public void withdrawMoney(int amount){
        money -= amount;
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

        public void die(){
            isAlive = false;
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
