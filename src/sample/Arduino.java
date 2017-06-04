package sample;

/**
 * Created by njk on 6/4/17.
 */
import org.sintef.jarduino.JArduino;
import org.sintef.jarduino.DigitalPin;
import org.sintef.jarduino.PinMode;
import org.sintef.jarduino.DigitalState;

public class Arduino extends JArduino {
    private static DigitalPin motor = DigitalPin.PIN_9;
    public Arduino(String port) {
        super(port);
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
