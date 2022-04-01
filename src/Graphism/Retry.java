package Graphism;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Retry extends Application {
    private final Button button = new Button("RETRY");

    public Retry(){
    }

    @Override
    public void start(Stage stage) {

    }

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
