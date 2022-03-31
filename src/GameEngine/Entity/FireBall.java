package GameEngine.Entity;

import javafx.scene.image.Image;

public class FireBall extends Entities {
    private final Image skinFireBall;
    private String dir;

    public FireBall(Character c, double x, double y, String dir){
        super();
        this.velocity = 1;
        switch (c.getType()) {
            case "J1" -> {
                skinFireBall = new Image("Resources/Sprites/FBJ1.png");
                this.heightEntities = 28;
                this.widthEntities = 36;
                this.velocity = 5;
            }
            case "J2" -> {
                skinFireBall = new Image("Resources/Sprites/FBJ2.png");
                this.heightEntities = 28;
                this.widthEntities = 36;
                this.velocity = -5;
            }
            case "Boss" -> {
                skinFireBall = new Image("Resources/Sprites/FBBoss.png");
                this.heightEntities = 40;
                this.widthEntities = 40;
                if(dir.equals("G")){
                    this.velocity = -2;
                }else if(dir.equals("D")){
                    this.velocity = 2;
                }
            }
            default ->{
                skinFireBall = new Image("Resources/Sprites/dragon_100x79.png");
                this.heightEntities = 79;
                this.widthEntities = 100;
            }
        }
        this.y = y - this.heightEntities/2;
        this.x = x - this.widthEntities/2;
        this.dir = dir;
    }

    //Get
    public Image getSkinFireBall() {
        return skinFireBall;
    }
    public String getDir() {
        return dir;
    }
    //Set
    public void setDir(String dir) {
        this.dir = dir;
    }

    //Method
    public void move(String type, double x, double y) {
        switch (type) {
            case "J1" -> this.x += this.velocity;
            case "J2" -> this.x -= this.velocity;
            default -> System.out.println("Error : nothing move");
        }
    }

}
