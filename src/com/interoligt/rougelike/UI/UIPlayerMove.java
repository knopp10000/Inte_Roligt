package com.interoligt.rougelike.UI;

import com.interoligt.rougelike.Main.Monster;
import com.interoligt.rougelike.Main.Move;
import com.interoligt.rougelike.Main.Target;

public class UIPlayerMove {

    private static UIPlayerMove instance;

    public static UIPlayerMove getInstance()
    {
        if (instance == null)
            instance = new UIPlayerMove();

        return instance;
    }

    public Target chooseTarget(Monster[] monsters){
        return null;
    }

    public Move chooseMove(){
        return null;
    }
}
