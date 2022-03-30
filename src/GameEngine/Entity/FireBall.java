package GameEngine.Entity;

import javafx.scene.image.Image;

public class FireBall extends Entities {
    Image skinFireBall;
    String dir;


    public FireBall(String s, double x, double y){
        super();
        this.x = x;
        this.y = y;
        switch (s) {
            case "J1" -> {
                skinFireBall = new Image("Resources/Sprites/FBJ1.png");
                this.heightEntities = 14;
                this.widthEntities = 18;

            }
            case "J2" -> {
                skinFireBall = new Image("Resources/Sprites/FBJ2.png");
                this.heightEntities = 14;
                this.widthEntities = 18;
            }
            case "Boss" -> {
                skinFireBall = new Image("Resources/Sprites/FBBoss.png");
                this.heightEntities = 26;
                this.widthEntities = 26;
            }
            default ->{
                skinFireBall = new Image("Resources/Sprites/dragon_100x79.png");
                this.heightEntities = 79;
                this.widthEntities = 100;
            }
        }
    }

    //Get
    public Image getSkinFireBall() {
        return skinFireBall;
    }


    //Method
    public void move(String type, double x, double y) {
        switch (type) {
            case "J1" -> this.x += 10;
            case "J2" -> this.x -= 10;
            default -> System.out.println("Error : nothing move");
        }
    }

}
