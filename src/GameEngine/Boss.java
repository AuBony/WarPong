package GameEngine;

import javafx.scene.image.Image;

public class Boss extends Entities{

    int hp = 100;
    int heightBoss = 70;
    int widthBoss = 60;

    public Boss(double x, double y, double heightBoss, double widthBoss){
        super(x, y, heightBoss, widthBoss);
        this.x = x - widthBoss/2;
        this.y = y - heightBoss/2;

    }
    Image headBoss = new Image("Resources/Sprites/dragon_100x79.png");

    public Image getHeadBoss() {
        return headBoss;
    }
}
