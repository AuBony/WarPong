import GameEngine.Entity.Boss;
import GameEngine.Entity.FireBall;
import GameEngine.Entity.LFireBall;
import GameEngine.Entity.Warrior;
import GameEngine.GE;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Render extends Application {

    //Variables
    int Rwidth = 1200;
    int Rheight = 700;
    GE ge;
    public static ArrayList<KeyCode> inputString = new ArrayList<>();
    Image fond;
    int choixMap;
    Image fond2 = new Image("Resources/Sprites/fond Japonais.png");
    Image fond3 = new Image("Resources/Sprites/fond.png");
    Image fond1 = new Image("Resources/Sprites/fond fantasy.png");
    Image winD = new Image("Resources/Sprites/win.png");
    Image defeatD = new Image("Resources/Sprites/defeat.png");

    long time;
    int fps = 30;
    int cadence = 2000;
    Timeline loop;

    //Method
    @Override
    public void start(Stage stage) {
        //Create Graphic

        choixMap = (int) Math.floor(1+ Math.random()*2);

        Text defeat = new Text("TRY AGAIN !");
        defeat.setFont(Font.font("Consola", 70));
        defeat.setFill(Color.RED);
        defeat.setTextOrigin(VPos.CENTER);
        defeat.setLayoutX((double) Rwidth/3);
        defeat.setLayoutY((double) Rheight/3);
        defeat.setVisible(false);

        Text win = new Text("GOD LIKE !");
        win.setFont(Font.font("Consola", 70));
        win.setFill(Color.RED);
        win.setTextOrigin(VPos.CENTER);
        win.setLayoutX((double) Rwidth/3);
        win.setLayoutY((double) Rheight/3);
        win.setVisible(false);

        Group root = new Group();

        stage.setTitle("W A R  P O N G");
        Scene scene = new Scene(root, Rwidth, Rheight);
        stage.setScene(scene); //Add scene to stage
        Canvas canvas = new Canvas(Rwidth, Rheight);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        ge = new GE(Rwidth,Rheight);
        root.getChildren().addAll(defeat,win);

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
        LFireBall LFB = new LFireBall();

        loop = new Timeline(new KeyFrame(Duration.millis(fps), arg -> {
            time += 1;
            // ADD ENTITIES //
                //Hitbox
            Rectangle2D hitboxBoss  = boss.createHitbox();
            Rectangle2D hitboxJ1 = J1.createHitbox();
            Rectangle2D hitboxJ2 = J2.createHitbox();

            //Cooperation
            if ((time % Math.floor((float) cadence / fps)) == 0){

                //COOP
                if (inputString.contains(KeyCode.LEFT)) {
                    J2.setHp(J2.getHp() -1);
                    J1.setHp(J1.getHp() + 1);
                }
                if (inputString.contains(KeyCode.Q)) {
                    J1.setHp(J1.getHp() -1);
                    J2.setHp(J2.getHp() + 1);
                }

                //Add fireball
                if (J1.Isalive()){
                    FireBall FBJ1 = ge.addFireBall(J1, J1.getX(), J1.getY());
                    LFB.getLfb().add(FBJ1);
                }
                if (J2.Isalive()){
                    FireBall FBJ2 = ge.addFireBall(J2, J2.getX(), J2.getY());
                    LFB.getLfb().add(FBJ2);
                }
                FireBall FBBG = ge.addFireBallBoss(boss, "G", "classic");
                FireBall FBBD = ge.addFireBallBoss(boss, "D", "classic");
                LFB.getLfb().add(FBBG);
                LFB.getLfb().add(FBBD);
            }
                //Boss Special attack
            if ((time % Math.floor((float) (4*cadence) / fps)) == 0){

                int atkSpe = (int) Math.floor(1+ Math.random()*2);
                switch (atkSpe) {
                    case 1 -> {
                        FireBall FBBGspe = ge.addFireBallBoss(boss, "G", "special");
                        LFB.getLfb().add(FBBGspe);
                    }
                    case 2 -> {
                        FireBall FBBDspe = ge.addFireBallBoss(boss, "D", "special");
                        LFB.getLfb().add(FBBDspe);
                    }
                    case 3 -> {
                        FireBall FBBDspe = ge.addFireBallBoss(boss, "D", "special");
                        FireBall FBBGspe = ge.addFireBallBoss(boss, "G", "special");
                        LFB.getLfb().add(FBBGspe);
                        LFB.getLfb().add(FBBDspe);
                    }
                }
            }

            //Mvt Fireball
            LFB.moveAllFireBall(J1, J2, boss, Rwidth, hitboxBoss, hitboxJ1, hitboxJ2);

            //Mvt Warrior
            if (inputString.contains(KeyCode.S) && J1.Isalive()) {
                    J1.setY(J1.getY() + J1.getVelocity());
                }
                if (inputString.contains(KeyCode.Z) && J1.Isalive()) {
                    J1.setY(J1.getY() - J1.getVelocity());
                }
                if (inputString.contains(KeyCode.DOWN) && J2.Isalive()) {
                    J2.setY(J2.getY() + J2.getVelocity());
                }
                if (inputString.contains(KeyCode.UP) && J2.Isalive()) {
                    J2.setY(J2.getY() - J2.getVelocity());
                }

            //Mvt boss
            boss.move(Rheight);

            //Check is alive
            if (J1.getHp() <=0){J1.setIsalive(false);}
            if (J2.getHp() <=0){J2.setIsalive(false);}

            //Draw
            if (choixMap == 1){gc.drawImage(fond1, 0, 0, Rwidth, Rheight);}
            if (choixMap == 2){gc.drawImage(fond2, 0, 0, Rwidth, Rheight);}
            if (choixMap == 3){gc.drawImage(fond3, 0, 0, Rwidth, Rheight);}
            boss.drawEntity(gc);
            J1.drawEntity(gc);
            J2.drawEntity(gc);
            for (FireBall f : LFB.getLfb()){
                f.drawEntity(gc);
            }
            stage.setTitle("J1 : " + J1.getHp() + "     " + boss.getHp() + "     " + J2.getHp() + " : J2");


            //Finishing
            if (boss.getHp() <= 0){
                win.setVisible(true);
                this.loop.stop();
                gc.drawImage(winD, 0, 0, Rwidth, Rheight);
            }
            if (J1.getHp() <= 0 && J2.getHp() <= 0){
                defeat.setVisible(true);
                this.loop.stop();
                gc.drawImage(defeatD, 0, 0, Rwidth, Rheight);

            }
        }));
            loop.setCycleCount(Timeline.INDEFINITE);
            loop.play();
            stage.show();
            }
}
