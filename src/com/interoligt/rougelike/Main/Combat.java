package com.interoligt.rougelike.Main;

public class Combat {

    private Monster[] enemies;
    private Player player;

    public Combat(Monster[] enemies, Player player){
        this.enemies = enemies;
        this.player = player;
    }

    private void runTurnOrder(){
        Monster[] turnOrder = enemies;
        for(Monster i : turnOrder) {
            for (Monster j : turnOrder) {
                if (j.getSpeed() > i.getSpeed()){
                    Monster temp = i;
                    i = j;
                    j = temp;
                }
            }
        }

    }
}
