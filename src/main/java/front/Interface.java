package front;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Interface extends Application {
    public static Stage stage2;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Interface.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 750);
        stage.setTitle("Gladiators");
        stage.setScene(scene);
        stage.show();
        stage2 = stage;
    }

    public static void hide(){
        stage2.hide();
    }
    public static void show(){stage2.show();}

    public static void main(String[] args) {
        launch();
    }
}
