import GameEngine.Boss;
import GameEngine.Warrior;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import static GameEngine.Entities.getY;

public class Render extends Application {

    //Variables
    static int Rwidth = 1200;
    static int Rheight = 700;
    int velocity = 5;
    double  oldJ1Y = (double) Rheight/2;
    double oldJ2Y = (double) Rheight/2;

    public static ArrayList<KeyCode> inputString = new ArrayList<>();

    //Method
    public Boss addBoss() {
        Boss boss = new Boss(Rwidth, Rheight);
        return boss;
    }

    public Warrior addWarrior(String J) {
        Warrior warrior = new Warrior(Rwidth, Rheight, J);
        return warrior;
    }

    @Override
    public void start(Stage stage) {

        //Create group Object
        Group root = new Group();

        //Create a scene
        Scene scene = new Scene(root, Rwidth, Rheight);

        //Add Warrior
        Warrior J1 = addWarrior("J1");
        Warrior J2 = addWarrior("J2");
        //Add Boss
        Boss boss = addBoss();

        scene.setOnKeyPressed(e -> {
                    KeyCode code = e.getCode();
                    if (!inputString.contains(code))
                        inputString.add(code);
                }
        );

        scene.setOnKeyReleased(e -> {
            KeyCode code = e.getCode();
            inputString.remove(code);
        });

        stage.setScene(scene); //Add scene to stage
        stage.setTitle("W A R  P O N G");

        Image fond = new Image("Resources/Sprites/fond.png");
        Image j1 = new Image("Resources/Sprites/thomasus.png");
        Image j2 = new Image("Resources/Sprites/odreya.png");
        Image ImBoss = boss.getHeadBoss();
        int xJ1 = 55;
        int xJ2 = Rwidth - 100;
        int heighJ1 = 50;
        int widhtJ1 = 43;
        int heighJ2 = 50;
        int widhtJ2 = 37;

        Canvas canvas = new Canvas(Rwidth, Rheight);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);


        Timeline loop = new Timeline(new KeyFrame(Duration.millis(100), arg -> {
                if (inputString.contains(KeyCode.S)) {
                    oldJ1Y = (oldJ1Y + velocity);
                }
                if (inputString.contains(KeyCode.Z)) {
                    oldJ1Y = (oldJ1Y - velocity);
                }
                if (inputString.contains(KeyCode.DOWN)) {
                    oldJ2Y = (oldJ2Y + velocity);
            }
                if (inputString.contains(KeyCode.UP)) {
                    oldJ2Y = (oldJ2Y - velocity);
            }

                gc.drawImage(fond, 0, 0, Rwidth, Rheight);
                gc.drawImage(ImBoss, boss.getX(), getY(), boss.getWidth(), boss.getHeight());
                gc.drawImage(j1, xJ1, oldJ1Y, widhtJ1, heighJ1);
                gc.drawImage(j2, xJ2, oldJ2Y, widhtJ2, heighJ2);
                }));
            loop.setCycleCount(Timeline.INDEFINITE);
            loop.play();

                stage.show();
            }
        }