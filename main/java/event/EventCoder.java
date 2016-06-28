package event;

import component.Component;
import org.jetbrains.annotations.NotNull;

@Deprecated
public interface EventCoder<T extends Component> {

    @NotNull
    String code(@NotNull T component);
}
