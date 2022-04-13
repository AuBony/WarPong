package Graphism;

import GameEngine.Entity.Warrior;
import javafx.geometry.VPos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FinishText {
    //Variables
    private final Text defeat;
    private final Text win;

    //Constructor
    public FinishText(int Rwidth, int Rheight) {
        //Defeat
        defeat = new Text("TRY AGAIN");
        defeat.setFont(Font.font("Consola", 70));
        defeat.setFill(Color.RED);
        defeat.setTextOrigin(VPos.CENTER);
        defeat.setLayoutX(440);
        defeat.setLayoutY((double) Rheight / 3);
        defeat.setVisible(false);
        //Win
        win = new Text("YOU WIN");
        win.setFont(Font.font("Consola", 70));
        win.setFill(Color.RED);
        win.setTextOrigin(VPos.CENTER);
        win.setLayoutX(440);
        win.setLayoutY((double) Rheight / 3);
        win.setVisible(false);

    }
    //Get
    public Text getWin() {return win;}
    public Text getDefeat() {return defeat;}

    public void displayScore(double x, double y, int a, int b){
            Text score = new Text("Score J1 = " + "a" + " et Score J2 = " + "b");
            score.setFont(Font.font("Consola", 35));
            score.setFill(Color.RED);
            score.setTextOrigin(VPos.CENTER);
            score.setLayoutX( x / 2);
            score.setLayoutY( y / 2);
            score.setVisible(true);
}}
