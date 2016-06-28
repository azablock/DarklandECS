package subsystem.player_input;

import component.CPlayerInput;
import component.CPosition;
import component.CVelocity;
import subsystem.Subsystem;
import subsystem.player_input.handler.RKeyPressed;

public class SPlayerInput extends Subsystem {

    @Override
    public void initialize() {
        resolvers.put(RKeyPressed.class, new RKeyPressed());

        requiredComponentTypes.add(CPlayerInput.class);
        requiredComponentTypes.add(CPosition.class);
        requiredComponentTypes.add(CVelocity.class);
    }
}
