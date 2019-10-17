package com.interoligt.rougelike.Main;

public class Combat {

    private Monster[] enemies;
    private Room room;

    public Combat(Monster[] enemies, Room room){
        this.enemies = enemies;
        this.room = room;
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
