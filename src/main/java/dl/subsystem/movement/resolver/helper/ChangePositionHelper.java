package dl.subsystem.movement.resolver.helper;

import dl.behavior.Position;
import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;

public class ChangePositionHelper {

    public static void changePosition(@NotNull Position cPosition, @NotNull final Point2D movementVector) {
        cPosition.position = cPosition.position.add(movementVector);
    }
}
