package com.interoligt.rougelike.Main;

public class Effect {
    private Monster target; //TODO Change to Target
    private int duration;
    private int counter;
    private boolean hasDuration, isContinuous;
    private String name;
    private int value;
    private char stat, operator;

    Effect(Monster target, String name, char stat, char operator, boolean isContinuous, int value, int duration){ //TODO Change to Target
        this(target, name, stat,operator,isContinuous,value);
        this.duration = duration;
        counter = duration;
        hasDuration = true;
    }
    Effect (Monster target, String name, char stat, char operator, boolean isContinuous, int value){ //TODO Change to Target
        this.target = target;
        this.name = name;
        this.stat = stat;
        this.operator = operator;
        this.isContinuous = isContinuous;
        this.value = value;
    }

    boolean hasDuration(){
        return hasDuration;
    }
    boolean isContinuous(){
        return isContinuous;
    }

    int getDuration(){
        if(hasDuration) {
            return duration;
        }
        else{
            throw new NullPointerException("Effect has no duration.");
        }
    }
    double getValue(){
        return value;
    }

    char getStat(){
        return stat;
    }
    int getCounter(){
        if(hasDuration){
            return counter;
        }
        else{
            throw new NullPointerException("Effect has no duration.");
        }
    }

    public void applyEffect(){
    }

    String getStatusName(){
        switch(stat) {
            case 'h':
                return "Health";
            case 's':
                return "Speed";
            case 'd':
                return "Damage";
            default:
                return "No Status";
        }
    }
    String getEffectType(){
            switch(operator) {
                case '+':
                    return "Add";
                case '-':
                    return "Subtract";
                default:
                    return "No Effect";
            }
        }
    @Override
    public String toString(){
        String str = "Name: " + name + ", Stat: " + getStatusName() + ", Effect: " + getEffectType() + " " + value;
        if(isContinuous){
            str += " each turn";
        }
        if(hasDuration){
            str += ", Duration: " + duration + " turns";
        }
        return str;
    }



}
