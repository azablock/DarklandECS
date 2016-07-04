package subsystem.movement.resolver;

import component.CPosition;
import component.CVelocity;
import game_world.GameObject;
import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import subsystem.Resolver;
import subsystem.Validator;
import subsystem.movement.resolver.helper.HChangePosition;
import subsystem.movement.resolver.validator.VIsMoving;
import subsystem.movement.resolver.validator.VReachedMaxSpeed;

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
        CPosition cPosition = gameObject.get(CPosition.class);
        CVelocity cVelocity = gameObject.get(CVelocity.class);

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
