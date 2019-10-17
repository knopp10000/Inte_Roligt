package com.interoligt.rougelike.Main;

public class Item {
    String name;
    int weight;
    int worth;

    public Item(String name, int weight, int worth){
        if(!name.isBlank() && !name.isBlank()){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Name must have letters");
        }
        if(weight > 0){
            this.weight = weight;
        }else{
            throw new IllegalArgumentException("Item must have a weight");
        }
        if(worth > 0){
            this.worth = worth;
        }else{
            throw new IllegalArgumentException("Item must have worth");
        }
    }

    public String getName(){
        return name;
    }

    public int getWeight(){
        return weight;
    }

    public int getWorth(){
        return worth;
    }
}
