package dl.behavior;

import javafx.geometry.Point2D;

public class Position extends Behavior {

    public Point2D position = Point2D.ZERO;

    @Override
    public String toString() {
        return String.format("Position{position=%s}", position);
    }
}
