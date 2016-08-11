package dl.subsystem.player_input.resolver.key_pressed.validator;

import dl.behavior.PlayerInput;
import dl.subsystem.Validator;
import dl.subsystem.player_input.resolver.key_pressed.helper.VelocityMagnitudeHelper;
import javafx.scene.input.KeyEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProperKeyCodeValidator extends Validator {

    @Autowired
    private VelocityMagnitudeHelper velocityMagnitudeHelper;

    @Override
    public boolean validate(@NotNull UUID entity) {
        PlayerInput cPlayerInput = entityManager.getBehavior(entity, PlayerInput.class);
        KeyEvent keyEvent = cPlayerInput.keyboardEvents.getFirst();

        return velocityMagnitudeHelper.properKeyCodes().contains(keyEvent.getCode());
    }
}
