package subsystem.movement.resolver.validator;

import component.CVelocity;
import game_world.GameObject;
import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;
import subsystem.Validator;

public class VIsMoving implements Validator {

    @Override
    public boolean validate(@NotNull GameObject gameObject) {
        CVelocity cVelocity = gameObject.get(CVelocity.class);

        return !cVelocity.movementSpeedDelta.equals(Point2D.ZERO);
    }
}
