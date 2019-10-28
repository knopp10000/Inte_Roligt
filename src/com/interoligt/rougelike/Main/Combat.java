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

    private boolean enemiesAreAlive(){
        for(Monster m : enemies){
            if(m.isAlive()){
                return true;
            }
        }return false;
    }

    public Player getPlayer(){
        return player;
    }

    public Monster[] getMonsters(){
        return enemies;
    }

    public boolean runTurn(){
        while(player.isAlive() && enemiesAreAlive()) {
            for (Target t : getTurnOrder()) {
                if (t instanceof Player) {
                    Player p = (Player)t;
                    p.applyEffect();
                    p.makeTurn(enemies);
                }
                if (t instanceof BasicMonster) {
                    Monster m = (Monster)t;
                    m.applyEffect();
                    m.makeTurn(player);
                }
            }
        }
        if(!enemiesAreAlive()){
            return true;
        }
        else{
            return false;
        }
    }

}
