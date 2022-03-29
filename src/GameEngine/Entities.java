package GameEngine;

public class Entities {

    //Variables
    double x;
    double y;
    double heightEntities;
    double widthEntities;

    //Constructor
    public Entities(double x, double y, double height, double width){
        this.x = x;
        this.y = y;
        this.heightEntities = height;
        this.widthEntities = width;
    }

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
