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
    public void setSkin(Image skin) {this.skin = skin;}

    //Method
    /**
     * Draw Entity objects on the GraphicsContext
     * @param gc a GraphicsContext where we want to draw the Entities.
     */
    public void drawEntity(GraphicsContext gc){
        gc.drawImage(this.getSkin(),this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

    /**
     * Create the hitbox of an Entity object of the size of this Entity and at the same position.
     * @return a Rectangle2D object.
     */
    public Rectangle2D createHitbox(){
        return (new Rectangle2D(this.getX(), this.getY(), this.getWidth(), this.getHeight()));
    }
}
