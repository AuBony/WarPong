package GameEngine.Entity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;


public abstract class Character extends Entities {

    //Variables
    protected String type;
    protected int hp;
    protected Image DeadSkin;
    protected Image IdleSkin;
    protected int maxLife;

    //Get
    public String getType() {return type;}
    public int getHp() {return hp;}
    public int getMaxLife() {return maxLife;}

    //Set
    public void setHp(int hp) {
        this.hp = hp;
    }

    //Method
    public void drawLifeBar(GraphicsContext gc){
        int ratio;
        if (Objects.equals(this.type, "Boss")){
            ratio = 20;
        }else{ratio = 10;}
        Image BackBar = new Image("Resources/Sprites/empty_bar.png");
        gc.drawImage(BackBar, this.getX(), this.getY() + this.heightEntities, this.widthEntities, this.widthEntities/ratio);

        if (this.hp >= 0){
            Image lifeBar = new Image("Resources/Sprites/full_bar.png");
            gc.drawImage(lifeBar, this.getX(), this.getY() + this.heightEntities, this.hp * this.widthEntities / this.maxLife, this.widthEntities/ratio);
        }
    }
}
