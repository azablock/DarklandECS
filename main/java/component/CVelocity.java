package component;

import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;

public class CVelocity implements Component {

    public final Point2D movementVector;

    public final Double maxSpeed;

    public CVelocity() {
        this.movementVector = new Point2D(0.0, 0.0);
        maxSpeed = 10.0;
    }

    public boolean reachedMaxSpeed() {
        return movementVector.magnitude() >= maxSpeed;
    }

    @NotNull
    @Override
    public String simpleName() {
        return "Velocity";
    }
}
