package event;

import component.Component;
import org.jetbrains.annotations.NotNull;


@Deprecated
public interface EventDecoder<T extends Component> {

    @NotNull
    T decode(@NotNull final Event event);
}
