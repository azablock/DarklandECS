package entity;

import component.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class EntityManager {

    @NotNull
    public final static EntityManager ENTITY_MANAGER = new EntityManager();

    @NotNull
    private final List<UUID> entities;

    @NotNull
    private final Map<UUID, String> entityHumanReadableNames;

    @NotNull
    private final Map<Class<? extends Component>, HashMap<UUID, ? extends Component>> componentStores;

    private EntityManager() {
        entities = new ArrayList<>();
        entityHumanReadableNames = new HashMap<>();
        componentStores = new HashMap<>();
    }

    public <T extends Component> void addComponent(@NotNull final UUID entity,
                                                   @NotNull final T component) {
        HashMap<UUID, ? extends Component> store = componentStores.get(component.getClass());

        if(store == null) {
            store = new HashMap<>();
            componentStores.put(component.getClass(), store);
        }

        ((HashMap<UUID, T>) store).put(entity, component);
    }

    @NotNull
    public <T extends Component> T getComponent(@NotNull final UUID entity,
                                                @NotNull final Class<T> componentType) {
        HashMap<UUID, ? extends Component> store = componentStores.get(componentType);

        if(store == null)
            throw new RuntimeException("There is no such key (component) of class " + componentType + " in the componentStores");

        if(store.get(entity) == null)
            throw new RuntimeException("There is no component of class " + componentType + " in " + nameFor(entity));

        return (T) store.get(entity);
    }

    public <T extends Component> void removeComponent(@NotNull final UUID entity,
                                                      @NotNull final T component) {
        HashMap<UUID, ? extends Component> store = componentStores.get(component.getClass());

        if(store == null)
            throw new RuntimeException("There are no entities with component of class " + component.getClass());

        T result = (T) store.remove(entity);
        if(result == null)
            throw new RuntimeException(nameFor(entity) + " does not possess component of class\n\tmissing: " + component.getClass());

        store.remove(entity, component);
    }

    public <T extends Component> void removeComponent(@NotNull final UUID entity,
                                                      @NotNull final Class<T> componentType) {
        HashMap<UUID, ? extends Component> store = componentStores.get(componentType);

        if(store == null)
            throw new RuntimeException("There are no entities with component of class " + componentType);

        T result = (T) store.remove(entity);
        if(result == null)
            throw new RuntimeException(nameFor(entity) + " does not possess component of class\n\tmissing: " + componentType);

        store.remove(entity, getComponent(entity, componentType));
    }

    public <T extends Component> boolean hasComponent(@NotNull final UUID entity,
                                                      @NotNull final Class<T> componentType) {
        Collection<Component> components = allComponentsOfEntity(entity);
        boolean hasComponent = false;

        for (Component component : components)
            if(component.getClass() == componentType) {
                hasComponent = true;
                break;
            }

        return hasComponent;
    }

    @NotNull
    public <T extends Component> List<T> allComponentsOfEntity(@NotNull final UUID entity) {
        List<T> components = new LinkedList<>();

        componentStores.values().forEach(store -> {
            T componentFromThisEntity = (T) store.get(entity);
            if(componentFromThisEntity != null)
                components.add(componentFromThisEntity);
        });

        return components;
    }

    @NotNull
    public <T extends Component> Collection<T> allComponentsOfType(@NotNull final Class<T> componentType) {
        HashMap<UUID, ? extends Component> store = componentStores.get(componentType);

        if(store == null)
            return new LinkedList<>();

        return (Collection<T>) store.values();
    }

    @NotNull
    public <T extends Component> Set<UUID> entitiesPossessingComponent(@NotNull final Class<T> componentType) {
        Set<UUID> allEntitiesPossessingComponent = new HashSet<>();

        allComponentsOfType(componentType).forEach(
                component -> allEntitiesPossessingComponent.addAll(componentStores.get(component.getClass()).keySet()));

        return allEntitiesPossessingComponent;
    }

    @NotNull
    public Set<UUID> entitiesPossessingComponents(@NotNull final Set<Class<? extends Component>> components) {
        Set<UUID> withGivenComponents = new HashSet<>();

        components.forEach(component ->
                entities.stream().filter(entity ->
                        componentStores.get(component).containsKey(entity)).forEach(withGivenComponents::add));

        return withGivenComponents;
    }

    @NotNull
    public Integer componentCount() {
        int componentCount = 0;
        List<Integer> componentStoreSizes = new ArrayList<>();

        componentStores.forEach((aClass, componentStore) -> componentStoreSizes.add(componentStore.size()));

        for (Integer size : componentStoreSizes)
            componentCount += size;

        return componentCount;
    }

    @NotNull
    public Integer entityCount() {
        return entities.size();
    }

    @NotNull
    public UUID createEntity() {
        final UUID uuid = UUID.randomUUID();

        entities.add(uuid);

        return uuid;
    }

    @NotNull
    public UUID createEntity(@NotNull final String entityName) {
        final UUID uuid = UUID.randomUUID();

        entities.add(uuid);
        entityHumanReadableNames.put(uuid, entityName);

        return uuid;
    }

    public void killEntity(@NotNull final UUID entity) {
        componentStores.values().forEach(store -> {
            if(store.containsKey(entity))
                store.remove(entity);
        });

        entities.remove(entity);
    }

    public void setEntityName(@NotNull final UUID entity,
                              @NotNull final String name) {
        entityHumanReadableNames.put(entity, name);
    }

    @Nullable
    public String nameFor(@NotNull final UUID uuid) {
        return entityHumanReadableNames.get(uuid);
    }
}