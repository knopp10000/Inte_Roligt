package com.interoligt.rougelike.Main;

import java.util.ArrayList;

public class Inventory {
    private int maxItemCount;
    private ArrayList<Item> items;

    public Inventory(int maxItemCount, ArrayList<Item> items){
        if(maxItemCount > 0 ){
            if (items != null) {
                if (items.size() <= maxItemCount) {
                    this.items = items;
                }else{
                    throw new IllegalArgumentException("items exceed the maxItemCount");
                }
            }else{
                this.items = new ArrayList<Item>();
            }
            this.maxItemCount = maxItemCount;
        }else{
            throw new IllegalArgumentException("Max Item Count needs to be over zero");
        }
    }
    public Inventory(int maxItemCount){
        this(maxItemCount, null);   }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    public void addItem(Item item) throws Exception {
       if (items.size() ==  maxItemCount){
           throw new Exception();
       } else {
           items.add(item);
       }
    }

    public ArrayList<Item> getItemsCopy() {
        return new ArrayList<Item>(items);
    }

    public int getWeight(){
        int weight = 0;
        for (Item item : items){
            weight += item.getWeight();
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
