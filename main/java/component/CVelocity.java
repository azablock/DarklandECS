package component;

import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;

public class CVelocity implements Component {

    public final Point2D movementSpeedVector;

    public final Double maxSpeed;

    public CVelocity() {
        this.movementSpeedVector = new Point2D(0.0, 0.0);
        maxSpeed = 10.0;
    }

    @NotNull
    @Override
    public String simpleName() {
        return "Velocity";
    }
}
