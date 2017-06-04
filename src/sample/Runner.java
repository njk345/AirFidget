package sample;

/**
 * Created by njk on 6/4/17.
 */
public class Runner {
    public static void main(String[] args) {
        UI.launch(args);
        new Arduino("COM4").runArduinoProcess();
    }
}
