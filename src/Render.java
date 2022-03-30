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
import java.util.concurrent.atomic.AtomicBoolean;

public class Render extends Application {

    //Variables
    int Rwidth = 1200;
    int Rheight = 700;
//    GE ge;
    int velocity = 5;
    double oldJ1Y = (double) Rheight/2;
    double oldJ2Y = (double) Rheight/2;
    double oldBossY = (double) Rheight/2;

    public static ArrayList<KeyCode> inputString = new ArrayList<>();

    //Method


    @Override
    public void start(Stage stage) {
        //Create group Object
        Group root = new Group();

        Canvas canvas = new Canvas(Rwidth, Rheight);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);

        //Add fond
//        ge = new GE(Rwidth,Rheight,gc);

        // Add entities
 //       ge.init();

        //Create a scene
        Scene scene = new Scene(root, Rwidth, Rheight);

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
        Image ImBoss2 = new Image("Resources/Sprites/dragon_100x79.png");
 //       Image ImBoss = ge.getBoss().getHeadBoss();
        int xJ1 = 55;
        int xJ2 = Rwidth - 100;
        int xBoss = Rwidth/2;
        int heighJ1 = 50;
        int widhtJ1 = 43;
        int heighJ2 = 50;
        int widhtJ2 = 37;
        int heighBoss = 79;
        int widhtBoss = 100;
        AtomicBoolean monte = new AtomicBoolean(true);


        stage.setTitle("W A R  P O N G");
        stage.show();


            //gc.setFill(Color.WHITE);

            //Add Boss
/*            Boss bossfake = new Boss((Rwidth/2),(Rheight/2));
            Image ImBoss = boss.getHeadBoss();
            gc.drawImage(ImBoss, boss.getX(), boss.getY(), boss.getWidth(), boss.getHeight());*/


        Timeline loop = new Timeline(new KeyFrame(Duration.millis(30), arg -> {
            //Controle clavier
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

                //Mouvement boss
            if(oldBossY < Rheight / 2 - 50){
                monte.set(false);
            }
            if(oldBossY > Rheight / 2 + 50){
                monte.set(true);
            }
                if (monte.get()){
                    oldBossY -= velocity;
                }else{
                    oldBossY += velocity;
                }
/*
                if (oldBossY < (Rheight/2 + 50)){
                    oldBossY = (oldBossY - velocity);
                }}
                if (oldBossY > (Rheight/2 - 50)){
                    oldBossY = (oldBossY - velocity);
                }
*/

                gc.drawImage(fond, 0, 0, Rwidth, Rheight);
                gc.drawImage(ImBoss2, xBoss, oldBossY, widhtBoss, heighBoss);
//                gc.drawImage(ImBoss, ge.getBoss().getX(), ge.getBoss().getY(), ge.getBoss().getWidth(), ge.getBoss().getHeight());
                gc.drawImage(j1, xJ1, oldJ1Y, widhtJ1, heighJ1);
                gc.drawImage(j2, xJ2, oldJ2Y, widhtJ2, heighJ2);
                }));
            loop.setCycleCount(Timeline.INDEFINITE);
            loop.play();

                stage.show();
            }
        }