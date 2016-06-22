package subsystem.player_input;

import component.CPlayerInput;
import component.CPosition;
import game_world.GameObject;
import org.jetbrains.annotations.NotNull;
import subsystem.Subsystem;
import subsystem.player_input.event.resolver.RKeyPressed;
import subsystem.player_input.event.validator.VKeyPressed;

public class SPlayerInput extends Subsystem {

    public SPlayerInput() {
        super();
        this.requiredComponentTypes.add(CPlayerInput.class);
        this.requiredComponentTypes.add(CPosition.class);
    }

    @Override
    public void process(@NotNull GameObject gameObject) {
        CPlayerInput cPlayerInput = gameObject.get(CPlayerInput.class);

        if (new VKeyPressed().validate(cPlayerInput)) {
            new RKeyPressed().resolve(gameObject, cPlayerInput);
        }
    }
}
