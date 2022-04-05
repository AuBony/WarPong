package GameEngine;

import GameEngine.Entity.Warrior;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class Controls {
    public static ArrayList<KeyCode> inputString = new ArrayList<>();

    public static void input(KeyCode code){
        if (!inputString.contains(code)) inputString.add(code);
    }
    public static void output(KeyCode code){
        inputString.remove(code);
    }

    public static void moveWarrior(Warrior w, int Rheight){

        //J1
        if(w.getType().equals("J1") && w.Isalive()){
            if (inputString.contains(KeyCode.S)){
                w.move("DOWN", Rheight);
            }
            if (inputString.contains(KeyCode.Z)){
                w.move("UP", Rheight);
            }
        }
        //J2
        if(w.getType().equals("J2") && w.Isalive()){
            if (inputString.contains(KeyCode.DOWN)){
                w.move("DOWN", Rheight);
            }
            if (inputString.contains(KeyCode.UP)){
                w.move("UP", Rheight);
            }
        }
    }
}
