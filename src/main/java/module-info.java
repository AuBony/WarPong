module com.example.warpong2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.warpong2 to javafx.fxml;
    exports com.example.warpong2;
}