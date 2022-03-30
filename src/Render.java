import GameEngine.Entity.Boss;
import GameEngine.Entity.Character;
import GameEngine.Entity.FireBall;
import GameEngine.Entity.Warrior;
import GameEngine.GE;
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
    int Rwidth = 1200;
    int Rheight = 700;
    GE ge;



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
            ge = new GE(Rwidth,Rheight,gc);

            // Add entities
        ge.init();


        stage.setTitle("W A R  P O N G");
        stage.show();


            //gc.setFill(Color.WHITE);

            //Add Boss
/*            Boss bossfake = new Boss((Rwidth/2),(Rheight/2));
            Image ImBoss = boss.getHeadBoss();
            gc.drawImage(ImBoss, boss.getX(), boss.getY(), boss.getWidth(), boss.getHeight());*/


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
                            ge.tick()
 */
                    }
            //}.start();
            /*
 */

            //Stage
    }
