package dl.subsystem.player_input.resolver.key_pressed.validator;

import dl.behavior.Behavior;
import dl.behavior.PlayerInput;
import dl.subsystem.Validator;
import dl.subsystem.player_input.resolver.key_pressed.helper.DirectionByEventCodeHelper;
import javafx.scene.input.KeyEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
public class ProperKeyCodeValidator extends Validator {

    @Autowired
    private DirectionByEventCodeHelper directionByEventCodeHelper;

    @Override
    public boolean validate(@NotNull UUID entity) {
        PlayerInput playerInput = entityManager.getBehavior(entity, PlayerInput.class);
        KeyEvent keyEvent = playerInput.keyboardEvents.getFirst();

        return directionByEventCodeHelper
                .properKeyCodes()
                .contains(keyEvent.getCode());
    }

    @Override
    public Set<Class<? extends Behavior>> requiredBehaviorTypes() {
        return new HashSet<>(Arrays.asList(
                PlayerInput.class
        ));
    }
}
