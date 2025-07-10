module com.example.gladiatori {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens front to javafx.fxml;
    exports front;
}