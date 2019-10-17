package com.interoligt.rougelike.Main;

public class BasicMonster extends Monster {

    public BasicMonster(String name, int level, Element element, int baseHealth, int baseArmour, int baseDamage, int baseSpeed){
        super(name,level,element, baseHealth, baseArmour, baseDamage, baseSpeed);
;    }

    @Override
    public String toString(){
        return "Name: " + super.getName() + ", Level: " + super.getLevel() + ", Element: " + super.getElement().toString().substring(0,1) + super.getElement().toString().substring(1).toLowerCase();
    }

}
