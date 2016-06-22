package subsystem.movement.resolver;

import event.Event;
import game_world.GameObject;
import org.jetbrains.annotations.NotNull;

public class RMovement implements EventResolver {

    @Override
    public void resolve(@NotNull GameObject gameObject, @NotNull Event event) {

    }

    @NotNull
    @Override
    public String isDedicatedFor(@NotNull String eventName) {
        return "";
    }
}
