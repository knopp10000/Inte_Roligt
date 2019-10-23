package com.interoligt.rougelike.Main;

import java.util.ArrayList;

public class Shop {

    ArrayList<Item> items = new ArrayList<>();
    Player player;
    int maxItems;


    public Shop(int maxItems){
        this.maxItems=maxItems;
    }

    public Shop(ArrayList<Item> items, int maxItems) throws IllegalArgumentException {
        if(items.size() <= maxItems){
            this.maxItems=maxItems;
            this.items = items;
        }else {
            throw new IllegalArgumentException("Max Items Is Exceeded. No shop was created");
        }
    }

    public boolean addItem(Item item){
        if(items.size() < maxItems) {
            items.add(item);
            return true;
        }else{
            return false;
        }
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
