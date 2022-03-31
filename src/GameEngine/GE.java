package GameEngine;

import GameEngine.Entity.Boss;
import GameEngine.Entity.Character;
import GameEngine.Entity.FireBall;
import GameEngine.Entity.Warrior;

public class GE {
    int Rwidth;
    int Rheight;

    private Boss boss;
    private Warrior J1;
    private Warrior J2;

    public GE(int rwidth, int rheight) {
        Rwidth = rwidth;
        Rheight = rheight;
    }
    //Get
    public Boss getBoss() {
        return boss;
    }

    public Warrior getJ1() {
        return J1;
    }

    public Warrior getJ2() {
        return J2;
    }

    //addEntities
    public Boss addBoss(){
        return (new Boss(Rwidth, Rheight));
    }
    public Warrior addWarrior(String J){
        return(new Warrior(Rwidth, Rheight, J));
    }
    public FireBall addFireBall(Character c, double x, double y){
        double offsetx = 0;
        double offsety = 0;
        String dir = "D";
        switch(c.getType()){
            case "J1" -> {
                offsetx = c.getWidth();
                offsety = c.getHeight()/2;
                dir = "D";
            }
            case "J2" -> {
                offsetx = 0;
                offsety = c.getHeight()/2;
                dir = "G";
            }
        }
        return new FireBall(c, x + offsetx, y + offsety, dir);
    }

    public FireBall addFireBallBoss(Character c, double x, double y, String dir){
        String newdir;
        if (dir.equals("G") | dir.equals("D")){
            newdir = dir;

        }else{
            System.out.println("ERROR : WRONG DIRECTION TO CAST A FIREBALL (set by default Right)");
            newdir = "D";
        }
        return new FireBall(c, x + c.getWidth()/2, y + c.getHeight() - 10, newdir);
    }


    //Initialisation
    public void init(){
        J1 = addWarrior("J1");
        J2 = addWarrior("J2");
        boss = addBoss();
        addFireBall(J1, J1.getX(), J1.getY());
        addFireBall(J2, J2.getX(), J2.getY());
        addFireBall(boss, boss.getX(), boss.getY());
    }

    //Tick
    public void tick(){

    }

}
