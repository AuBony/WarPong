package GameEngine.Entity;

import javafx.scene.image.Image;

public class Boss extends Character {

    //Variables
    private boolean monte = true;

    //Constructor
    public Boss(int Rwidth, int Rheight){
        super();
        this.hp = 200;
        this.velocity = 5;
        this.type = "Boss";
        this.x = (double) Rwidth/2 - 100;
        this.y = (double) Rheight/2 - 79;
        this.widthEntities = 200;
        this.heightEntities = 158;
        this.skin = new Image("Resources/Sprites/dragon_100x79.png");
    }

    //Get
    public boolean getMonte() {
        return this.monte;
    }

    //Set
    public void setMonte(boolean monte) {
        this.monte = monte;
    }

    //Method
    /**
     * Move Boss object up and down on a predefined path. Boss covers 4/5 of the scene.
     * @param Rheight int the height of the scene.
     */
    public void move(int Rheight){
        if(this.getY()< (double) Rheight / 2 - (this.getHeight() / 2 + (double) 3*Rheight/10)){
            this.setMonte(false);
        }
        if(this.getY() > (double) 4*Rheight/5 - this.getHeight() / 2){
            this.setMonte(true);
        }
        if (this.getMonte()){
            this.setY(this.getY() - this.getVelocity());
        }else{
            this.setY(this.getY() + this.getVelocity());
        }
    }


}
