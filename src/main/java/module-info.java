module com.example.snakeladderproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.snakeladderproject to javafx.fxml;
    exports com.example.snakeladderproject;
}