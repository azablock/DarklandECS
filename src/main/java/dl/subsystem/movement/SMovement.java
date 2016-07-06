package dl.subsystem.movement;

import dl.Behavior.BPosition;
import dl.Behavior.BVelocity;
import dl.subsystem.Subsystem;
import dl.subsystem.movement.resolver.RMovement;

public class SMovement extends Subsystem {

    @Override
    public void initialize() {
        this.resolvers.add(new RMovement());

        this.requiredBehaviorTypes.add(BPosition.class);
        this.requiredBehaviorTypes.add(BVelocity.class);
    }
}