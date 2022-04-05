package GameEngine.Entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Warrior extends Character {

    //Variables
    private boolean isalive;
    private final Image DeadSkin;

    //Constructor
    public Warrior(int Rwidth, int Rheight, String type){
        super();
        this.velocity = 10;
        this.hp = 10;
        this.y = (double) Rheight/2;
        this.type = type;
        this.isalive = true;
        switch (type) {
            case "J1" -> {
                this.skin = new Image("Resources/Sprites/thomasus.png");
                this.DeadSkin = new Image("Resources/Sprites/dead_thomasus.png");
                this.setHeightEntities(70);
                this.setWidthEntities(60);
                this.x = 10;
            }
            case "J2" -> {
                this.skin = new Image("Resources/Sprites/odreya.png");
                this.DeadSkin = new Image("Resources/Sprites/dead_odreya.png");
                this.setHeightEntities(70);
                this.setWidthEntities(52);
                this.x = Rwidth - 60;
            }
            default -> {
                this.skin = new Image("Resources/Sprites/dragon_100x79.png");
                this.DeadSkin = new Image("Resources/Sprites/dragon_100x79.png");
                this.setHeightEntities(79);
                this.setWidthEntities(100);
                this.x = 79;
                this.setY(100);
            }
        }
    }

    //Get
    public String getType() {
        return type;
    }
    public boolean Isalive() {return isalive;}
    public int getWarriorDamage() {
        return 5;}

    //Set
    public void setIsalive(boolean isalive) {
        this.isalive = isalive;
    }

    //Method

    /**
     * Draw Warrior objects on the GraphicsContext. If the player is dead, we display a particular skin.
     * Override drawEntity method from Entities.
     * @param gc a GraphicsContext where we want to draw the Entities.
     */
    @Override
    public void drawEntity(GraphicsContext gc) {
        if (this.isalive){
            super.drawEntity(gc);
        }else{
            gc.drawImage(this.DeadSkin, this.x, this.y, this.getHeight(), this.getWidth());
        }
    }

    /**
     * Move Warrior object. Prevent Warrior object from exiting the scene.
     * @param dir       a String object. Direction of Warrior's movement. Can take the values "UP" or "DOWN".
     * @param Rheight   int the height of the scene.
     */
    public void move(String dir, int Rheight){
        if(this.y < Rheight - this.heightEntities && dir.equals("DOWN")){
            this.y = this.y + this.velocity;
        }
        if(this.y > 0 && dir.equals("UP")){
            this.y = this.y - this.velocity;
        }
    }
}
