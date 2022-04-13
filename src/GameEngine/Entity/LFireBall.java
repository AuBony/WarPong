package GameEngine.Entity;
import javafx.geometry.Rectangle2D;

import java.util.ArrayList;
import java.util.List;

public class LFireBall extends Entities{
    //Variables
    private final List<FireBall> lfb = new ArrayList<>();

    //Constructor
    public LFireBall(){}

    //Get
    public List<FireBall> getLfb() {
        return lfb;
    }
    public int getScore(Warrior w) {
            return w.getScoreW();
    }


    //Method
    /**
     * Move all the fireballs.
     * Check collision with Boss or Warrior, withdraw health points from Boss or Warriors.
     * Delete fireballs if they were out of bound or if they collided with a Character.
     * @param J1        an object of the Warrior Class. The Warrior on the left of the scene.
     * @param J2        an object of the Warrior Class. The Warrior on the right of the scene.
     * @param b         an object of the Boss Class.
     * @param Rwidth    an integer. The width of the scene.
     * @param hitboxBoss    a Rectangle2D. A rectangle that represents the boss' hitbox.
     * @param hitboxJ1      a Rectangle2D. A rectangle that represents the hitbox of the right Warrior (J1).
     * @param hitboxJ2      a Rectangle2D. A rectangle that represents the hitbox of the left Warrior (J2).
     */
    public void moveAllFireBall(Warrior J1, Warrior J2, Boss b,
                                int Rwidth,
                                Rectangle2D hitboxBoss, Rectangle2D hitboxJ1, Rectangle2D hitboxJ2){
        for (FireBall f : this.lfb){
            f.setX(f.getX() + f.getVelocity());
            if (f.getX() < 0 | f.getX() > Rwidth){
                this.lfb.remove(f);
                break;
            }
            Rectangle2D hitboxf = f.createHitbox();

            if(f.getCastBy().equals("Boss")){
                if (hitboxf.intersects(hitboxJ1)){
                    J1.setHp(J1.getHp() - f.getDamage());
                    this.lfb.remove(f);
                    break;
                }
                if (hitboxf.intersects(hitboxJ2)){
                    J2.setHp(J2.getHp() - f.getDamage());
                    this.lfb.remove(f);
                    break;
                }
            }else if (f.getCastBy().equals("J1") | f.getCastBy().equals("J2")){
                if (hitboxf.intersects(hitboxBoss)){
                    if (f.getCastBy().equals("J1")){J1.setScoreW(J1.getScoreW() + f.getDamage());}
                    if (f.getCastBy().equals("J2")){J2.setScoreW(J2.getScoreW() + f.getDamage());}
                    System.out.println(getScore(J1));
                    System.out.println(getScore(J2));
                    b.setHp(b.getHp() - f.getDamage());
                    this.lfb.remove(f);
                    break;
                }
            }

        }
    }

    }
