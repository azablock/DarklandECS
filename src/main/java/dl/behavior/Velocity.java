package dl.behavior;

import javafx.geometry.Point2D;

public class Velocity extends Behavior {

    public final Double maxSpeed = 10.0;

    public Point2D movementVector = Point2D.ZERO;

    public Point2D movementSpeedDelta = Point2D.ZERO;
}
