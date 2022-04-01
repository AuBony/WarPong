package Graphism;

import javafx.geometry.VPos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FinishText {
    private final Text defeat;
    private final Text win;

    public FinishText(int Rwidth, int Rheight) {
        //Defeat
        defeat = new Text("TRY AGAIN !");
        defeat.setFont(Font.font("Consola", 70));
        defeat.setFill(Color.RED);
        defeat.setTextOrigin(VPos.CENTER);
        defeat.setLayoutX((double) Rwidth/3);
        defeat.setLayoutY((double) Rheight/3);
        defeat.setVisible(false);
        //Win
        win = new Text("YOU WIN !");
        win.setFont(Font.font("Consola", 70));
        win.setFill(Color.RED);
        win.setTextOrigin(VPos.CENTER);
        win.setLayoutX((double) Rwidth/3);
        win.setLayoutY((double) Rheight/3);
        win.setVisible(false);
    }

    //Get
    public Text getWin() {return win;}
    public Text getDefeat() {return defeat;}
}
