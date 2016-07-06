package dl.subsystem.player_input.resolver.key_pressed.validator;

import dl.Behavior.BPlayerInput;
import dl.subsystem.Validator;
import dl.game_world.GameObject;
import org.jetbrains.annotations.NotNull;

public class VHasKeyEvents implements Validator {
    @Override
    public boolean validate(@NotNull GameObject gameObject) {
        BPlayerInput cPlayerInput = gameObject.get(BPlayerInput.class);

        return !cPlayerInput.keyboardEvents.isEmpty();
    }
}
