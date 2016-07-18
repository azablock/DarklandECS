package dl.subsystem.movement.resolver;

import dl.behavior.BPosition;
import dl.behavior.BVelocity;
import dl.entity.EntityManager;
import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import dl.subsystem.Resolver;
import dl.subsystem.Validator;
import dl.subsystem.movement.resolver.helper.HChangePosition;
import dl.subsystem.movement.resolver.validator.VIsMoving;
import dl.subsystem.movement.resolver.validator.VReachedMaxSpeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class RMovement implements Resolver {

    @Autowired
    private EntityManager em;

    @Autowired
    private VIsMoving vIsMoving;

    @Autowired
    private VReachedMaxSpeed vReachedMaxSpeed;

    private List<Validator> validators;

    @PostConstruct
    public void initialize() {
        validators = new ArrayList<>();

        validators.addAll(Arrays.asList(vIsMoving, vReachedMaxSpeed));
    }

    @Override
    public void resolve(@NotNull UUID entity) {
        BPosition cPosition = em.getBehavior(entity, BPosition.class);
        BVelocity cVelocity = em.getBehavior(entity, BVelocity.class);

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
