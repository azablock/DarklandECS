package subsystem.player_input.resolver.key_pressed.validator;

import component.CPlayerInput;
import subsystem.Validator;
import game_world.GameObject;
import javafx.scene.input.KeyEvent;
import org.jetbrains.annotations.NotNull;

import static subsystem.player_input.resolver.key_pressed.helper.HVelocityMagnitude.H_VELOCITY_MAGNITUDE;

public class VProperKeyCode implements Validator {

    @Override
    public boolean validate(@NotNull GameObject gameObject) {
        CPlayerInput cPlayerInput = gameObject.get(CPlayerInput.class);
        KeyEvent keyEvent = cPlayerInput.keyboardEvents.getFirst();

        return H_VELOCITY_MAGNITUDE.properKeyCodes().contains(keyEvent.getCode());
    }
}
