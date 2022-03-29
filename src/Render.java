import GameEngine.Boss;
import GameEngine.Warrior;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

import java.util.ArrayList;

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
        private Scene scene;
        private Stage stage;
        long startNanoTime;
        AnimationTimer GameTimer;

        private void defineMainMenu(Stage theStage) {
                Button startButton = new Button("Start");
                startButton.setOnAction(e -> {
                        theStage.setScene(scene);
                        startNanoTime = System.nanoTime();
                        GameTimer.start();
                });
                startButton.setLayoutX(width / 2);
                startButton.setLayoutY(height / 2);
        }

                private void defineControl (Stage stage) {
                        ArrayList<KeyCode> input = new ArrayList<>(); //store the keyboard input

                        Group root = new Group();
                        scene = new Scene(root);
                        Canvas canvas = new Canvas(width, height);
                        root.getChildren().add(canvas);

                        GraphicsContext gc = canvas.getGraphicsContext2D();
                        scene.setOnKeyPressed(e -> {
                                        KeyCode code = e.getCode();
                                        if (!input.contains(code))
                                                input.add(code);
                                }
                        );

                        scene.setOnKeyReleased(e -> {
                                KeyCode code = e.getCode();
                                input.remove(code);
                        });

                        //Timeloop
                        final long startNanoTime = System.nanoTime();
                        new AnimationTimer() {
                                @Override
                                public void handle(long l) {
                                        double t = (l - startNanoTime) / 1000000000;

                                        if (input.contains(KeyCode.S)) {
                                                Warrior.move(1,5);
                                        }
                                        if (input.contains(KeyCode.Z)) {
                                                Warrior.move(1,-5);
                                        }
                                        if (input.contains(KeyCode.UP)) {
                                                Warrior.move(2,-5);
                                        }
                                        if (input.contains(KeyCode.DOWN)) {
                                                Warrior.move(2,5);
                                        }
                                        Image warriorIm = Warrior.getSkinWarrior();
                                        gc.drawImage(Warrior.getSkinWarrior(), (int) Warrior.getX(), (int) Warrior.getY(), Warrior.getWidth(), Warrior.getHeight());
                                }
                        }.start();
                }

                        public void start (Stage stage){

            //Create group Object
            Group root = new Group();

            //Create a scene
            Scene scene = new Scene(root, Rwidth, Rheight);
            stage.setScene(scene); //Add scene to stage
                                //Create a scene
                                Group root = new Group();
                                scene = new Scene(root, width, height);
                                //scene.setFill(Color.WHITE);
                                // new RadialGradient(0, 0, 500, 300, 500, false, CycleMethod.NO_CYCLE, new Stop(0, Color.grayRgb(60)), new Stop(1, Color.GREY));


            //Create a canvas
            Canvas canvas = new Canvas(Rwidth, Rheight);
            root.getChildren().add(canvas);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setFill(Color.BLACK);
                                //Create a canvas
                                Canvas canvas = new Canvas(width, height);
                                root.getChildren().add(canvas);
                                GraphicsContext gc = canvas.getGraphicsContext2D();
                                gc.setFill(Color.BLACK);

            //Add fond
            Image fond = new Image ("Resources/Sprites/Fond.png");
            gc.drawImage(fond, 50, 50, Rwidth-100, Rheight-100);


            //gc.setFill(Color.WHITE);
                                //Add fond
                                Image fond = new Image("Resources/Sprites/Fond.png");
                                gc.drawImage(fond, 50, 50, width - 100, height - 100);
                                //gc.setFill(Color.WHITE);

            //Add Boss
            Boss boss = new Boss((Rwidth/2),(Rheight/2));
            Image ImBoss = boss.getHeadBoss();
            gc.drawImage(ImBoss, boss.getX(), boss.getY(), boss.getWidth(), boss.getHeight());
            addBoss(gc);
                                //Add Boss
                                Boss boss = new Boss((width / 2), (height / 2), 70, 60);
                                Image ImBoss = boss.getHeadBoss();
                                gc.drawImage(ImBoss, boss.getX(), boss.getY(), boss.getWidth(), boss.getHeight());

            //Add Warrior
            addWarrior(gc, "J1");
            addWarrior(gc, "J2");
                                stage.setScene(scene); //Add scene to stage

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
                    }
            }.start();
            /*
 */

            //Stage
            stage.setTitle("W A R  P O N G");
            stage.show();


    }

}
