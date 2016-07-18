package dl.subsystem;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface Validator {

    boolean validate(@NotNull final UUID entity);
}
