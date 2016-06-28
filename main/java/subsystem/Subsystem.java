package subsystem;

import component.Component;
import event.Resolver;
import game_world.GameObject;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static entity.EntityManager.ENTITY_MANAGER;

public abstract class Subsystem {

    @NotNull
    public final Set<Class<? extends Component>> requiredComponentTypes;

    @NotNull
    public final Map<Class<? extends Resolver>, Resolver> resolvers;

    protected Subsystem() {
        // TODO: 6/22/2016 pobieranie componentTypes z JSON
//        requiredComponentTypes = new HashSet<>(SubsystemInitializerService.initialize(this.getClass().getName()));
        requiredComponentTypes = new HashSet<>();
        resolvers = new HashMap<>();
    }

    public final void update() {
        ENTITY_MANAGER
                .entitiesPossessingComponents(requiredComponentTypes)
                .stream()
                .map(GameObject::load)
                .forEach(this::process);
    }

    private void process(@NotNull final GameObject gameObject) {
        resolvers
                .values()
                .stream()
                .filter(resolver -> resolver.passedValidation(gameObject))
                .forEach(validatedResolver -> validatedResolver.resolve(gameObject));
    }

    public abstract void initialize();

    @Override
    public final String toString() {
        return String.valueOf(this.getClass());
    }
}
