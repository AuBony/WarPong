package GameEngine;

import javafx.scene.image.Image;

public class Warrior extends Entities{

    //Variables
    int hp = 10;
    int velocity = 10;
    String type;
    Image skinWarrior;

    //Constructor
    public Warrior(int Rwidth, int Rheight, String type){
        super();
        this.y = (double) Rheight/2;
        if(type.equals("J1")){
            skinWarrior = new Image("Resources/Sprites/thomasus.png");
            this.setHeightEntities(50);
            this.setWidthEntities(43);
            this.x = 5;
        }
        else if(type.equals("J2")){
            skinWarrior = new Image("Resources/Sprites/odreya.png");
            this.setHeightEntities(50);
            this.setWidthEntities(37);
            this.x = Rwidth - 55;
        }else{
            skinWarrior = new Image("Resources/Sprites/dragon_100x79.png");
            this.setHeightEntities(79);
            this.setWidthEntities(100);
            this.x = 79;
            this.setY(100);
        }
    }

    //Get
    public String getType() {
        return type;
    }

    //Method
    public Image getSkinWarrior() {
        return this.skinWarrior;
    }

    //Test
    public static void main(String[] args) {
       // Warrior J1 = new Warrior(10,10,45,55,"joueur 1");

    }

}
