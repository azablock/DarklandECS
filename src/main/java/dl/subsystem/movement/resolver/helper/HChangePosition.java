package dl.subsystem.movement.resolver.helper;

import dl.behavior.BPosition;
import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;

public class HChangePosition {

    public static void changePosition(@NotNull BPosition cPosition, @NotNull final Point2D movementVector) {
        cPosition.position = cPosition.position.add(movementVector);
    }
}
