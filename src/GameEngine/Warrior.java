package GameEngine;

import javafx.scene.image.Image;

public class Warrior extends Entities{

    //Variables
    int hp = 10;
    int velocity = 10;
    String type;
    Image skinWarrior;

    //Constructor
    public Warrior(double x, double y, double height, double width, String type){
        super(x, y, height, width);
        if(type.equals("joueur 1")){
            skinWarrior = new Image("Resources/Sprites/dragon_100x79.png");
            this.setHeightEntities(158);
            this.setWidthEntities(135);
        }
        else if(type.equals("joueur 2")){
            skinWarrior = new Image("Resources/Sprites/Audreya.png");
            this.setHeightEntities(169);
            this.setWidthEntities(125);
        }else{
            skinWarrior = new Image("Resources/Sprites/dragon_100x79.png");
            this.setHeightEntities(100);
            this.setWidthEntities(79);
        }
    }

    //Method
    public Image getSkinWarrior() {
        return this.skinWarrior;
    }

    //Test
    public static void main(String[] args) {
        Warrior J1 = new Warrior(10,10,45,55,"joueur 1");

    }

}
