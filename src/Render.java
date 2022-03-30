import GameEngine.Entity.Boss;
import GameEngine.Entity.FireBall;
import GameEngine.Entity.Warrior;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Render extends Application {

    //Variables
    static int Rwidth = 1200;
    static int Rheight = 700;

    //Method
    public void addBoss(GraphicsContext gc){
            Boss boss = new Boss(Rwidth, Rheight);
            Image ImBoss = boss.getHeadBoss();
            gc.drawImage(ImBoss, boss.getX(), boss.getY(), boss.getWidth(), boss.getHeight());
    }
    public void addWarrior(GraphicsContext gc, String J){
            Warrior warrior = new Warrior(Rwidth, Rheight, J);
            Image ImWarrior = warrior.getSkinWarrior();
            gc.drawImage(ImWarrior, warrior.getX(), warrior.getY(), warrior.getWidth(), warrior.getHeight());
    }
    public void addFireBall(GraphicsContext gc, String s, double x, double y){
        FireBall fireBall = new FireBall(s, x, y);
        Image Imfireball = fireBall.getSkinFireBall();
        gc.drawImage(Imfireball, fireBall.getX(), fireBall.getY(), fireBall.getWidth(), fireBall.getHeight());
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
            Boss boss = new Boss((Rwidth/2),(Rheight/2));
            Image ImBoss = boss.getHeadBoss();
            gc.drawImage(ImBoss, boss.getX(), boss.getY(), boss.getWidth(), boss.getHeight());
            addBoss(gc);

            //Add Warrior
            addWarrior(gc, "J1");
            addWarrior(gc, "J2");

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
