package GameEngine.Entity;

import GameEngine.Entity.Entities;
import javafx.scene.image.Image;

public class Warrior extends Character {

    //Variables
    Image skinWarrior;

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
                this.setHeightEntities(50);
                this.setWidthEntities(43);
                this.x = 5;
            }
            case "J2" -> {
                skinWarrior = new Image("Resources/Sprites/odreya.png");
                this.setHeightEntities(50);
                this.setWidthEntities(37);
                this.x = Rwidth - 55;
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

    //Test
    public static void main(String[] args) {
       // Warrior J1 = new Warrior(10,10,45,55,"joueur 1");
    }

    @Override
    public void move(String type, double x, double y) {

    }
}
