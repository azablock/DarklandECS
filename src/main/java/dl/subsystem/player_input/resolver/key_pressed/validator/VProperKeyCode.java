package dl.subsystem.player_input.resolver.key_pressed.validator;

import dl.behavior.BPlayerInput;
import dl.subsystem.ValidatorAbstract;
import javafx.scene.input.KeyEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static dl.subsystem.player_input.resolver.key_pressed.helper.HVelocityMagnitude.H_VELOCITY_MAGNITUDE;

@Component
public class VProperKeyCode extends ValidatorAbstract {

    @Override
    public boolean validate(@NotNull UUID entity) {
        BPlayerInput cPlayerInput = em.getBehavior(entity, BPlayerInput.class);
        KeyEvent keyEvent = cPlayerInput.keyboardEvents.getFirst();

        return H_VELOCITY_MAGNITUDE.properKeyCodes().contains(keyEvent.getCode());
    }
}
