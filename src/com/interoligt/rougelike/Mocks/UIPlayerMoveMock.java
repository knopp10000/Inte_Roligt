package com.interoligt.rougelike.Mocks;

import com.interoligt.rougelike.Main.Item;
import com.interoligt.rougelike.Main.Monster;
import com.interoligt.rougelike.Main.Move;
import com.interoligt.rougelike.Main.Target;
import com.interoligt.rougelike.UI.UIPlayerMove;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UIPlayerMoveMock extends UIPlayerMove {

    ArrayList<Move> moves;
    int moveCounter = 0;

    public UIPlayerMoveMock(ArrayList<Move> moves){
        this.moves = moves;
    }

    @Override
    public Target chooseTarget(Monster[] monsters) {
        for(Monster m: monsters){
            if (m.isAlive){
                return m;
            }
        }
        System.out.println("Nani");
        return monsters[0];
    }

    @Override
    public Move chooseMove(){
        if(moveCounter == moves.size()){
            moveCounter = 0;
        }
        moveCounter++;
        return moves.get(moveCounter-1);
    }
}
