import com.example.warpong.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class Render extends Application {

    @Override
    public void start(Stage stage) {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        try{
            int width = 1000;
            int height = 600;

            Group root = new Group();

            Scene scene;
            scene = new Scene(root, width, height);
            scene.setFill(Color.BLACK);


            stage.setScene(scene);
            stage.setTitle("W A R  P O N G");

            stage.show();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        launch(args);
    }
}
