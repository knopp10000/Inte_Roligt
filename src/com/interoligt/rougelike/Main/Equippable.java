package com.interoligt.rougelike.Main;

public class Equippable extends Item {

    Slot slot;

    public Equippable(String n, int we, int wo, Slot slot){
        super(n, we, wo);
        this.slot = slot;
    }

}
