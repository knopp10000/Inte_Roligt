package com.interoligt.rougelike.Main;

public class Combat {

    private Monster[] enemies;
    private Player player;
    private Target[] turnOrder;

    public Combat(Monster[] enemies, Player player){
        this.enemies = enemies;
        this.player = player;
        turnOrder = new Target[enemies.length+1];
    }

    private void setTargetOrder(){
        for(int i = 0; i < enemies.length; i++){
            turnOrder[i] = enemies[i];
        }
        turnOrder[enemies.length] = player;

        for(int i = 0; i < turnOrder.length; i++) {
            for (int j = 1; j < turnOrder.length-i; j++) {
                if (turnOrder[j-1].getSpeed() < turnOrder[j].getSpeed()){
                    Target temp = turnOrder[j-1];
                    turnOrder[j-1] = turnOrder[j];
                    turnOrder[j] = temp;
                }
            }
        }

    }

    public Target[] getTurnOrder() {
        setTargetOrder();
        return turnOrder;
    }

    public Player getPlayer(){
        return player;
    }

    public Monster[] getMonsters(){
        return enemies;
    }
}
