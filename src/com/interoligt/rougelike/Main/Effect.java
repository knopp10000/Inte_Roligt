package com.interoligt.rougelike.Main;

public class Effect {
   private int duration;
   private int counter = duration;
   private boolean hasDuration, continuous;
   private String name;
   private double value;
   private char stat, operator;

    Effect(String name, char stat, char operator, boolean continuous, double value, int duration){
        this(name, stat,operator,continuous,value);
        this.duration = duration;
        hasDuration = true;
    }
    Effect (String name, char stat, char operator, boolean continuous, double value){
        this.name = name;
        this.stat = stat;
        this.operator = operator;
        this.continuous = continuous;
        this.value = value;
    }

    boolean hasDuration(){
        return hasDuration;
    }
    boolean isContinuous(){
        return continuous;
    }

    int getDuration(){
        return duration;
    }
    double getValue(){
        return value;
    }



}
