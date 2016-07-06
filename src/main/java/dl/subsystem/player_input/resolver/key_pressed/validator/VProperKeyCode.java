package dl.subsystem.player_input.resolver.key_pressed.validator;

import dl.Behavior.BPlayerInput;
import dl.subsystem.Validator;
import dl.game_world.GameObject;
import javafx.scene.input.KeyEvent;
import org.jetbrains.annotations.NotNull;

import static dl.subsystem.player_input.resolver.key_pressed.helper.HVelocityMagnitude.H_VELOCITY_MAGNITUDE;

public class VProperKeyCode implements Validator {

    @Override
    public boolean validate(@NotNull GameObject gameObject) {
        BPlayerInput cPlayerInput = gameObject.get(BPlayerInput.class);
        KeyEvent keyEvent = cPlayerInput.keyboardEvents.getFirst();

        return H_VELOCITY_MAGNITUDE.properKeyCodes().contains(keyEvent.getCode());
    }
}
