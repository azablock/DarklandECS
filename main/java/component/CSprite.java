package component;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.jetbrains.annotations.NotNull;

public class CSprite implements Component {

    @NotNull
    public final Group sprite;

    @NotNull
    public final Text text;

    public CSprite() {
        Rectangle rectangle = new Rectangle(100, 100, 64, 64);
        rectangle.setFill(Color.AQUAMARINE);
        text = new Text(200, 200, "?");

        sprite = new Group(
                rectangle,
                text
        );
    }

    @NotNull
    @Override
    public String simpleName() {
        return "Sprite";
    }
}
