package GameEngine.Entity;

import GameEngine.Entity.Entities;
import javafx.scene.image.Image;

public class Warrior extends Character {

    //Variables
    private final Image skinWarrior;

    //Constructor
    public Warrior(int Rwidth, int Rheight, String type){
        super();
        this.velocity = 10;
        this.hp = 10;
        this.y = (double) Rheight/2;
        this.type = type;
        switch (type) {
            case "J1" -> {
                skinWarrior = new Image("Resources/Sprites/thomasus.png");
                this.setHeightEntities(70);
                this.setWidthEntities(60);
                this.x = 10;
            }
            case "J2" -> {
                skinWarrior = new Image("Resources/Sprites/odreya.png");
                this.setHeightEntities(70);
                this.setWidthEntities(52);
                this.x = Rwidth - 60;
            }
            default -> {
                skinWarrior = new Image("Resources/Sprites/dragon_100x79.png");
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
    public Image getSkinWarrior() {
        return this.skinWarrior;
    }

    //Method
    @Override
    public void move(String type, double x, double y) {

    }
}
