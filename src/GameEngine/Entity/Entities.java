package GameEngine.Entity;

import GameEngine.Physic.Move;

public abstract class Entities implements Move {

    //Variables
    protected double x;
    protected double y;
    protected double heightEntities;
    protected double widthEntities;
    protected double velocity;

    //Constructor
    public Entities(double height, double width){
        this.heightEntities = height;
        this.widthEntities = width;
    }
    public Entities(){ }

    //Get
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getHeight() {
        return heightEntities;
    }
    public double getWidth() {
        return widthEntities;
    }
    public double getVelocity() {
        return velocity;
    }

    //Set
    public void setX(double x) {this.x = x;}
    public void setY(double y){this.y = y;}
    public void setHeightEntities(double heightEntities) {
        this.heightEntities = heightEntities;
    }
    public void setWidthEntities(double widthEntities) {
        this.widthEntities = widthEntities;
    }
    public void setVelocity(double velocity) {this.velocity = velocity;}
}
