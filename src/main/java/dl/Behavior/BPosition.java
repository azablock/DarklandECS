package dl.Behavior;

import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;

public class BPosition implements Behavior {

    public Point2D position;

    public BPosition(Point2D position) {
        this.position = position;
    }

    public BPosition() {
        position = Point2D.ZERO;
    }

    @Override
    public String toString() {
        return String.format("BPosition{position=%s}", position);
    }

    @NotNull
    @Override
    public String simpleName() {
        return "Position";
    }
}
