package com.interoligt.rougelike.Main;

public class Effect {
    private Target target;
    private int duration;
    private int counter;
    private boolean hasDuration, isContinuous,hasBeenApplied;
    private boolean isActive;

    private String name;
    private int value;
    private int totValue;
    private char stat, operator;


    Effect(Target target, String name, char stat, char operator, boolean isContinuous, int value, int duration) {
        this(target, name, stat,operator,isContinuous,value);
        this.duration = duration;
        counter = duration;
        hasDuration = true;
    }

    Effect (Target target, String name, char stat, char operator, boolean isContinuous, int value) throws IllegalArgumentException,NullPointerException{
        if(target == null || name == null || name.isBlank()){
            throw new NullPointerException("Target and name cannot be null or blank");
        }
        else if(!(stat=='d'||stat=='h'||stat=='s')||!(operator=='+'||operator=='-')||value<=0){
            throw new IllegalArgumentException("Stat has to be d (damage), h (health) or s (speed), operator has to be + or -, and value has to be a positive integer");
        }
        this.target = target;
        this.name = name;
        this.stat = stat;
        this.operator = operator;
        this.isContinuous = isContinuous;
        this.value = value;
        this.isActive = true;
        target.addEffect(this);

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


    int getValueWithSign(){
        if(operator=='-'){
            return -value;
        }
        else{
            return value;
        }
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

        if(isActive) {
            if (hasDuration && isContinuous) {
                applyContinuousDurationEffect();
            } else if (hasDuration) {
                applyDurationEffect();
            } else if (isContinuous) {
                applyContinuousEffect();
            } else {
                applySingleEffect();
            }
        }
        else{
            removeEffect();
        }
    }
    public void applyContinuousDurationEffect(){
        if(counter > 0){
            applyEffectSwitch();
        }
        else{
            removeEffect();
        }
        --counter;
    }
    public void applyDurationEffect(){
        if(counter > 0){
            applySingleEffect();
        }
        else{
            removeEffect();
        }
        --counter;


    }
    public void applyContinuousEffect(){
        applyEffectSwitch();
    }

    public void applySingleEffect(){
        if(!hasBeenApplied) {
            applyEffectSwitch();
        }
        hasBeenApplied = true;
    }

    public void removeEffect(){
        if(hasDuration && !isContinuous){
            switch (stat) {
                case 'h':
                    target.changeHealth(-totValue);
                    break;
                case 's':
                    target.changeSpeed(-totValue);
                    break;
                case 'd':
                    target.changeDamage(-totValue);
                    break;
                default:
                    throw new IllegalArgumentException("Only h (health), s (speed) and d (damage) are valid inputs");
            }
        }

        isActive = false;
        target.removeEffect(this);
        target = null;
    }

    private void applyEffectSwitch() {
        totValue += getValueWithSign();
        switch (stat) {
            case 'h':
                target.changeHealth(getValueWithSign());
                break;
            case 's':
                target.changeSpeed(getValueWithSign());
                break;
            case 'd':
                target.changeDamage(getValueWithSign());
                break;
            default:
                throw new IllegalArgumentException("Only h (health), s (speed) and d (damage) are valid inputs");
        }

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
        String str = "Target: " + target.getName() + ", Name: " + name + ", Stat: " + getStatusName() + ", Effect: " + getEffectType() + " " + value;
        if(isContinuous){
            str += " each turn";
        }
        if(hasDuration){
            str += ", Duration: " + duration + " turns";
        }
        return str;
    }



}
