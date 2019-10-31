package com.interoligt.rougelike.Main;

public class Player extends Target{
    int money = 0;
    Inventory inventory;
    Item chosenItem;

    public Player(int baseHP, int baseSpeed, int baseDamage, Inventory inventory){
        super(baseHP, baseSpeed, baseDamage);
        this.inventory = inventory;
    }

    public void setChosenItem(Item item){
        if (inventory.getItemsCopy().contains(item)){
            chosenItem = item;
        }
    }
    
    public int getMoney(){
        return money;
    }

   public Inventory getInventory(){
        return inventory;
    }

    public void withdrawMoney(int amount){
        money -= amount;
    }

    public void addMoney(int amount){
        money += amount;
    }


//    public void unEquipItem(Slot slot){
//        for(Item i : inventory){
//            if(i == null){
//                i = equipment.get(slot);
//                break;
//            }
//        }
//        equipment.remove(slot);
//    }

    //CHANGES ALIVE VARIABLE FOR PLAYER
    @Override
        public void die(){
            isAlive = false;
        }




    //APPLIES ARGUMENT MOVE TO ARGUMENT TARGET
    public void applyMove(Target chosenTarget, Move move){
        switch(move){
            case ATTACK:
                attack(chosenTarget);
                break;
            case ITEM:
                useItem(chosenTarget);
                break;
            default:
                break;
        }
    }

    private void useItem(Target chosenTarget) {
        if (chosenItem != null){
            Effect effect = chosenItem.getEffect();
            if (effect != null){
                chosenTarget.addEffect(effect);
                inventory.removeItem(chosenItem);
                chosenItem = null;
            }
        }
    }
}
