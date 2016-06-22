package event;

import org.jetbrains.annotations.NotNull;

public interface Event {

    @NotNull
    String name();

    @NotNull
    String description();
}
