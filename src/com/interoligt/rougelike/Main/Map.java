package com.interoligt.rougelike.Main;

public class Map{
    private int playerCordX;
    private int playerCordY;

    private Room[][] map;

    public Map(Room[][] map, int playerCordX, int playerCordY){
        this.map = map;
        this.playerCordX = playerCordX;
        this.playerCordY = playerCordY;
    }

    public void setPlayerCordX(int playerCordX) {
        this.playerCordX = playerCordX;
    }

    public void setPlayerCordY(int playerCordY) {
        this.playerCordY = playerCordY;
    }

    public int getPlayerCordX() {
        return playerCordX;
    }

    public int getPlayerCordY() {
        return playerCordY;
    }

    Room move(Character dir) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        Room newRoom;
        switch (dir){
            case 'u':
                try{
                    newRoom = map[playerCordX][playerCordY + 1];
                    playerCordY += 1;
                    return newRoom;
                } catch (ArrayIndexOutOfBoundsException e){
                    return null;
                }
            case 'd':
                try{
                    newRoom = map[playerCordX][playerCordY - 1];
                    playerCordY -= 1;
                    return newRoom;
                } catch (ArrayIndexOutOfBoundsException e){
                    return null;
                }
            case 'r':
                try{
                    newRoom = map[playerCordX + 1][playerCordY];
                    playerCordX += 1;
                    return newRoom;
                } catch (ArrayIndexOutOfBoundsException e){
                    return null;
                }
            case 'l':
                try {
                    newRoom = map[playerCordX - 1][playerCordY];
                    playerCordX -= 1;
                    return newRoom;
                } catch (ArrayIndexOutOfBoundsException e){
                return null;
            }
        }
        throw new IllegalArgumentException("only: u, d, r, l are valid inputs.");
    }
}
