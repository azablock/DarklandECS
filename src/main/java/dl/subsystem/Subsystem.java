package dl.subsystem;

import dl.Behavior.Behavior;
import dl.entity.EntityManager;
import dl.game_world.GameObject;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public abstract class Subsystem implements Initializable {

    @Autowired
    private EntityManager entityManager;

    @NotNull
    public final Set<Class<? extends Behavior>> requiredBehaviorTypes;

    @NotNull
    public final Set<Resolver> resolvers;

    protected Subsystem() {
        // TODO: 6/22/2016 pobieranie componentTypes z JSON
//        requiredBehaviorTypes = new HashSet<>(SubsystemInitializerService.initialize(this.getClass().getName()));
        requiredBehaviorTypes = new HashSet<>();
        resolvers = new HashSet<>();
        initialize();
    }

    public final void update() {
        entityManager
                .entitiesPossessingBehaviors(requiredBehaviorTypes)
                .stream()
                .map(GameObject::load)
                .forEach(this::process);
    }

    private void process(@NotNull final GameObject gameObject) {
        resolvers
                .stream()
                .filter(resolver -> resolver.passedValidation(gameObject))
                .forEach(validatedResolver -> validatedResolver.resolve(gameObject));
    }

    @Override
    public final String toString() {
        return String.valueOf(this.getClass());
    }
}
