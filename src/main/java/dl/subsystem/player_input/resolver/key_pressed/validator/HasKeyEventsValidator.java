package dl.subsystem.player_input.resolver.key_pressed.validator;

import dl.behavior.PlayerInput;
import dl.subsystem.Validator;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HasKeyEventsValidator extends Validator {

    @Override
    public boolean validate(@NotNull final UUID entity) {
        PlayerInput cPlayerInput = entityManager.getBehavior(entity, PlayerInput.class);

        return !cPlayerInput.keyboardEvents.isEmpty();
    }
}
