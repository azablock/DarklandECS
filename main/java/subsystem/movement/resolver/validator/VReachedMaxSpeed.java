package subsystem.movement.resolver.validator;

import component.CVelocity;
import game_world.GameObject;
import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;
import subsystem.Validator;

//nie ten subsystem
public class VReachedMaxSpeed implements Validator {

    @Override
    public boolean validate(@NotNull GameObject gameObject) {
        CVelocity cVelocity = gameObject.get(CVelocity.class);
        Point2D currentSpeed = cVelocity.movementVector;
        Point2D movementSpeedDelta = cVelocity.movementSpeedDelta;

        Point2D newVelocityMagnitude = new Point2D(
                currentSpeed.getX() + movementSpeedDelta.getX(),
                currentSpeed.getY() + movementSpeedDelta.getY());

        return newVelocityMagnitude.magnitude() <= cVelocity.maxSpeed;
    }
}
