package GameEngine.Entity;

import javafx.scene.image.Image;

public abstract class Character extends Entities {

    //Variables
    protected String type;
    protected int hp;
    protected Image DeadSkin;
    protected Image IdleSkin;

    //Get
    public String getType() {return type;}
    public int getHp() {return hp;}

    //Set
    public void setHp(int hp) {
        this.hp = hp;
    }
}
