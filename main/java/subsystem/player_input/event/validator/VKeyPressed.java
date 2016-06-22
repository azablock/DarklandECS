package subsystem.player_input.event.validator;

import component.CPlayerInput;
import event.EventValidator;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class VKeyPressed implements EventValidator<CPlayerInput> {

    @Override
    public Predicate<CPlayerInput> predicate(@NotNull final CPlayerInput component) {
        return cPlayerInput -> !cPlayerInput.keyboardEvents.isEmpty();
    }
}
