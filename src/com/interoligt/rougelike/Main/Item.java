package com.interoligt.rougelike.Main;

public class Item {
    String name;
    int weight;
    int worth;
    Effect effect;

    public Item(String name, int weight, int worth, Effect effect){
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
        this.effect = effect;
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

    public Effect getEffect(){
        return effect;
    }
}
