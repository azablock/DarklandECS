package dl.subsystem.player_input.resolver.key_pressed.validator;

import dl.behavior.BPlayerInput;
import dl.entity.EntityManager;
import dl.subsystem.Validator;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class VHasKeyEvents implements Validator {

    @Autowired
    private EntityManager entityManager;

    @Override
    public boolean validate(@NotNull final UUID entity) {
        BPlayerInput cPlayerInput = entityManager.getBehavior(entity, BPlayerInput.class);

        return !cPlayerInput.keyboardEvents.isEmpty();
    }
}
