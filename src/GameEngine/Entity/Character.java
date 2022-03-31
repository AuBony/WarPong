package GameEngine.Entity;

public abstract class Character extends Entities {

    //Variables
    protected String type;
    protected int hp;
    protected int velocity;

    //Get
    public int getVelocity() {
        return velocity;
    }

    public String getType() {
        return type;
    }
}
