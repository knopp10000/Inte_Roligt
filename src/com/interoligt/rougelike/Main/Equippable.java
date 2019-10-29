package com.interoligt.rougelike.Main;

public class Equippable extends Item {

    Slot slot;

    public Equippable(String n, int we, int wo, Effect ef, Slot slot){
        super(n, we, wo, ef);
        this.slot = slot;
    }

}
