package event;

import component.Component;
import game_world.GameObject;
import org.jetbrains.annotations.NotNull;

public interface EventResolver<T extends Component> {

    void resolve(@NotNull final GameObject gameObject, @NotNull final T component);
}
