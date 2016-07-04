package subsystem.movement;

import component.CPosition;
import component.CVelocity;
import subsystem.Subsystem;
import subsystem.movement.resolver.RMovement;

public class SMovement extends Subsystem {

    @Override
    public void initialize() {
        this.resolvers.add(new RMovement());

        this.requiredComponentTypes.add(CPosition.class);
        this.requiredComponentTypes.add(CVelocity.class);
    }
}