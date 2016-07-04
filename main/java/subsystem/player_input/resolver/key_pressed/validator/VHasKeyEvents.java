package subsystem.player_input.resolver.key_pressed.validator;

import component.CPlayerInput;
import subsystem.Validator;
import game_world.GameObject;
import org.jetbrains.annotations.NotNull;

public class VHasKeyEvents implements Validator {
    @Override
    public boolean validate(@NotNull GameObject gameObject) {
        CPlayerInput cPlayerInput = gameObject.get(CPlayerInput.class);

        return !cPlayerInput.keyboardEvents.isEmpty();
    }
}
