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

    public static void move(int type, int b){
        y = y - b;
    }

    /*public Warrior(double x, double y, double height, double width, int hp, int id) {
    //Get
    public String getType() {
        return type;
    }

    //Method
    public Image getSkinWarrior() {
        return this.skinWarrior;
    }

}
