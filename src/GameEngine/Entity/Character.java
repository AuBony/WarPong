package GameEngine.Entity;

public abstract class Character extends Entities {

    //Variables
    protected String type;
    protected int hp;

    //Get
    public String getType() {return type;}
    public int getHp() {return hp;}

    //Set
    public void setHp(int hp) {
        this.hp = hp;
    }
}
