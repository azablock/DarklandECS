package dl.subsystem.movement.resolver.validator;

import dl.behavior.Velocity;
import dl.subsystem.Validator;
import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class IsMovingValidator extends Validator {

    @Override
    public boolean validate(@NotNull UUID entity) {
        Velocity cVelocity = entityManager.getBehavior(entity, Velocity.class);
        return !cVelocity.movementSpeedDelta.equals(Point2D.ZERO);
    }
}
