import GameEngine.Entity.Boss;
import GameEngine.Entity.Character;
import GameEngine.Entity.FireBall;
import GameEngine.Entity.Warrior;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Render extends Application {

    //Variables
    static int Rwidth = 1200;
    static int Rheight = 700;

    //Method
    public Boss addBoss(GraphicsContext gc){
            Boss boss = new Boss(Rwidth, Rheight);
            Image ImBoss = boss.getHeadBoss();
            gc.drawImage(ImBoss, boss.getX(), boss.getY(), boss.getWidth(), boss.getHeight());
            return (boss);
    }
    public Warrior addWarrior(GraphicsContext gc, String J){
            Warrior warrior = new Warrior(Rwidth, Rheight, J);
            Image ImWarrior = warrior.getSkinWarrior();
            gc.drawImage(ImWarrior, warrior.getX(), warrior.getY(), warrior.getWidth(), warrior.getHeight());
            return(warrior);
    }
    public void addFireBall(GraphicsContext gc, Character c, double x, double y){
        FireBall fireBall = new FireBall(c.getType(), x, y);
        Image Imfireball = fireBall.getSkinFireBall();
        double offsetx = 0;
        double offsety = 0;
        switch(c.getType()){
            case "J1" -> {
                offsetx = c.getWidth();
                offsety = c.getHeight()/2;
            }
            case "J2" -> {
                offsetx = 0;
                offsety = c.getHeight()/2;
            }
            case "Boss" -> {
                offsetx = c.getWidth()/2;
                offsety = c.getHeight() - 10; // Fireball sort au niveau de la bouche du dragon
            }
            default ->{}
        }

        gc.drawImage(Imfireball,
                fireBall.getX() + offsetx, fireBall.getY() + offsety,
                fireBall.getWidth(), fireBall.getHeight());
    }

    @Override
    public void start(Stage stage) {

            //Create group Object
            Group root = new Group();

            //Create a scene
            Scene scene = new Scene(root, Rwidth, Rheight);
            stage.setScene(scene); //Add scene to stage


            //Create a canvas
            Canvas canvas = new Canvas(Rwidth, Rheight);
            root.getChildren().add(canvas);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setFill(Color.BLACK);

            //Add fond
            Image fond = new Image ("Resources/Sprites/Fond.png");
            gc.drawImage(fond, 50, 50, Rwidth-100, Rheight-100);


            //gc.setFill(Color.WHITE);

            //Add Boss
/*            Boss bossfake = new Boss((Rwidth/2),(Rheight/2));
            Image ImBoss = boss.getHeadBoss();
            gc.drawImage(ImBoss, boss.getX(), boss.getY(), boss.getWidth(), boss.getHeight());*/
            Boss boss = addBoss(gc);

            //Add Warrior
            Warrior J1 = addWarrior(gc, "J1");
            Warrior J2 = addWarrior(gc, "J2");

            //Add FireBall
            addFireBall(gc, J1, J1.getX(), J1.getY());
            addFireBall(gc, J2, J2.getX(), J2.getY());
            addFireBall(gc, boss, boss.getX(), boss.getY());

            //Timeloop
/*            final long startNanoTime = System.nanoTime();
            new AnimationTimer()
            {
                    public void handle(long currentNanoTime)
                    {
                            double t = (currentNanoTime -
                                    startNanoTime) / 1000000000.0;
                            double x = 232 + 128 * Math.cos(t);
                            double y = 232 + 128 * Math.sin(t);
                            gc.drawImage( space, 0, 0 );
                            gc.drawImage( earth, x, y );
                            gc.drawImage( sun, 196, 196 );
                    }
            }.start();
            /*
 */

            //Stage
            stage.setTitle("W A R  P O N G");
            stage.show();


    }

}
