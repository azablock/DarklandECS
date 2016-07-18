package dl.subsystem.movement.resolver.validator;

import dl.behavior.BVelocity;
import dl.subsystem.ValidatorAbstract;
import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

//nie ten dl.subsystem
@Component
public class VReachedMaxSpeed extends ValidatorAbstract {

    @Override
    public boolean validate(@NotNull UUID entity) {
        BVelocity cVelocity = em.getBehavior(entity, BVelocity.class);
        Point2D currentSpeed = cVelocity.movementVector;
        Point2D movementSpeedDelta = cVelocity.movementSpeedDelta;

        Point2D newVelocityMagnitude = new Point2D(
                currentSpeed.getX() + movementSpeedDelta.getX(),
                currentSpeed.getY() + movementSpeedDelta.getY());

        return newVelocityMagnitude.magnitude() <= cVelocity.maxSpeed;
    }
}
