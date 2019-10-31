package com.interoligt.rougelike.Main;

import java.util.ArrayList;

abstract public class Target{
    private int maxHP;
    private int baseSpeed;
    private int baseDamage;
    private int currentHP;
    private int currentSpeed;
    private int currentDamage;
    private int level;

    public boolean isAlive = true;
    ArrayList<Effect> effects = new ArrayList<>();
    ArrayList<Effect> effectsNotActivedThisTurn = new ArrayList<>();


    public Target(int maxHP, int baseSpeed, int baseDamage, int level){
        if(maxHP > 0) {
            this.maxHP = maxHP;
            currentHP = maxHP;
        }else{
            throw new IllegalArgumentException("HP needs to be above 0");
        }
        if (baseDamage >= 0){
            this.baseDamage = baseDamage;
            currentDamage = baseDamage;
        }else{
            throw new IllegalArgumentException("BaseDamage needs to be above 0");
        }
        if(baseSpeed > 0){
            this.baseSpeed = baseSpeed;
            currentSpeed = baseSpeed;
        }else{
            throw new IllegalArgumentException("BaseSpeed needs to be above 0");
        }
        if(level >= 0){
            this.level = level;
        }else{
            throw new IllegalArgumentException("Level needs to be above 0");
        }
    }

    public Target(int maxHP, int baseSpeed, int baseDamage){
        this(maxHP, baseSpeed, baseDamage, 1);
    }

    public void applyEffects(){
        for(Effect e : effectsNotActivedThisTurn){
            e.applyEffect();
        }
        effectsNotActivedThisTurn.clear();
    }

    public void newTurnForEffects(){
        effectsNotActivedThisTurn.addAll(effects);
    }

    public void addEffect(Effect effect){
      if(effect != null) {
          effects.add(effect);
          effect.setTarget(this);
          effectsNotActivedThisTurn.add(effect);
      }
    }

    public void removeEffect(Effect effect){
        effects.remove(effect);
        effectsNotActivedThisTurn.remove(effect);
    }
    int getLevel(){
        return level;
    }
    int getMaxHP(){
        return maxHP;
    };
    int getBaseDamage(){
        return baseDamage;
    }

    int getBaseSpeed(){
        return baseSpeed;
    }

    int getCurrentHP(){
        return currentHP;
    }

    //MANIPULATES TARGETS CURRENT HEALTH
    public void changeHealth(int health){
        if(isAlive){
           currentHP += health;
           if (currentHP > maxHP){
               currentHP = maxHP;
           }
           if(currentHP <= 0) {
               currentHP = 0;
               die();
           }
        }
    }

    public void attack(Target target){
        target.changeHealth(-(getCurrentDamage()));
    }

    public void changeSpeed(int speed){
        currentSpeed += speed;
        if (currentSpeed<0){
            currentSpeed = 0;
        }
    }
    public void changeDamage(int damage){
        currentDamage += damage;
        if(currentDamage<0){
            currentDamage = 0;
        }
    }

    public int getCurrentDamage(){
        return currentDamage;
    }

    int getSpeed(){
        return baseSpeed;
    }

    int getCurrentSpeed(){
        return currentSpeed;
    }

    abstract void die();
}
