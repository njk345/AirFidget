package sample;

/**
 * Created by njk on 6/4/17.
 */
import org.sintef.jarduino.JArduino;
import org.sintef.jarduino.DigitalPin;
import org.sintef.jarduino.PinMode;
import org.sintef.jarduino.DigitalState;

public class Arduino extends JArduino implements Runnable {
    Thread runner;
    private static DigitalPin motor = DigitalPin.PIN_9;
    public Arduino(String port) {
        super(port);
        runner = new Thread(this, "Arduino");
    }
    public void run() {
        new Arduino("COM4").runArduinoProcess();
    }
    @Override
    public void setup() {
        pinMode(motor, PinMode.OUTPUT);
    }
    @Override
    public void loop() {
        if (UI.spinning) {
            digitalWrite(motor, DigitalState.fromValue((byte) (UI.angVel / 10.0 * 127)));
        }
    }
}
