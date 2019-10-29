package com.interoligt.rougelike.Main;

public class Combat {
    private Monster[] enemies;
    private Player player;
    private Target[] turnOrder;

    public Combat(Monster[] enemies, Player player){
        if (player != null){
            this.player = player;
        }else{
            throw new IllegalArgumentException("player cant be null");
        }
        if(enemies != null) {
            this.enemies = enemies;
        }else {
            throw new IllegalArgumentException("enemies cant be null");
        }
        this.turnOrder = new Target[enemies.length+1];
        setTurnOrder();
    }

    private void setTurnOrder(){
//        for(int i = 0; i < enemies.length; i++){
//            turnOrder[i] = enemies[i];
//        }
        System.arraycopy(enemies,0,turnOrder,0,enemies.length);
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
        setTurnOrder();
        return turnOrder;
    }

    private boolean enemiesAreAlive(){
        for(Monster m : enemies){
            if(m.isAlive){
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

    public void runTurn(){

            for (Target t : getTurnOrder()) {
                if (t instanceof Player) {
                    Player p = (Player)t;
                    p.applyEffects();
                    p.makeTurn();
                }
                if (t instanceof BasicMonster) {
                    Monster m = (Monster)t;
                    m.applyEffects();
                    m.makeTurn(player);
                }
            }
            if(!combatFinished()){
                runTurn();
            }
    }

    public boolean combatFinished(){
        if(!enemiesAreAlive()){
            return true;
        }
        else{
            return false;
        }
    }

}
