package subsystem.movement;

import component.CPosition;
import component.CVelocity;
import subsystem.Subsystem;

public class SMovement extends Subsystem {

    @Override
    public void initialize() {
        this.requiredComponentTypes.add(CPosition.class);
        this.requiredComponentTypes.add(CVelocity.class);
    }
}