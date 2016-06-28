package event;

import game_world.GameObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface Resolver {

    void resolve(@NotNull final GameObject gameObject);

    @Nullable
    default List<Validator> validators() {
        return null;
    }

    default boolean passedValidation(@NotNull final GameObject gameObject) {
        List<Validator> validators = validators();
        return validators == null ||
                validators
                        .stream()
                        .allMatch(validator -> validator.validate(gameObject));
    }
}
