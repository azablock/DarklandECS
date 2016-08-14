package dl.subsystem.player_input.resolver.key_pressed.validator;

import dl.behavior.Behavior;
import dl.behavior.PlayerInput;
import dl.subsystem.Validator;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class HasKeyEventsValidator extends Validator {

    @Override
    public boolean validate(@NotNull final UUID entity) {
        PlayerInput playerInput = entityManager.getBehavior(entity, PlayerInput.class);

        return !playerInput.keyboardEvents.isEmpty();
    }

    @Override
    public Set<Class<? extends Behavior>> requiredBehaviorTypes() {
        return new HashSet<>(Arrays.asList(
                PlayerInput.class
        ));
    }
}
