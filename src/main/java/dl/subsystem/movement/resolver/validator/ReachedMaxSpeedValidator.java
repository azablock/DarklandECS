package dl.subsystem.movement.resolver.validator;

import dl.behavior.Behavior;
import dl.behavior.Velocity;
import dl.subsystem.Validator;
import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

//nie ten dl.subsystem
@Component
public class ReachedMaxSpeedValidator extends Validator {

    @Override
    public boolean validate(@NotNull UUID entity) {
        Velocity cVelocity = entityManager.getBehavior(entity, Velocity.class);
        Point2D currentSpeed = cVelocity.movementVector;
        Point2D movementSpeedDelta = cVelocity.movementSpeedDelta;

        Point2D newVelocityMagnitude = new Point2D(
                currentSpeed.getX() + movementSpeedDelta.getX(),
                currentSpeed.getY() + movementSpeedDelta.getY());

        return newVelocityMagnitude.magnitude() <= cVelocity.maxSpeed;
    }

    @Override
    public Set<Class<? extends Behavior>> requiredBehaviorTypes() {
        return new HashSet<>(Arrays.asList(
                Velocity.class
        ));
    }
}
