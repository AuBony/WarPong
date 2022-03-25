package GameEngine;

import javafx.scene.image.Image;

public class Boss {

    double x;
    double y;
    int hp;
    Image[] headBoss = {new Image("Resources/Sprites/dragon_100x79.png")};

    public Boss(double x, double y, int hp){
        this.x = x;
        this.y = y;
        this.hp = hp;
    }
}
