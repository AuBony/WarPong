package GameEngine.Entity;

import javafx.scene.image.Image;

public class Boss extends Character {

    public Boss(int Rwidth, int Rheight){
        super();
        this.hp = 100;
        this.velocity = 1;
        this.x = (double) Rwidth/2 - 100;
        this.y = (double) Rheight/2 - 79;
        this.widthEntities = 200;
        this.heightEntities = 158;
    }
    Image headBoss = new Image("Resources/Sprites/dragon_100x79.png");

    public Image getHeadBoss() {
        return headBoss;
    }


    @Override
    public void move(String type, double x, double y) {

    }
}
