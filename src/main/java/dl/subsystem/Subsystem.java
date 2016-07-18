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

    @Autowired
    protected EntityManager em;

    @NotNull
    protected final Set<Class<? extends Behavior>> requiredBehaviorTypes;

    @NotNull
    protected final Set<Resolver> resolvers;

    protected Subsystem() {
        // TODO: 6/22/2016 pobieranie componentTypes z JSON
//        requiredBehaviorTypes = new HashSet<>(SubsystemInitializerService.initialize(this.getClass().getName()));
        requiredBehaviorTypes = new HashSet<>();
        resolvers = new HashSet<>();
    }

    public final void update() {
        em.entitiesPossessingBehaviors(requiredBehaviorTypes)
                .stream()
                .forEach(this::process);
    }

    private void process(@NotNull final UUID entity) {
        resolvers.stream()
                .forEach(resolver -> resolver.handle(entity));
    }

    @Override
    public final String toString() {
        return String.valueOf(this.getClass());
    }
}
