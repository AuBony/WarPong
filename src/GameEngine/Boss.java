package GameEngine;

import javafx.scene.image.Image;

public class Boss extends Entities{

    int hp = 100;

    public Boss(double x, double y, double height, double width){
        super(x, y, height, width);
    }
    Image headBoss = new Image("Resources/Sprites/dragon_100x79.png");

    public Image getHeadBoss() {
        return headBoss;
    }
}
