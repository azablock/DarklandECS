package component;

import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;

public class CVelocity implements Component {

    public Point2D movementVector;

    public Point2D movementSpeedDelta;

    public final Double maxSpeed;

    public CVelocity() {
        movementVector = Point2D.ZERO;
        movementSpeedDelta = Point2D.ZERO;
        maxSpeed = 10.0;
    }

    @NotNull
    @Override
    public String simpleName() {
        return "Velocity";
    }
}
