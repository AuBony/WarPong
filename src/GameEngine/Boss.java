package GameEngine;

import javafx.scene.image.Image;

public class Boss extends Entities{

    int hp = 100;

    public Boss(int Rwidth, int Rheight){
        super();
        this.x = (double) Rwidth/2 - 100;
        this.y = (double) Rheight/2 - 79;
        this.widthEntities = 200;
        this.heightEntities = 158;
    }
    Image headBoss = new Image("Resources/Sprites/dragon_100x79.png");

    public Image getHeadBoss() {
        return headBoss;
    }
}
