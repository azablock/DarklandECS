package dl.subsystem;

import com.google.common.collect.ImmutableList;
import dl.entity.EntityManager;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.of;

@Component
public abstract class Resolver {

    @Autowired
    protected EntityManager entityManager;

    protected final Optional<List<Validator>> validators;

    protected Resolver() {
        validators = of(new ArrayList<>());
    }

    public abstract void resolve(@NotNull final UUID entity);

    public void reject(@NotNull final UUID entity) {}

    public final void handle(@NotNull final UUID entity) {
        if (passedValidation(entity))
            resolve(entity);
        else
            reject(entity);
    }

    public final boolean passedValidation(@NotNull final UUID entity) {
        List<Validator> validators = validators();

        return validators
                .stream()
                .allMatch(validator -> validator.validate(entity));
    }

    public final List<Validator> validators() {
        return ImmutableList.copyOf(validators.get());
    }
}
