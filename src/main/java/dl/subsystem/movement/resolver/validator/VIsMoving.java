package dl.subsystem.movement.resolver.validator;

import dl.Behavior.BVelocity;
import dl.game_world.GameObject;
import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;
import dl.subsystem.Validator;

public class VIsMoving implements Validator {

    @Override
    public boolean validate(@NotNull GameObject gameObject) {
        BVelocity cVelocity = gameObject.get(BVelocity.class);

        return !cVelocity.movementSpeedDelta.equals(Point2D.ZERO);
    }
}
