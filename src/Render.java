import GameEngine.Entity.Boss;
import GameEngine.Entity.FireBall;
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
import java.util.List;

public class Render extends Application {

    //Variables
    int Rwidth = 1200;
    int Rheight = 700;
    GE ge;
    public static ArrayList<KeyCode> inputString = new ArrayList<>();
    Image fond = new Image("Resources/Sprites/fond.png");
    long time;
    int fps = 30;
    int cadence = 2000;

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
        ge = new GE(Rwidth,Rheight);

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
        List<FireBall> lfb = new ArrayList<>();


        Timeline loop = new Timeline(new KeyFrame(Duration.millis(fps), arg -> {
            time += 1;

            //Test
            if ((time % Math.floor((float) cadence / fps)) == 0){
                System.out.println(time);
                FireBall FBJ1 = ge.addFireBall(J1, J1.getX(), J1.getY());
                FireBall FBJ2 = ge.addFireBall(J2, J2.getX(), J2.getY());
                FireBall FBBG = ge.addFireBallBoss(boss, boss.getX(), boss.getY(), "G");
                FireBall FBBD = ge.addFireBallBoss(boss, boss.getX(), boss.getY(), "D");
                lfb.add(FBJ1);
                lfb.add(FBJ2);
                lfb.add(FBBG);
                lfb.add(FBBD);
            }

            //Mvt Fireball
            for (FireBall f : lfb){
                f.setX(f.getX() + f.getVelocity());
                if (f.getX() < 0 | f.getX() > Rwidth){
                    lfb.remove(f);
                }
            }

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
            if(boss.getY()< (double) Rheight / 2 - (boss.getHeight() / 2 + (double) 3*Rheight/10)){
                boss.setMonte(false);
            }
            if(boss.getY() > (double) 4*Rheight/5 - boss.getHeight() / 2){
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
            for (FireBall f : lfb){
                gc.drawImage(f.getSkinFireBall(), f.getX(), f.getY(), f.getWidth(), f.getHeight());
            }
        }));
            loop.setCycleCount(Timeline.INDEFINITE);
            loop.play();

            stage.show();
            }
        }
