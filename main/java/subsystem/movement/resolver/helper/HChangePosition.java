package subsystem.movement.resolver.helper;

import component.CPosition;
import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;

public class HChangePosition {

    public static void changePosition(@NotNull CPosition cPosition, @NotNull final Point2D movementVector) {
        cPosition.position = cPosition.position.add(movementVector);
    }
}
