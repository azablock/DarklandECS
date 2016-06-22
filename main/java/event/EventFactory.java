package event;

import component.Component;
import org.jetbrains.annotations.NotNull;

public interface EventFactory<T extends Component> {

    @NotNull
    String eventName();

    @NotNull
    default Event newEvent(@NotNull final T component) {
        return new Event() {
            @NotNull
            @Override
            public String name() {
                return eventName();
            }

            @NotNull
            @Override
            public String description() {
                return String.format("Event %s [%s]", eventName(), componentDataTransformer().transform(component));
            }
        };
    };

    @NotNull
    ComponentDataTransformer<T> componentDataTransformer();
}
