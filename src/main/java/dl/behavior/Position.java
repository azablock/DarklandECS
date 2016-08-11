package dl.behavior;

import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;

public class Position implements Behavior {

    public Point2D position;

    public Position(Point2D position) {
        this.position = position;
    }

    public Position() {
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
