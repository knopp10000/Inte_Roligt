package com.interoligt.rougelike.Main;

import java.util.ArrayList;
import java.util.Arrays;

public class Room {

    private boolean activated = false;
    private ArrayList<Monster> monsters;

    public Room(Monster... m) {
        this.monsters = new ArrayList<Monster>(Arrays.asList(m));
    }

    public void activate(){
        activated = true;
    }

    public void deActivate(){
        activated = false;
    }

    public boolean isActivated(){
        return activated;
    }

    public boolean addMonsterToRoom(Monster monster){
        return monsters.add(monster);
    }

    public boolean removeMonsterFromRoom(Monster monster){
        return monsters.remove(monster);
    }

    public ArrayList<Monster> showAllMonsters(){
        return new ArrayList<>(monsters);
    }

}
