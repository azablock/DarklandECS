package event;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Deprecated
public interface Event {

    @NotNull
    UUID entity();

    @NotNull
    String name();

    @NotNull
    String description();
}
