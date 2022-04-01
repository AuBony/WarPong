package GameEngine;

import GameEngine.Entity.Boss;
import GameEngine.Entity.FireBall;
import GameEngine.Entity.Warrior;

public class GE {
    //Variables
    int Rwidth;
    int Rheight;

    private Boss boss;
    private Warrior J1;
    private Warrior J2;

    //Constructor
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

    //Method

    /**
     * Add a Boss in the game
     * @return return a boss
     */
    public Boss addBoss(){
        return (new Boss(Rwidth, Rheight));
    }

    /**
     * Add Warriors in the game
     * @param J Which player (player 1 or 2)
     * @return return a Warrior
     */
    public Warrior addWarrior(String J){
        return(new Warrior(Rwidth, Rheight, J));
    }

    /**
     * Add Fireballs launched by the warriors. Direction of the fireball launched is defined by the type of player (P1 or P2).
     * @param w Warrior
     * @param x Coord X
     * @param y Coord Y
     * @return the launcher of the fireball, the direction, the x and the y of this fireball.
     */
    public FireBall addFireBall(Warrior w, double x, double y){
        double offsetx = 0;
        double offsety = 0;
        switch(w.getType()){
            case "J1" -> {
                offsetx = w.getWidth();
                offsety = w.getHeight()/2;
            }
            case "J2" -> {
                offsetx = 0;
                offsety = w.getHeight()/2;
            }
        }
        return new FireBall(w, x + offsetx, y + offsety);
    }

    /**
     * Add Fireballs launched by the Boss. 2 types: common fireballs and special fireballs.
     * Print an Error if an invalid direction is asked.
     * @param b the Boss
     * @param dir To the left or to the right
     * @param attack Attack type: Classic or Special, used in the creation of the fireball.
     * @return a fireball launched by the boss, with its x, y direction and type.
     */
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

    /**
     * Create the Character objects. Used in the Render.
     */
    public void init(){
        J1 = addWarrior("J1");
        J2 = addWarrior("J2");
        boss = addBoss();
    }
}
