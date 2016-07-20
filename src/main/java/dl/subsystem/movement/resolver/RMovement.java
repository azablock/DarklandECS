package dl.subsystem.movement.resolver;

import dl.behavior.BPosition;
import dl.behavior.BVelocity;
import dl.subsystem.ResolverAbstract;
import dl.subsystem.movement.resolver.helper.HChangePosition;
import dl.subsystem.movement.resolver.validator.VIsMoving;
import dl.subsystem.movement.resolver.validator.VReachedMaxSpeed;
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
public class RMovement extends ResolverAbstract {

    @NotNull
    private static final Logger LOG = LoggerFactory.getLogger(RMovement.class);

    @Autowired
    private VIsMoving vIsMoving;

    @Autowired
    private VReachedMaxSpeed vReachedMaxSpeed;

    @PostConstruct
    private void init() {
        validators.addAll(Arrays.asList(
                vIsMoving,
                vReachedMaxSpeed
        ));
    }

    @Override
    public void resolve(@NotNull UUID entity) {
        BPosition cPosition = em.getBehavior(entity, BPosition.class);
        BVelocity cVelocity = em.getBehavior(entity, BVelocity.class);

        cVelocity.movementVector = cVelocity.movementVector.add(cVelocity.movementSpeedDelta);
        HChangePosition.changePosition(cPosition, cVelocity.movementVector);
        cVelocity.movementSpeedDelta = Point2D.ZERO;
        cVelocity.movementVector = Point2D.ZERO;

        LOG.debug(String.valueOf(cPosition));
    }
}
