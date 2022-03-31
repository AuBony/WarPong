import GameEngine.Entity.Boss;
import GameEngine.Entity.Warrior;
import GameEngine.GE;
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

public class Render extends Application {

    //Variables
    int Rwidth = 1200;
    int Rheight = 700;
    GE ge;
    public static ArrayList<KeyCode> inputString = new ArrayList<>();
    Image fond = new Image("Resources/Sprites/fond.png");

    //Method
    @Override
    public void start(Stage stage) {
        //Create Graphic
        Group root = new Group();
        stage.setTitle("W A R  P O N G");
        Scene scene = new Scene(root, Rwidth, Rheight);
        stage.setScene(scene); //Add scene to stage
        Canvas canvas = new Canvas(Rwidth, Rheight);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        ge = new GE(Rwidth,Rheight,gc);

        //Controls
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

        // Add entities
        ge.init();

        Warrior J1 = ge.getJ1();
        Warrior J2 = ge.getJ2();
        Boss boss = ge.getBoss();

        gc.drawImage(J1.getSkinWarrior(), J1.getX(), J1.getY(), J1.getWidth(), J1.getHeight());
        gc.drawImage(J2.getSkinWarrior(), J2.getX(), J2.getY(), J2.getWidth(), J2.getHeight());
        gc.drawImage(boss.getHeadBoss(), boss.getX(), boss.getY(), boss.getWidth(), boss.getHeight());




        Timeline loop = new Timeline(new KeyFrame(Duration.millis(30), arg -> {
            //Mvt Warrior
            if (inputString.contains(KeyCode.S)) {
                    J1.setY(J1.getY() + J1.getVelocity());
                }
                if (inputString.contains(KeyCode.Z)) {
                    J1.setY(J1.getY() - J1.getVelocity());
                }
                if (inputString.contains(KeyCode.DOWN)) {
                    J2.setY(J2.getY() + J2.getVelocity());
                }
                if (inputString.contains(KeyCode.UP)) {
                    J2.setY(J2.getY() - J2.getVelocity());
                }

            //Mvt boss
            if(boss.getY()< (double) Rheight / 2 - 50){
                boss.setMonte(false);
            }
            if(boss.getY() > (double) Rheight / 2 + 50){
                boss.setMonte(true);
            }
                if (boss.getMonte()){
                    boss.setY(boss.getY() - boss.getVelocity());
                }else{
                    boss.setY(boss.getY() + boss.getVelocity());
                }

            //Draw
            gc.drawImage(fond, 0, 0, Rwidth, Rheight);
            gc.drawImage(boss.getHeadBoss(), boss.getX(), boss.getY(), boss.getWidth(), boss.getHeight());
            gc.drawImage(J1.getSkinWarrior(), J1.getX(), J1.getY(), J1.getWidth(), J1.getHeight());
            gc.drawImage(J2.getSkinWarrior(), J2.getX(), J2.getY(), J2.getWidth(), J2.getHeight());
        }));
            loop.setCycleCount(Timeline.INDEFINITE);
            loop.play();

            stage.show();
            }
        }
