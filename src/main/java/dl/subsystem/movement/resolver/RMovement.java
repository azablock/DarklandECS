package dl.subsystem.movement.resolver;

import dl.Behavior.BPosition;
import dl.Behavior.BVelocity;
import dl.game_world.GameObject;
import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import dl.subsystem.Resolver;
import dl.subsystem.Validator;
import dl.subsystem.movement.resolver.helper.HChangePosition;
import dl.subsystem.movement.resolver.validator.VIsMoving;
import dl.subsystem.movement.resolver.validator.VReachedMaxSpeed;

import java.util.ArrayList;
import java.util.List;

public class RMovement implements Resolver {

    private final List<Validator> validators;

    public RMovement() {
        validators = new ArrayList<>();

        validators.add(new VIsMoving());
        validators.add(new VReachedMaxSpeed());
    }

    @Override
    public void resolve(@NotNull GameObject gameObject) {
        BPosition cPosition = gameObject.get(BPosition.class);
        BVelocity cVelocity = gameObject.get(BVelocity.class);

        cVelocity.movementVector = cVelocity.movementVector.add(cVelocity.movementSpeedDelta);
        HChangePosition.changePosition(cPosition, cVelocity.movementVector);
        cVelocity.movementSpeedDelta = Point2D.ZERO;
        cVelocity.movementVector = Point2D.ZERO;

        System.out.println("RMovement " + cPosition);
    }

    @Nullable
    @Override
    public List<Validator> validators() {
        return validators;
    }
}
