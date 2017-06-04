package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.animation.RotateTransition;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Slider;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class UI extends Application {
    private static double sw, sh; //angular velocity in rps
    public static double angVel;
    public static long duration;
    public static boolean spinning;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        sw = screen.getWidth();
        sh = screen.getHeight();
        angVel = 5;
        spinning = false;

        Spinner spinner = new Spinner((sw - 530)/2, (sh - 530)/2);
        Slider speedSlider = new Slider(0, 10, 5);

        Group root = new Group(spinner, speedSlider);
        primaryStage.setTitle("AirFidget");
        Scene scene = new Scene(root, sw, sh);
        primaryStage.setScene(scene);
        primaryStage.show();

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                spinning = true;
                duration = 1000*(long)angVel;
                RotateTransition rt = new RotateTransition(Duration.millis(duration), spinner);
                rt.setByAngle(angVel * 360 * duration/1000);
                rt.setCycleCount(1);
                rt.play();
                spinning = false;
            }
        };
        speedSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                angVel = (Double)new_val;
            }
        });
        //Registering the event filter
        spinner.addEventFilter(MouseEvent.MOUSE_DRAGGED, eventHandler);
    }
}
