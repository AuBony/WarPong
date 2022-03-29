package GameEngine;

import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import java.awt.*;

public class Player  {

    int id;
    int tVelocity;

    int xPlayer1 = 25;
    int yPlayer1 = 250;

    int xPlayer2 = 975;
    int yPlayer2 = 250;

    int hpPlayer1 = 10;
    int hpPlayer2 = 10;


/*    final int widthPlayers = (int) widthEntities;
    final int heighPlayers = (int) heightEntities;
    Dimension hitboxPlayers = new Dimension(widthPlayers,heighPlayers);*/



    /*@Override
    public void Entities(double x, double y, double height, double width, int hp) {
        super.Entities(x, y, height, width, hp);
    }
    Entities player1 = new Entities();
    Entities player2 = new Entities();*/

    public void keyPressed(KeyEvent e){

    }

    public void keyReleased(KeyEvent e){

    }

    public void setYDirection(int yDirection){

    }

    public void draw(Graphics g){

    }
}
