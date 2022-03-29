package GameEngine;

public class Entities {

    //Variables
    protected double x;
    protected double y;
    double heightEntities;
    double widthEntities;

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

    public double getWidth() {
        return widthEntities;
    }

    public double getHeight() {
        return heightEntities;
    }


    //Set
    public void setHeightEntities(double heightEntities) {
        this.heightEntities = heightEntities;
    }

    public void setWidthEntities(double widthEntities) {
        this.widthEntities = widthEntities;
    }

    public void setX(double x){this.x = x;}
    public void setY(double y){this.y = y;}

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
