package dl.subsystem;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import dl.behavior.Behavior;
import dl.entity.EntityManager;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import static java.util.Optional.of;

@Component
public abstract class Resolver {

    @Autowired
    protected EntityManager entityManager;

    protected final Optional<List<Validator>> validators = of(new ArrayList<>());

    public abstract void resolve(@NotNull final UUID entity);

    public void reject(@NotNull final UUID entity) {}

    public final void handle(@NotNull final UUID entity) {
        if (passedValidation(entity))
            resolve(entity);
        else
            reject(entity);
    }

    public final boolean passedValidation(@NotNull final UUID entity) {
        return validators()
                .stream()
                .allMatch(validator -> validator.validate(entity));
    }

    public final List<Validator> validators() {
        return ImmutableList.copyOf(validators.get());
    }

    public final Set<Class<? extends Behavior>> requiredBehaviorTypes() {
        return Sets.union(ownRequiredBehaviorTypes(), requiredBehaviorTypesFromValidators());
    }

    protected Set<Class<? extends Behavior>> ownRequiredBehaviorTypes() {
        return new HashSet<>();
    }

    private Set<Class<? extends Behavior>> requiredBehaviorTypesFromValidators() {
        Set<Class<? extends Behavior>> fromValidators = new HashSet<>();

        validators()
                .stream()
                .forEach(validator -> fromValidators.addAll(validator.requiredBehaviorTypes()));

        return fromValidators;
    }

}
