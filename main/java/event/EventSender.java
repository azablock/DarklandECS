package event;

import component.Component;
import game_world.GameObject;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Deprecated
public interface EventSender<T extends Component> {

    @NotNull
    String eventName();

    @NotNull
    default Event send(@NotNull GameObject gameObject, @NotNull final T component) {
        return new Event() {
            @NotNull
            @Override
            public UUID entity() {
                return gameObject.entity();
            }

            @NotNull
            @Override
            public String name() {
                return eventName();
            }

            @NotNull
            @Override
            public String description() {
                return String.format("Event %s [%s]", eventName(), eventCoder().code(component));
            }
        };
    }

    EventCoder<T> eventCoder();
}
