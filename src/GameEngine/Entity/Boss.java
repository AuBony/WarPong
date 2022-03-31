package GameEngine.Entity;

import javafx.scene.image.Image;

public class Boss extends Character {

    private boolean monte = true;

    public Boss(int Rwidth, int Rheight){
        super();
        this.hp = 100;
        this.velocity = 5;
        this.type = "Boss";
        this.x = (double) Rwidth/2 - 100;
        this.y = (double) Rheight/2 - 79;
        this.widthEntities = 200;
        this.heightEntities = 158;
    }
    Image headBoss = new Image("Resources/Sprites/dragon_100x79.png");

    //Get
    public Image getHeadBoss() {
        return headBoss;
    }

    public boolean getMonte() {
        return monte;
    }
    //Set
    public void setMonte(boolean monte) {
        this.monte = monte;
    }

    @Override
    public void move(String type, double x, double y) {

    }
}
