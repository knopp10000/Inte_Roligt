package com.interoligt.rougelike.Main;

public class Map{
    int playerCordX = 0;
    int playerCordY = 0;

    Room[][] map;

    public Map(Room[][] map){
        this.map = map;
    }

    Room move(Character dir) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        Room newRoom;
        switch (dir){
            case 'u':
                try{
                    return map[playerCordX][playerCordY + 1];
                } catch (ArrayIndexOutOfBoundsException e){
                    return null;
                }
            case 'd':
                try{
                    return map[playerCordX][playerCordY - 1];
                } catch (ArrayIndexOutOfBoundsException e){
                    return null;
                }
            case 'r':
                try{
                    return map[playerCordX + 1][playerCordY];
                } catch (ArrayIndexOutOfBoundsException e){
                    return null;
                }
            case 'l':
                try {
                    return map[playerCordX - 1][playerCordY];
                } catch (ArrayIndexOutOfBoundsException e){
                return null;
            }
        }
        throw new IllegalArgumentException("only: u, d, r, l are valid inputs.");
    }
}
