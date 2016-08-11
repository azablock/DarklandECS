package dl.subsystem.player_input;

import dl.behavior.PlayerInput;
import dl.behavior.Velocity;
import dl.subsystem.Subsystem;
import dl.subsystem.player_input.resolver.key_pressed.KeyPressedResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class PlayerInputSubsystem extends Subsystem {

    @Autowired
    private KeyPressedResolver keyPressedResolver;

    @PostConstruct
    private void init() {
        resolvers.addAll(Arrays.asList(
              keyPressedResolver
        ));

        requiredBehaviorTypes.addAll(Arrays.asList(
                PlayerInput.class,
                Velocity.class
        ));
    }
}
