package system;

import component.Component;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static entity.EntityManager.ENTITY_MANAGER;

public abstract class Subsystem {

    @NotNull
    public final Set<Class<? extends Component>> componentTypes;

    protected Subsystem(@NotNull final Class<? extends Component>... componentTypes) {
        this.componentTypes = new HashSet<>(Arrays.asList(componentTypes));
    }

    @NotNull
    public final Set<Class<? extends Component>> requiredComponentTypes() {
        return componentTypes;
    }

    public final void update() {
        ENTITY_MANAGER.entitiesPossessingComponents(requiredComponentTypes()).forEach(this::process);
    }

    public abstract void process(@NotNull final UUID entity);

    @Override
    public final String toString() {
        return String.valueOf(this.getClass());
    }
}
