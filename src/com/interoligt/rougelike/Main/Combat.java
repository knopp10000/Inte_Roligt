package com.interoligt.rougelike.Main;

public class Combat {
    private Monster[] enemies;
    private Player player;
    private Target[] turnOrder;
    private int turnCounter = 0;
    private Move chosenMove;
    private Target chosenTarget;

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

    //DETERMINES TURN ORDER
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

    //CHECKS IF ANY ENEMIES ARE ALIVE
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

    private Target getNextTurn(){
        int currentTurn = turnCounter;

        if(turnCounter == turnOrder.length-1){
            turnCounter = 0;
        }else{
            turnCounter++;
        }
        return turnOrder[currentTurn];
    }

    //RUNS TURN FOR NEXT ACTOR
    public void runTurn(){
        Target next = getNextTurn();
        if(next.isAlive) {
            next.applyEffects();
            if (next instanceof Player) {
                player.applyMove(chosenTarget, chosenMove);
                System.out.println(chosenTarget.getCurrentHP());
            } else if (next instanceof Monster) {
                next.attack(player);
                System.out.println(player.getCurrentHP());
            }
        }
        }


        //RECEIVES NEXT MOVE AND TARGET REQUESTED BY USER TO USE FOR NEXT PLAYER ROUND
    public void setChosenMove(Move chosenMove){
        this.chosenMove = chosenMove;
    }

    public void setChosenTarget(Target chosenTarget){
        this.chosenTarget = chosenTarget;
    }


//CHECKS IF PLAYER IS ALIVE AND IF ENEMIES ARE ALIVE TO DETERMINE IF COMBAT IS OVER

    public boolean combatFinished(){
        if(!enemiesAreAlive()){
            return true;
        }
        else if(!player.isAlive){
            return true;
        }
        return false;
    }

}
