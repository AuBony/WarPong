package GameEngine;

import javafx.scene.image.Image;

import java.util.Objects;

public class FireBall extends Entities{
    Image skinFireBall;

    public FireBall(String s){
        switch (s) {
            case "J1" -> skinFireBall = new Image("Resources/Sprites/FBJ1.png");
            case "J2" -> skinFireBall = new Image("Resources/Sprites/FBJ2.png");
            case "Boss" -> skinFireBall = new Image("Resources/Sprites/FBBoss.png");
            default -> skinFireBall = new Image("Resources/Sprites/dragon_100x79.png");
        }
    }


}
