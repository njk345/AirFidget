package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Main extends Application {
    private static double sw, sh;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("AirFidget");
        primaryStage.setScene(new Scene(root, sw, sh));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
