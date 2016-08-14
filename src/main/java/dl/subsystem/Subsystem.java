package dl.subsystem;

import dl.behavior.Behavior;
import dl.entity.EntityManager;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
public abstract class Subsystem {

    @NotNull
    protected final Set<Resolver> resolvers = new HashSet<>();

    @Autowired
    protected EntityManager entityManager;

    public final void update() {
        entityManager
                .entitiesPossessingBehaviors(requiredBehaviorTypes())
                .stream()
                .forEach(this::process);
    }

    private void process(@NotNull final UUID entity) {
        resolvers
                .stream()
                .forEach(resolver -> resolver.handle(entity));
    }

    public Set<Class<? extends Behavior>> requiredBehaviorTypes() {
        Set<Class<? extends Behavior>> behaviorTypes = new HashSet<>();

        resolvers
                .stream()
                .forEach(resolver -> behaviorTypes.addAll(resolver.requiredBehaviorTypes()));

        return behaviorTypes;
    }

    @Override
    public final String toString() {
        return String.valueOf(this.getClass());
    }
}
