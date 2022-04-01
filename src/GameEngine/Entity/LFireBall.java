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

    //Method
    /**
     *
     * @param J1
     * @param J2
     * @param b
     * @param Rwidth
     * @param hitboxBoss
     * @param hitboxJ1
     * @param hitboxJ2
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
                    b.setHp(b.getHp() - f.getDamage());
                    this.lfb.remove(f);
                    break;
                }
            }
        }
    }
}
