package dl.subsystem.player_input;

import dl.behavior.BPlayerInput;
import dl.behavior.BVelocity;
import dl.subsystem.Subsystem;
import dl.subsystem.player_input.resolver.key_pressed.RKeyPressed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class SPlayerInput extends Subsystem {

    @Autowired
    private RKeyPressed rKeyPressed;

    @PostConstruct
    private void init() {
        resolvers.add(rKeyPressed);

        requiredBehaviorTypes.addAll(Arrays.asList(
                BPlayerInput.class,
//                CPosition.class,
                BVelocity.class
        ));
    }
}
