package com.interoligt.rougelike.Mocks;

import com.interoligt.rougelike.Main.Monster;
import com.interoligt.rougelike.Main.Move;
import com.interoligt.rougelike.Main.Target;
import com.interoligt.rougelike.UI.UIPlayerMove;

public class UIPlayerMoveMock extends UIPlayerMove {



    public UIPlayerMoveMock(){
    }

    @Override
    public Target chooseTarget(Monster[] monsters) {
        return monsters[0];
    }

    @Override
    public Move chooseMove(){
        return Move.ATTACK;
    }
}
