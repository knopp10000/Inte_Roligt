package com.interoligt.rougelike.Main;

import com.interoligt.rougelike.Mocks.UIPlayerMoveMock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProfilerTestProgram {
    ArrayList<Character> chars = new ArrayList<>(Arrays.asList('u','d', 'l', 'r'));
    Scanner scanner = new Scanner(System.in);

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
    Map awesomeMap = new Map(roomArray,0,0);

    Effect healthDrain = new Effect("Health Drain", 'h','-',false,4,3);
    Item carrotOfDeath = new Item("Golden Carrot of Death", 2, 250, healthDrain);
    ArrayList<Item> itemArray = new ArrayList<>(Arrays.asList(carrotOfDeath));
    Inventory inventory = new Inventory(10, itemArray);

    Player player = new Player(250,3, 7, inventory);
    ArrayList<Move> onlyAttackMove = new ArrayList<> (Arrays.asList(Move.ATTACK));

    public static void main(String[] args) {
        new ProfilerTestProgram().start();
    }

    private void start(){
        Room currentRoom = awesomeMap.getCurrentRoom();
        player.setChosenItem(carrotOfDeath);

        while(player.isAlive){
            char dir = getDirectionInput();
            if (dir != 'x'){
                if (awesomeMap.move(dir) != null){
                    Combat combat = initCombatFromRoom(currentRoom, player);
                    if (!combat.isCombatFinished()){
                        combat.start();
                        if (player.isAlive){
                            System.out.println("You won that fight good job!");
                        }
                    }else{
                        System.out.println("You have killed everyone in this room already...keep walking!");
                    }
                }else{
                    System.out.println("You cant go that way");
                }
            }else {
                System.out.println("Exiting the game now are you? Bye~");
                break;
            }
        }
        System.out.println("You lost");
    }

    private char getDirectionInput() {
        scanner = new Scanner(System.in);
        System.out.println("Go somewhere and fight!");
        String s = scanner.next();
        char c = s.charAt(0);
        while(!chars.contains(c) && !(c == 'x')){
            s = scanner.next();
            c = s.charAt(0);
            if(!chars.contains(c)){
                if (!(c == 'x')){
                    System.out.println("Thats not a valid direction!");
                }
            }
        }
        return c;
    }

    Combat initCombatFromRoom(Room room, Player player){
        Monster[] monsters = room.showAllMonsters().toArray(new Monster[0]);
        return new Combat(monsters, player, new UIPlayerMoveMock(onlyAttackMove));
    }
}
