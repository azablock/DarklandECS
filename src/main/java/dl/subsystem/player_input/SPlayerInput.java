package dl.subsystem.player_input;

import dl.Behavior.BPlayerInput;
import dl.Behavior.BVelocity;
import dl.subsystem.Subsystem;
import dl.subsystem.player_input.resolver.key_pressed.RKeyPressed;

import java.util.Arrays;

public class SPlayerInput extends Subsystem {

    @Override
    public void initialize() {
        resolvers.add(new RKeyPressed());

        requiredBehaviorTypes.addAll(Arrays.asList(
                BPlayerInput.class,
//                CPosition.class,
                BVelocity.class
        ));
    }
}
