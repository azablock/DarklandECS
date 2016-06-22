package game_world;

import component.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

import static entity.EntityManager.ENTITY_MANAGER;

public class GameObject {

    @NotNull
    private final UUID entity;

    @Nullable
    private String humanReadableName = null;

    private GameObject(@NotNull final UUID entity, @NotNull final String humanReadableName) {
        this.entity = entity;
        this.humanReadableName = humanReadableName;
    }

    private GameObject() {
        entity = ENTITY_MANAGER.createEntity();
    }

    public GameObject(@NotNull final String internalName) {
        entity = ENTITY_MANAGER.createEntity(internalName);
    }

    public GameObject(@NotNull final Component... components) {
        this();

        for (Component component : components)
            this.add(component);
    }

    public GameObject(@NotNull final String internalName, @NotNull final Component... components) {
        entity = ENTITY_MANAGER.createEntity(internalName);

        for (Component component : components)
            this.add(component);
    }

    @NotNull
    public static GameObject load(@NotNull final UUID entity) {
        return new GameObject(entity, ENTITY_MANAGER.nameFor(entity));
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
    public String getInternalName() {
        return humanReadableName != null ? humanReadableName : "no humanReadableName";
    }
}