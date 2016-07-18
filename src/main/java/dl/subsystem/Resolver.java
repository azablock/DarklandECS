package dl.subsystem;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface Resolver {

    void resolve(@NotNull final UUID entity);

    void reject(@NotNull final UUID entity);

    default void handle(@NotNull final UUID entity) {
        if (passedValidation(entity))
            resolve(entity);
        else
            reject(entity);
    }

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
