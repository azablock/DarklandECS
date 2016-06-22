package event;

import component.Component;
import org.jetbrains.annotations.NotNull;

public interface EventDataTransformer<T extends Component> {

    @NotNull
    T transform(@NotNull final Event event);
}
