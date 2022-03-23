module com.example.warpong {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.warpong to javafx.fxml;
    exports com.example.warpong;
}