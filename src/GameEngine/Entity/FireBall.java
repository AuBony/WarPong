package GameEngine.Entity;
import javafx.scene.image.Image;
public class FireBall extends Entities {
    //Variables
    private final String castBy;
    private int damage;

    //Constructor
    public FireBall(Warrior w, double x, double y){
        super();
        this.velocity = 1;
        switch (w.getType()) {
            case "J1" -> {
                skin = new Image("Resources/Sprites/FBJ1.png");
                this.heightEntities = 28;
                this.widthEntities = 36;
                this.velocity = 14;
                this.damage = w.getWarriorDamage();
            }
            case "J2" -> {
                skin = new Image("Resources/Sprites/FBJ2.png");
                this.heightEntities = 28;
                this.widthEntities = 36;
                this.velocity = -14;
                this.damage = w.getWarriorDamage();
            }
            default ->{
                skin = new Image("Resources/Sprites/dragon_100x79.png");
                this.heightEntities = 79;
                this.widthEntities = 100;
            }
        }
        this.castBy = w.getType();
        this.y = y - this.heightEntities/2;
        this.x = x - this.widthEntities/2;
    }

    public FireBall(Boss b, double x, double y, String dir, String attack){
        super();
        this.velocity = 1;
        switch(attack) {
            case "classic" -> {
                skin = new Image("Resources/Sprites/FBBoss.png");
                this.heightEntities = 40;
                this.widthEntities = 40;
                this.damage = 4;
                if(dir.equals("G")){
                    this.velocity = -2;
                }else if(dir.equals("D")){
                    this.velocity = 2;
                }
            }
            case "special" -> {
                skin = new Image("Resources/Sprites/FBBspe.png");
                this.heightEntities = 80;
                this.widthEntities = 80;
                this.damage = 5;
                if(dir.equals("G")){
                    this.velocity = -10;
                }else if(dir.equals("D")){
                    this.velocity = 10;
                }
            }
            default ->{
                skin = new Image("Resources/Sprites/dragon_100x79.png");
                this.heightEntities = 79;
                this.widthEntities = 100;
                this.damage = 5;
                this.velocity = 4;
            }
        }
        this.castBy = b.getType();
        this.y = y - this.heightEntities/2;
        this.x = x - this.widthEntities/2;
    }

    //Get
    public String getCastBy() {
        return castBy;
    }
    public int getDamage() {
        return damage;
    }
}
