package dl.subsystem.player_input.resolver.key_pressed.validator;

import dl.behavior.BPlayerInput;
import dl.subsystem.ValidatorAbstract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class VHasKeyEvents extends ValidatorAbstract {

    @Override
    public boolean validate(@NotNull final UUID entity) {
        BPlayerInput cPlayerInput = em.getBehavior(entity, BPlayerInput.class);

        return !cPlayerInput.keyboardEvents.isEmpty();
    }
}
