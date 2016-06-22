package subsystem;

import component.Component;
import game_world.GameObject;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

import static entity.EntityManager.ENTITY_MANAGER;

public abstract class Subsystem {

    @NotNull
    public final Set<Class<? extends Component>> requiredComponentTypes;

    @NotNull
    public final Set<Class<? extends Component>> eventTypesToResolve;

    protected Subsystem() {
        // TODO: 6/22/2016 pobieranie componentTypes z JSON
//        requiredComponentTypes = new HashSet<>(SubsystemInitializerService.initialize(this.getClass().getName()));
        requiredComponentTypes = new HashSet<>();
        eventTypesToResolve = new HashSet<>();
    }

    public final void update() {
        ENTITY_MANAGER
                .entitiesPossessingComponents(requiredComponentTypes)
                .stream()
                .map(GameObject::load)
                .forEach(this::process);
    }

    public abstract void process(@NotNull final GameObject gameObject);

    @Override
    public final String toString() {
        return String.valueOf(this.getClass());
    }
}
