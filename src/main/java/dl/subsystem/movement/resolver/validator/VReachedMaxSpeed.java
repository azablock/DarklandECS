package dl.subsystem.movement.resolver.validator;

import dl.Behavior.BVelocity;
import dl.game_world.GameObject;
import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;
import dl.subsystem.Validator;

//nie ten dl.subsystem
public class VReachedMaxSpeed implements Validator {

    @Override
    public boolean validate(@NotNull GameObject gameObject) {
        BVelocity cVelocity = gameObject.get(BVelocity.class);
        Point2D currentSpeed = cVelocity.movementVector;
        Point2D movementSpeedDelta = cVelocity.movementSpeedDelta;

        Point2D newVelocityMagnitude = new Point2D(
                currentSpeed.getX() + movementSpeedDelta.getX(),
                currentSpeed.getY() + movementSpeedDelta.getY());

        return newVelocityMagnitude.magnitude() <= cVelocity.maxSpeed;
    }
}
