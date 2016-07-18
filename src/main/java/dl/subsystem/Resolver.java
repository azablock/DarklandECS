package dl.subsystem;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public interface Resolver {

    void resolve(@NotNull final UUID entity);

    @Nullable
    default List<Validator> validators() {
        return null;
    }

    default boolean passedValidation(@NotNull final UUID entity) {
        List<Validator> validators = validators();
        return validators == null ||
                validators
                        .stream()
                        .allMatch(validator -> validator.validate(entity));
    }
}
