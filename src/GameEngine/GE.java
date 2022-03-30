package GameEngine;

import GameEngine.Entity.Boss;
import GameEngine.Entity.Character;
import GameEngine.Entity.FireBall;
import GameEngine.Entity.Warrior;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GE {
    int Rwidth;
    int Rheight;
    GraphicsContext gc;

    public GE(int rwidth, int rheight, GraphicsContext gc) {
        Rwidth = rwidth;
        Rheight = rheight;
        this.gc = gc;
    }

    //addEntities
    public Boss addBoss(GraphicsContext gc){
        Boss boss = new Boss(Rwidth, Rheight);
        Image ImBoss = boss.getHeadBoss();
        gc.drawImage(ImBoss, boss.getX(), boss.getY(), boss.getWidth(), boss.getHeight());//TODO à mettre dans le render
        return (boss);
    }
    public Warrior addWarrior(GraphicsContext gc, String J){
        Warrior warrior = new Warrior(Rwidth, Rheight, J);
        Image ImWarrior = warrior.getSkinWarrior();
        gc.drawImage(ImWarrior, warrior.getX(), warrior.getY(), warrior.getWidth(), warrior.getHeight());//TODO à mettre dans le render
        return(warrior);
    }
    public void addFireBall(GraphicsContext gc, Character c, double x, double y){
        FireBall fireBall = new FireBall(c.getType(), x, y);
        Image Imfireball = fireBall.getSkinFireBall();
        double offsetx = 0;
        double offsety = 0;
        switch(c.getType()){
            case "J1" -> {
                offsetx = c.getWidth();
                offsety = c.getHeight()/2;
            }
            case "J2" -> {
                offsetx = 0;
                offsety = c.getHeight()/2;
            }
            case "Boss" -> {
                offsetx = c.getWidth()/2;
                offsety = c.getHeight() - 10; // Fireball sort au niveau de la bouche du dragon
            }
            default ->{}
        }

        gc.drawImage(Imfireball,
                fireBall.getX() + offsetx, fireBall.getY() + offsety,
                fireBall.getWidth(), fireBall.getHeight());//TODO à mettre dans le render
    }

    //Initialisation
    public void init(){
        Warrior J1 = addWarrior(gc, "J1");
        Warrior J2 = addWarrior(gc, "J2");
        Boss boss = addBoss(gc);
        addFireBall(gc, J1, J1.getX(), J1.getY());
        addFireBall(gc, J2, J2.getX(), J2.getY());
        addFireBall(gc, boss, boss.getX(), boss.getY());
    }

    //Tick
    public void tick(){

    }

}
