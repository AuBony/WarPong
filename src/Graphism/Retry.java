package Graphism;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Retry extends Application {
    //Variables
    private final Button button = new Button("RETRY");

    //Constructor
    public Retry(){
    }

    //Method

    /**
     * 2ndary start, used for tests.
     * @param stage the stage
     */
    @Override
    public void start(Stage stage) {

    }

    /**
     * Set parameters for the retry Button.
     * @param Rheight Height of the scene.
     * @param Rwidth Widht of the scene.
     */
    public void modifyButton(int Rheight, int Rwidth){
        this.button.setPrefSize(100, 50);
        this.button.setTextFill(Color.WHITE);
        this.button.setStyle("-fx-background-color:#A90000; ");
        this.button.setLayoutY((double) Rheight/2 - 25);
        this.button.setLayoutX((double) Rwidth/2 - 50);
        this.button.setVisible(true);
    }

    public Button getButton() {
        return button;
    }
}
