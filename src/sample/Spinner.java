package sample; /**
 * Created by njk on 6/3/17.
 */
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Spinner extends ImageView {
    private static String imgURL = "http://www.asseenontvandbeyond.com/assets/images/fidget-spinner-green.png";
    public Spinner(double x, double y) {
        super(new Image(imgURL));
        setX(x);
        setY(y);
    }
}