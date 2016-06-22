package event;

import component.Component;
import org.jetbrains.annotations.NotNull;

public interface ComponentDataTransformer<T extends Component> {

    @NotNull
    String transform(@NotNull T component);
}
