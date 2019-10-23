package com.interoligt.rougelike.Main;

import java.util.ArrayList;

public class Inventory {
    private int maxItemCount;
    private ArrayList<Item> items;

    public Inventory(int maxItemCount, ArrayList<Item> items){
        if (items.size()> maxItemCount){
            throw new IllegalArgumentException();
        } else {
            this.maxItemCount = maxItemCount;
            this.items = items;
        }
    }

    public Inventory(int maxItemCount){
        this.maxItemCount = maxItemCount;
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    public void addItem(Item item) throws Exception {
       if (getItemCount() >=  maxItemCount){
           throw new Exception();
       } else {
           items.add(item);
       }
    }

     public int getWeight(){
        int weight = 0;
        for (Item item : items ){
            weight =+ item.getWeight();
        }
        return weight;
    }

    public int getItemCount() {
       return items.size();
    }

    public int getMaxItemCount() {
      return maxItemCount;
    }

    public ArrayList<Item> showAllItems(){
        return new ArrayList<Item>(items);
    }
}
