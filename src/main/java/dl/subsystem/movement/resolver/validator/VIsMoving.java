package dl.subsystem.movement.resolver.validator;

import dl.behavior.BVelocity;
import dl.entity.EntityManager;
import dl.subsystem.Validator;
import javafx.geometry.Point2D;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class VIsMoving implements Validator {

    @Autowired
    private EntityManager em;

    @Override
    public boolean validate(@NotNull UUID entity) {
        BVelocity cVelocity = em.getBehavior(entity, BVelocity.class);
        return !cVelocity.movementSpeedDelta.equals(Point2D.ZERO);
    }
}
