package com.interoligt.rougelike.Main;

public class Map {

    int playerCordX = 0;
    int playerCordY = 0;

    Room[][] map;

    public Map(Room[][] map){
        this.map = map;
    }

    Room move(Character dir) throws IllegalArgumentException {
        switch (dir){
            case 'u':
                Room room = map[playerCordX][playerCordY + 1];
                if (room != null){
                    playerCordY += 1;
                }
                return room;
            case 'd':
                return map[playerCordX][playerCordY - 1];
            case 'r':
                return map[playerCordX + 1][playerCordY];
            case 'l':
                return map[playerCordX - 1][playerCordY];
        }
        throw new IllegalArgumentException("only: u, d, r, l are valid inputs.");
    }
}
