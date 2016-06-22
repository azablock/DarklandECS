package subsystem.player_input.event.resolver;

import component.CPlayerInput;
import event.EventResolver;
import game_world.GameObject;
import org.jetbrains.annotations.NotNull;
import subsystem.player_input.event.factory.EFKeyPressed;

import static event.EventManager.EVENT_MANAGER;

public class RKeyPressed implements EventResolver<CPlayerInput> {

    @Override
    public void resolve(@NotNull GameObject gameObject, @NotNull CPlayerInput component) {
        EVENT_MANAGER.receiveEvent(gameObject, new EFKeyPressed().newEvent(component));
        component.keyboardEvents.removeFirst();
    }
}
