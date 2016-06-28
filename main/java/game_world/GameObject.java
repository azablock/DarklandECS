package game_world;

import component.Component;
import entity.EntityManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

import static entity.EntityManager.*;

public class GameObject {

    @NotNull
    private final UUID entity;

    private GameObject(@NotNull final UUID entity) {
        this.entity = entity;
    }

    @NotNull
    public static GameObject load(@NotNull final UUID entity) {
        return new GameObject(entity);
    }

    public GameObject(@NotNull final String humanReadableName) {
        entity = ENTITY_MANAGER.createEntity(humanReadableName);
    }

    public GameObject(@NotNull final Component... components) {
        entity = ENTITY_MANAGER.createEntity();

        for (Component component : components)
            this.add(component);
    }

    public GameObject(@NotNull final String humanReadableName, @NotNull final Component... components) {
        entity = ENTITY_MANAGER.createEntity(humanReadableName);

        for (Component component : components)
            this.add(component);
    }

    public void add(@NotNull final Component component) {
        ENTITY_MANAGER.addComponent(entity, component);
    }

    public void addAll(@NotNull final Component... components) {
        for (Component component : components)
            ENTITY_MANAGER.addComponent(entity, component);
    }

    @NotNull
    public <T extends Component> T get(@NotNull final Class<T> componentType) {
        return ENTITY_MANAGER.getComponent(entity, componentType);
    }

    public <T extends Component> boolean has(@NotNull final Class<T> componentType) {
        return ENTITY_MANAGER.hasComponent(entity, componentType);
    }

    public void remove(@NotNull final Component component) {
        ENTITY_MANAGER.removeComponent(entity, component);
    }

    public <T extends Component> void remove(@NotNull final Class<T> componentType) {
        ENTITY_MANAGER.removeComponent(entity, componentType);
    }

    @NotNull
    public List<? extends Component> getAll() {
        return ENTITY_MANAGER.allComponentsOfEntity(entity);
    }

    public void removeAll() {
        getAll().forEach(this::remove);
    }

    public void kill() {
        ENTITY_MANAGER.killEntity(entity);
    }

    @NotNull
    public UUID entity() {
        return entity;
    }

    @NotNull
    public String humanReadableName() {
        String humanReadableName = ENTITY_MANAGER.nameFor(entity);
        return humanReadableName != null ? humanReadableName : "no humanReadableName";
    }
}