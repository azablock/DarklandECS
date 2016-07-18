package dl.subsystem.movement;

import dl.behavior.BPosition;
import dl.behavior.BVelocity;
import dl.subsystem.Subsystem;
import dl.subsystem.movement.resolver.RMovement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SMovement extends Subsystem {

    @Autowired
    private RMovement rMovement;

    @PostConstruct
    public void initialize() {
        this.resolvers.add(rMovement);

        this.requiredBehaviorTypes.add(BPosition.class);
        this.requiredBehaviorTypes.add(BVelocity.class);
    }
}