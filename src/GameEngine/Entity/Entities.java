package GameEngine.Entity;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public abstract class Entities {

    //Variables
    protected double x;
    protected double y;
    protected double heightEntities;
    protected double widthEntities;
    protected double velocity;
    protected Image skin;

    //Constructor
    public Entities(double height, double width){
        this.heightEntities = height;
        this.widthEntities = width;
    }
    public Entities(){}

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
    public Image getSkin(){return skin;}

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

    //Method
    public void drawEntity(GraphicsContext gc){
        gc.drawImage(this.getSkin(),this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
    public Rectangle2D createHitbox(){
        return (new Rectangle2D(this.getX(), this.getY(), this.getWidth(), this.getHeight()));
    }
}
