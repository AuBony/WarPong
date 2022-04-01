package GameEngine.Entity;

import javafx.scene.image.Image;


public class FireBall extends Entities {
    private final Image skinFireBall;
    private final String castBy;
    private int damage;

    public FireBall(Warrior w, double x, double y, String dir){
        super();
        this.velocity = 1;
        switch (w.getType()) {
            case "J1" -> {
                skinFireBall = new Image("Resources/Sprites/FBJ1.png");
                this.heightEntities = 28;
                this.widthEntities = 36;
                this.velocity = 5;
                this.damage = 5;
            }
            case "J2" -> {
                skinFireBall = new Image("Resources/Sprites/FBJ2.png");
                this.heightEntities = 28;
                this.widthEntities = 36;
                this.velocity = -5;
                this.damage = 5;
            }
            default ->{
                skinFireBall = new Image("Resources/Sprites/dragon_100x79.png");
                this.heightEntities = 79;
                this.widthEntities = 100;
            }
        }
        this.castBy = w.getType();
        this.y = y - this.heightEntities/2;
        this.x = x - this.widthEntities/2;
    }

    public FireBall(Boss b, String dir, String attack){
        super();
        this.velocity = 1;
        switch(attack) {
            case "classic" -> {
                skinFireBall = new Image("Resources/Sprites/FBBoss.png");
                this.heightEntities = 40;
                this.widthEntities = 40;
                this.damage = 2;
                if(dir.equals("G")){
                    this.velocity = -2;
                }else if(dir.equals("D")){
                    this.velocity = 2;
                }
            }
            case "special" -> {
                skinFireBall = new Image("Resources/Sprites/FBBspe.png");
                this.heightEntities = 60;
                this.widthEntities = 60;
                this.damage = 5;
                if(dir.equals("G")){
                    this.velocity = -3;
                }else if(dir.equals("D")){
                    this.velocity = 3;
                }
            }
            default ->{
                skinFireBall = new Image("Resources/Sprites/dragon_100x79.png");
                this.heightEntities = 79;
                this.widthEntities = 100;
                this.damage = 5;
                this.velocity = 3;
            }
        }
        this.castBy = b.getType();
        this.y = b.getY() - this.heightEntities/2;
        this.x = b.getX() - this.widthEntities/2;
    }

    //Get
    public Image getSkinFireBall() {
        return skinFireBall;
    }
    public String getCastBy() {
        return castBy;
    }
    public int getDamage() {
        return damage;
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
