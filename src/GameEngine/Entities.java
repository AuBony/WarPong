package GameEngine;

public class Entities {

    //Variables
    protected static double x;
    protected static double y;
    static double heightEntities;
    static double widthEntities;

    //Constructor
    public Entities(double height, double width){
        this.heightEntities = height;
        this.widthEntities = width;
    }
    public Entities(){ }

    //Get
    public static double getX() {
        return x;
    }

    public static double getY() {
        return y;
    }

    public static double getWidth() {
        return widthEntities;
    }

    public static double getHeight() {
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
    public static void setY(double coordY){coordY = y;}

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
