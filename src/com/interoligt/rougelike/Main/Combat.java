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

        for(Target i : enemies) {
            for (Monster j : enemies) {
                if (j.getSpeed() > i.getSpeed()){
                    Target temp = i;
                    i = j;
                    j = temp;
                }
            }
        }

    }



    public Player getPlayer(){
        return player;
    }

    public Monster[] getMonsters(){
        return enemies;
    }
}
