import GameEngine.Boss;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Render extends Application {

    @Override
    public void start(Stage stage) {

            //Create group Object
            Group root = new Group();

            //Create a scene
            final int width = 1000;
            final int height = 600;
            Scene scene = new Scene(root, width, height);
            //scene.setFill(Color.WHITE); //new RadialGradient(0, 0, 500, 300, 500, false, CycleMethod.NO_CYCLE, new Stop(0, Color.grayRgb(60)), new Stop(1, Color.GREY))


            //Create a canvas
            Canvas canvas = new Canvas(width, height);
            root.getChildren().add(canvas);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            //gc.setFill(Color.WHITE);

            //Add Boss
            Boss boss = new Boss(width/2, height/2, 100, 79);
            Image ImBoss = boss.getHeadBoss();
            gc.drawImage(ImBoss, boss.getX(), boss.getY(), boss.getWidth(), boss.getHeight());

            stage.setScene(scene); //Add scene to stage

            //Stage
            stage.setTitle("W A R  P O N G");
            stage.show();


    }

}
