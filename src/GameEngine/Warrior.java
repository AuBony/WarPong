package GameEngine;

public class Warrior {

    int id;
    //int tVelocity;

    static int x = 25;
    static int y = 250;

    int hp = 10;

    public static void move(int type, int b){
        y = y - b;
    }

    /*public Warrior(double x, double y, double height, double width, int hp, int id) {

        this.id = id;
        this.hp = hp;
        super(double x, double y, double height, double width)

    }*/

}
