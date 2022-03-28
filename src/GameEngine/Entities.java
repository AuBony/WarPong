package GameEngine;

public class Entities {

    double x;
    double y;
    double heightEntities;
    double widthEntities;

    public Entities(double x, double y, double height, double width){
        this.x = x;
        this.y = y;
        this.heightEntities = height;
        this.widthEntities = width;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return widthEntities;
    }

    public double getHeight() {
        return heightEntities;
    }

/*    public double getHeigh() {
        return heightEntities;
    }



    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }*/
}
