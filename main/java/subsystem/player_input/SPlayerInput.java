package subsystem.player_input;

import component.CPlayerInput;
import component.CPosition;
import component.CVelocity;
import subsystem.Subsystem;
import subsystem.player_input.resolver.key_pressed.RKeyPressed;

import java.util.Arrays;

public class SPlayerInput extends Subsystem {

    @Override
    public void initialize() {
        resolvers.add(new RKeyPressed());

        requiredComponentTypes.addAll(Arrays.asList(
                CPlayerInput.class,
//                CPosition.class,
                CVelocity.class
        ));
    }
}
