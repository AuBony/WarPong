package GameEngine.Entity;

import javafx.scene.image.Image;

public class Boss extends Character {

    private boolean monte = true;
    private final Image headBoss;

    public Boss(int Rwidth, int Rheight){
        super();
        this.hp = 200;
        this.velocity = 5;
        this.type = "Boss";
        this.x = (double) Rwidth/2 - 100;
        this.y = (double) Rheight/2 - 79;
        this.widthEntities = 200;
        this.heightEntities = 158;
        this.headBoss = new Image("Resources/Sprites/dragon_100x79.png");
    }

    //Get
    public Image getHeadBoss() {
        return headBoss;
    }

    public boolean getMonte() {
        return this.monte;
    }
    //Set
    public void setMonte(boolean monte) {
        this.monte = monte;
    }

    @Override
    public void move(String type, double x, double y) {

    }
}
