package com.interoligt.rougelike.Main;

abstract class Monster extends Target{
    private boolean active = true;
    private Element element;
    private String name;

    Monster(String name, int level, Element element, int baseHealth, int baseDamage, int baseSpeed) throws IllegalArgumentException, IllegalArgumentException{
        super(baseHealth, baseSpeed, baseDamage, level);
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cant be null nor empty");
        }
        else if(element == null){
            throw new IllegalArgumentException("element can't be null");
        }
        this.element = element;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    Element getElement(){
        return element;
    }

    boolean isActive(){
        return active;
    }

    abstract int getExperienceReward();

    void setActive(boolean bool){
        active = bool;
    }

    @Override
    public String toString(){
        return "Name: " + name + ", Level: " + getLevel() + ", Element: " + element.toString().substring(0,1) + element.toString().substring(1).toLowerCase();
    }
}
