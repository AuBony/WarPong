import GameEngine.Boss;
import GameEngine.Warrior;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
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

            //Add Boss
            addBoss(gc);

            //Add Warrior
            addWarrior(gc, "J1");
            addWarrior(gc, "J2");

            //Stage
            stage.setTitle("W A R  P O N G");
            stage.show();


    }

}
