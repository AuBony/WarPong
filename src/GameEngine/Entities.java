package GameEngine;

public class Entities {

    double x;
    double y;
    double heighEntities;
    double widthEntities;
    int hp;

    public void entities(double x, double y, double heigh, double width, int hp){
        this.x = x;
        this.y = y;
        this.heighEntities = heigh;
        this.widthEntities = width;
        this.hp = hp;
    }

    public double getHeigh() {
        return heighEntities;
    }

    public double getWidth() {
        return widthEntities;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getHp() {
        return hp;
    }
}
