package dl.subsystem.movement.resolver;

import dl.behavior.Position;
import dl.behavior.Velocity;
import dl.subsystem.Resolver;
import dl.subsystem.movement.resolver.validator.IsMovingValidator;
import dl.subsystem.movement.resolver.validator.ReachedMaxSpeedValidator;
import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.UUID;

@Component
public class MovementResolver extends Resolver {

    @NotNull
    private static final Logger LOG = LoggerFactory.getLogger(MovementResolver.class);

    @Autowired
    private IsMovingValidator isMovingValidator;

    @Autowired
    private ReachedMaxSpeedValidator reachedMaxSpeedValidator;

    @PostConstruct
    private void init() {
        validators.get().addAll(Arrays.asList(
                isMovingValidator,
                reachedMaxSpeedValidator
        ));
    }

    @Override
    public void resolve(@NotNull UUID entity) {
        Position cPosition = entityManager.getBehavior(entity, Position.class);
        Velocity cVelocity = entityManager.getBehavior(entity, Velocity.class);

        cVelocity.movementVector = cVelocity.movementVector.add(cVelocity.movementSpeedDelta);
        cPosition.position = cPosition.position.add(cVelocity.movementVector);

        cVelocity.movementSpeedDelta = Point2D.ZERO;
        cVelocity.movementVector = Point2D.ZERO;

        LOG.debug(String.valueOf(cPosition));
    }
}
