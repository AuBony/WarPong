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
    public FireBall addFireBall(Warrior w, double x, double y){
        double offsetx = 0;
        double offsety = 0;
        String dir = "D";
        switch(w.getType()){
            case "J1" -> {
                offsetx = w.getWidth();
                offsety = w.getHeight()/2;
                dir = "D";
            }
            case "J2" -> {
                offsetx = 0;
                offsety = w.getHeight()/2;
                dir = "G";
            }
        }
        return new FireBall(w, x + offsetx, y + offsety, dir);
    }
    public FireBall addFireBallBoss(Boss b, String dir, String attack){
        String newdir;
        double offsetx = b.getWidth()/2;
        double offsety = b.getHeight() - 10; // Fireball sort au niveau de la bouche du dragon
        if (dir.equals("G") | dir.equals("D")){
            newdir = dir;
        }else{
            System.out.println("ERROR : WRONG DIRECTION TO CAST A FIREBALL (set by default Right)");
            newdir = "D";
        }
        return new FireBall(b, b.getX() + offsetx, b.getY() + offsety, newdir, attack);
    }


    //Initialisation
    public void init(){
        J1 = addWarrior("J1");
        J2 = addWarrior("J2");
        boss = addBoss();
    }

    //Tick
    public void tick(){

    }

}
