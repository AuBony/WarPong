import GameEngine.Entity.Boss;
import GameEngine.Entity.FireBall;
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
        List<FireBall> lfb = new ArrayList<>();


        loop = new Timeline(new KeyFrame(Duration.millis(fps), arg -> {
            time += 1;

            //Compteur de temps
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
                //Génération des boules de feu
                FireBall FBJ1 = ge.addFireBall(J1, J1.getX(), J1.getY());
                FireBall FBJ2 = ge.addFireBall(J2, J2.getX(), J2.getY());
                FireBall FBBG = ge.addFireBallBoss(boss, boss.getX(), boss.getY(), "G");
                FireBall FBBD = ge.addFireBallBoss(boss, boss.getX(), boss.getY(), "D");
                lfb.add(FBJ1);
                lfb.add(FBJ2);
                lfb.add(FBBG);
                lfb.add(FBBD);
            }
            if ((time % Math.floor((float) (4*cadence) / fps)) == 0){

                int atkSpe = (int) Math.floor(1+ Math.random()*2);
                if (atkSpe == 1){
                    FireBall FBBGspe = ge.addSpecialFireBallBoss(boss, boss.getX(), boss.getY(), "G");
                    lfb.add(FBBGspe);}
                if (atkSpe == 2){
                    FireBall FBBDspe = ge.addSpecialFireBallBoss(boss, boss.getX(), boss.getY(), "D");
                    lfb.add(FBBDspe);}
                if (atkSpe == 3){
                    FireBall FBBDspe2 = ge.addSpecialFireBallBoss(boss, boss.getX(), boss.getY(), "D");
                    FireBall FBBGspe2 = ge.addSpecialFireBallBoss(boss, boss.getX(), boss.getY(), "G");
                    lfb.add(FBBGspe2);
                    lfb.add(FBBDspe2);}
            }

            //Hitbox
            Rectangle2D hitboxBoss = new Rectangle2D(boss.getX(),boss.getY(), boss.getWidth(), boss.getHeight());
            Rectangle2D hitboxJ1 = new Rectangle2D(J1.getX(), J1.getY(), J1.getWidth(), J1.getHeight());
            Rectangle2D hitboxJ2 = new Rectangle2D(J2.getX(), J2.getY(), J2.getWidth(), J2.getHeight());

            //Mvt Fireball
            for (FireBall f : lfb){
                f.setX(f.getX() + f.getVelocity());
                //Out of bound
                if (f.getX() < 0 | f.getX() > Rwidth){
                    lfb.remove(f);
                    break;
                }
                //Collision
                Rectangle2D hitboxf = new Rectangle2D(f.getX(), f.getY(), f.getWidth(), f.getHeight());
                if(f.getCastBy().equals("Boss")) {
                    if (hitboxf.intersects(hitboxJ1)){
                        J1.setHp(J1.getHp() - f.getDamage());
                        System.out.println("HP J1 : " + J1.getHp());
                        lfb.remove(f);
                        break;
                }
                    if (hitboxf.intersects(hitboxJ2)){
                        J2.setHp(J2.getHp() - f.getDamage());
                        System.out.println("HP J2 : " + J2.getHp());
                        lfb.remove(f);
                        break;
                    }
                }
                if(f.getCastBy().equals("J1") | f.getCastBy().equals("J2")){
                    if (hitboxf.intersects(hitboxBoss)){
                        boss.setHp(boss.getHp() - f.getDamage());
                        System.out.println("HP Boss : " + boss.getHp());
                        lfb.remove(f);
                        break;
                    }
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
            if (choixMap == 1){gc.drawImage(fond1, 0, 0, Rwidth, Rheight);}
            if (choixMap == 2){gc.drawImage(fond2, 0, 0, Rwidth, Rheight);}
            if (choixMap == 3){gc.drawImage(fond3, 0, 0, Rwidth, Rheight);}
            gc.drawImage(boss.getHeadBoss(), boss.getX(), boss.getY(), boss.getWidth(), boss.getHeight());
            gc.drawImage(J1.getSkinWarrior(), J1.getX(), J1.getY(), J1.getWidth(), J1.getHeight());
            gc.drawImage(J2.getSkinWarrior(), J2.getX(), J2.getY(), J2.getWidth(), J2.getHeight());
            for (FireBall f : lfb){
                gc.drawImage(f.getSkinFireBall(), f.getX(), f.getY(), f.getWidth(), f.getHeight());
            }
                 //HP
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
