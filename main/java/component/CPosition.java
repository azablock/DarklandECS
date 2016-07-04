package component;

import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;

public class CPosition implements Component {

    public Point2D position;

    public CPosition(Point2D position) {
        this.position = position;
    }

    public CPosition() {
        position = Point2D.ZERO;
    }

    @Override
    public String toString() {
        return String.format("CPosition{position=%s}", position);
    }

    @NotNull
    @Override
    public String simpleName() {
        return "Position";
    }
}
