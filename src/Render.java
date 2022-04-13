import GameEngine.Controls;
import GameEngine.Entity.Boss;
import GameEngine.Entity.FireBall;
import GameEngine.Entity.LFireBall;
import GameEngine.Entity.Warrior;
import GameEngine.GE;
import Graphism.Background;
import Graphism.FinishText;
import Graphism.Retry;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static javafx.scene.paint.Color.*;

public class Render extends Application {

    //Variables
    final int Rwidth = 1200;
    final int Rheight = 700;
    GE ge;
    public static ArrayList<KeyCode> inputString = new ArrayList<>();
    int choixMap;
    long time;
    int fps = 30;
    int cadence = 2000;
    Timeline loop;

    //Method

    /**
     * Start the app and the scene with an animation timer.
     * Add Entities (Warriors, Boss, Fireballs).
     * Define the scene, the winning condition, the canvas.
     * Calculate damage.
     * Introduce small animation.
     * @param stage -> the stage
     */
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
        ge = new GE(Rwidth, Rheight);
        choixMap = (int) Math.floor(1 + Math.random() * 2);
        Background background = new Background(choixMap);

        // ADD ENTITIES //
        ge.init();
        Warrior J1 = ge.getJ1();
        Warrior J2 = ge.getJ2();
        Boss boss = ge.getBoss();
        LFireBall LFB = new LFireBall();

        FinishText Ftext = new FinishText(Rwidth, Rheight);
        root.getChildren().addAll(Ftext.getDefeat(), Ftext.getWin());
        Retry retry = new Retry();
        Image explo = new Image("Resources/Sprites/explo.png");

        //Controls
        scene.setOnKeyPressed(e-> Controls.input(e.getCode()));
        scene.setOnKeyReleased(e-> Controls.output(e.getCode()));

        loop = new Timeline(new KeyFrame(Duration.millis(fps), arg -> {
            time += 1;
            //Hit box
            Rectangle2D hitboxBoss = boss.createHitbox();
            Rectangle2D hitboxJ1 = J1.createHitbox();
            Rectangle2D hitboxJ2 = J2.createHitbox();

            if ((time % Math.floor((float) cadence / fps)) == 0) {
                //COOP
                if (inputString.contains(KeyCode.LEFT)) {
                    J2.setHp(J2.getHp() - 1);
                    J1.setHp(J1.getHp() + 1);
                }
                if (inputString.contains(KeyCode.Q)) {
                    J1.setHp(J1.getHp() - 1);
                    J2.setHp(J2.getHp() + 1);
                }
                //Attack
                if (J1.Isalive()) {
                    FireBall FBJ1 = ge.addFireBall(J1, J1.getX(), J1.getY());
                    LFB.getLfb().add(FBJ1);
                }
                if (J2.Isalive()) {
                    FireBall FBJ2 = ge.addFireBall(J2, J2.getX(), J2.getY());
                    LFB.getLfb().add(FBJ2);
                }
                FireBall FBBG = ge.addFireBallBoss(boss, "G", "classic");
                FireBall FBBD = ge.addFireBallBoss(boss, "D", "classic");
                LFB.getLfb().add(FBBG);
                LFB.getLfb().add(FBBD);
            }
            //Boss Special attack
            if ((time % Math.floor((float) (4 * cadence) / fps)) == 0) {
                int atkSpe = (int) Math.floor(1 + Math.random() * 2);
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

            //MOVEMENT
            //Mvt Fireball
            LFB.moveAllFireBall(J1, J2, boss, Rwidth, hitboxBoss, hitboxJ1, hitboxJ2);
            //Mvt Warrior
            Controls.moveWarrior(J1, Rheight);
            Controls.moveWarrior(J2, Rheight);
            //Mvt boss
            boss.move(Rheight);

            //Check is alive
            J1.checkIsAlive();
            J2.checkIsAlive();

            //DRAW
            gc.drawImage(background.getImage(), 0, 0, Rwidth, Rheight);
            boss.drawBoss(gc, time, 10, fps);
            J1.drawEntity(gc);
            J2.drawEntity(gc);
            LFB.drawFireball(gc);
            stage.setTitle("J1 : " + J1.getHp() + "     " + boss.getHp() + "     " + J2.getHp() + " : J2");
            J1.drawLifeBar(gc);
            J2.drawLifeBar(gc);
            boss.drawLifeBar(gc);

            //FINISH
            if (boss.getHp() <= J1.getWarriorDamage()) {
                gc.drawImage(explo,
                        (boss.getX() - boss.getWidth() / 2.2), boss.getY() - boss.getHeight() / 1.3,
                        boss.getWidth() * 2, boss.getHeight() * 2);
            }
            //Victory
            if (boss.getHp() <= 0) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                    Ftext.getWin().setVisible(true);
                    Text score1 = new Text("" + J1.getScoreW());
                    Text score2 = new Text(""+ J2.getScoreW());
                    score1.setFont(Font.font("Consola", 30));
                    score1.setFill(CORNFLOWERBLUE);
                    score1.setTextOrigin(VPos.CENTER);
                    score1.setLayoutX(510);
                    score1.setLayoutY(135);
                    score1.setVisible(true);
                    score2.setFont(Font.font("Consola", 30));
                    score2.setFill(RED);
                    score2.setTextOrigin(VPos.CENTER);
                    score2.setLayoutX(610);
                    score2.setLayoutY(135);
                    score2.setVisible(true);
                    Rectangle scoreJ1 = new Rectangle((500-(((double)J1.getScoreW()/200)*400)),120,((double)J1.getScoreW()/200)*400, 30);
                    scoreJ1.setArcHeight(5);
                    scoreJ1.setArcWidth(5);
                    scoreJ1.setFill(CORNFLOWERBLUE);
                    Rectangle scoreJ2 = new Rectangle(650,120,((double)J2.getScoreW()/200)*400, 30);
                    scoreJ2.setArcHeight(5);
                    scoreJ2.setArcWidth(5);
                    scoreJ2.setFill(RED);
                    root.getChildren().addAll(score1, score2, scoreJ1, scoreJ2);
                    this.loop.stop();
                    Image winD = new Image("Resources/Sprites/win.png");
                    gc.drawImage(winD, 0, 0, Rwidth, Rheight);
                    retry.modifyButton(Rheight, Rwidth);
                    retry.getButton().setOnMouseClicked(e -> start(stage));
                    retry.getButton().setFont(new Font(20));
                    root.getChildren().add(retry.getButton());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //Defeat
            if (J1.getHp() <= 0 && J2.getHp() <= 0) {
                Ftext.getDefeat().setVisible(true);
                Ftext.displayScore(Rwidth, Rheight, J1.getScoreW(), J2.getScoreW());
                this.loop.stop();
                Image defeatD = new Image("Resources/Sprites/defeat.png");
                gc.drawImage(defeatD, 0, 0, Rwidth, Rheight);
                retry.modifyButton(Rheight, Rwidth);
                retry.getButton().setOnMouseClicked(e -> start(stage));
                retry.getButton().setFont(new Font(20));
                root.getChildren().add(retry.getButton());
            }
        }));
        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
        stage.show();
    }
}