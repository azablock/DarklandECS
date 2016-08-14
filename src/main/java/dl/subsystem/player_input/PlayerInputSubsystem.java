package dl.subsystem.player_input;

import dl.subsystem.Subsystem;
import dl.subsystem.player_input.resolver.key_pressed.IncreaseVelocityResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class PlayerInputSubsystem extends Subsystem {

    @Autowired
    private IncreaseVelocityResolver keyPressedResolver;

    @PostConstruct
    private void init() {
        resolvers.addAll(Arrays.asList(
                keyPressedResolver
        ));
    }
}
