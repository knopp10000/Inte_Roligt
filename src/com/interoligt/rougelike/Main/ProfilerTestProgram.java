package com.interoligt.rougelike.Main;

import java.util.ArrayList;
import java.util.Arrays;

public class ProfilerTestProgram {
    public static void main(String[] args) {
        Monster spider1 = new BasicMonster("Spider", 1, 2, Element.GROUND, 8, 3, 4);
        Monster spider2 = new BasicMonster("Spider", 1, 2, Element.GROUND, 8, 3, 4);
        Monster spider3 = new BasicMonster("Spider", 1, 2, Element.GROUND, 8, 3, 4);
        Room room00 = new Room(spider1,spider2,spider3);
        Monster unicorn = new BasicMonster("Magic Unicorn", 2,5, Element.THUNDER,15,5,2);
        Room room01 = new Room(unicorn);
        Monster narwhal1 = new BasicMonster("Narwhal", 3, 2, Element.WATER,10,5,3);
        Monster narwhal2 = new BasicMonster("Narwhal", 3, 2, Element.WATER,10,5,3);
        Room room11 = new Room(narwhal1,narwhal2);
        Monster fireLizard = new BasicMonster("Fire Lizard", 4, 3, Element.FIRE, 18, 6, 5);
        Room room10 = new Room(fireLizard);
        Room[][] roomArray = {{room00,room01},{room10,room11}};
        Map AwesomeMap = new Map(roomArray,0,0);
        Effect healthDrain = new Effect("Health Drain", 'h','-',false,4,3);
        Item carrotOfDeath = new Item("Golden Carrot of Death", 2, 250, healthDrain);
        ArrayList<Item> itemArray = new ArrayList<>();
        itemArray.add(carrotOfDeath);
        Inventory inventory = new Inventory(10,itemArray);
        Player player = new Player(250,3, 7, inventory);
        player.setChosenItem(carrotOfDeath);

    }
}
