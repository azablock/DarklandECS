package dl.entity;

import dl.Behavior.Behavior;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EntityManager {

    @NotNull
    private final List<UUID> entities;

    @NotNull
    private final Map<UUID, String> entityHumanReadableNames;

    @NotNull
    private final Map<Class<? extends Behavior>, HashMap<UUID, ? extends Behavior>> behaviorStores;

    private EntityManager() {
        entities = new ArrayList<>();
        entityHumanReadableNames = new HashMap<>();
        behaviorStores = new HashMap<>();
    }

    public <T extends Behavior> void addBehavior(@NotNull final UUID entity,
                                                 @NotNull final T behavior) {
        HashMap<UUID, ? extends Behavior> store = behaviorStores.get(behavior.getClass());

        if (store == null) {
            store = new HashMap<>();
            behaviorStores.put(behavior.getClass(), store);
        }

        if (hasBehavior(entity, behavior.getClass()))
            throw new RuntimeException("Entity has already behavior of type " + behavior.getClass().getSimpleName());

        ((HashMap<UUID, T>) store).put(entity, behavior);
    }

    @NotNull
    public <T extends Behavior> T getBehavior(@NotNull final UUID entity,
                                              @NotNull final Class<T> behaviorType) {
        HashMap<UUID, ? extends Behavior> store = behaviorStores.get(behaviorType);

        if (store == null)
            throw new RuntimeException("There is no such key (behavior) of class " + behaviorType.getSimpleName() + " in the behaviorStores");

        if (store.get(entity) == null)
            throw new RuntimeException("Entity does not have behavior of class " + behaviorType.getSimpleName() + " in " + nameFor(entity));

        return (T) store.get(entity);
    }

    public <T extends Behavior> void removeBehavior(@NotNull final UUID entity,
                                                    @NotNull final T behavior) {
        HashMap<UUID, ? extends Behavior> store = behaviorStores.get(behavior.getClass());

        if (store == null)
            throw new RuntimeException("There are no entities with behavior of class " + behavior.getClass());

        T result = (T) store.remove(entity);
        if (result == null)
            throw new RuntimeException(nameFor(entity) + " does not possess behavior of class\n\tmissing: " + behavior.getClass());

        store.remove(entity, behavior);
    }

    public <T extends Behavior> void removeBehavior(@NotNull final UUID entity,
                                                    @NotNull final Class<T> behaviorType) {
        HashMap<UUID, ? extends Behavior> store = behaviorStores.get(behaviorType);

        if (store == null)
            throw new RuntimeException("There are no entities with behavior of class " + behaviorType);

        T result = (T) store.get(entity);
        if (result == null)
            throw new RuntimeException(nameFor(entity) + " does not possess behavior of class\n\tmissing: " + behaviorType);

        store.remove(entity, getBehavior(entity, behaviorType));
    }

    public <T extends Behavior> boolean hasBehavior(@NotNull final UUID entity,
                                                    @NotNull final Class<T> behaviorType) {
        Collection<Behavior> behaviors = allBehaviorsOfEntity(entity);
        boolean hasBehavior = false;

        for (Behavior Behavior : behaviors)
            if (Behavior.getClass() == behaviorType) {
                hasBehavior = true;
                break;
            }

        return hasBehavior;
    }

    @NotNull
    public <T extends Behavior> List<T> allBehaviorsOfEntity(@NotNull final UUID entity) {
        List<T> behaviors = new LinkedList<>();

        behaviorStores.values().forEach(store -> {
            T BehaviorFromThisEntity = (T) store.get(entity);
            if (BehaviorFromThisEntity != null)
                behaviors.add(BehaviorFromThisEntity);
        });

        return behaviors;
    }

    @NotNull
    public <T extends Behavior> Collection<T> allBehaviorsOfType(@NotNull final Class<T> behaviorType) {
        HashMap<UUID, ? extends Behavior> store = behaviorStores.get(behaviorType);

        if (store == null)
            return new LinkedList<>();

        return (Collection<T>) store.values();
    }

    @NotNull
    public <T extends Behavior> Set<UUID> entitiesPossessingBehavior(@NotNull final Class<T> behaviorType) {
        Set<UUID> allEntitiesPossessingBehavior = new HashSet<>();

        allBehaviorsOfType(behaviorType).forEach(
                behavior -> allEntitiesPossessingBehavior.addAll(behaviorStores.get(behavior.getClass()).keySet()));

        return allEntitiesPossessingBehavior;
    }

    @NotNull
    public Set<UUID> entitiesPossessingBehaviors(@NotNull final Set<Class<? extends Behavior>> behaviors) {
        Set<UUID> withGivenBehaviors = new HashSet<>();

        behaviors.forEach(Behavior ->
                entities.stream().filter(entity ->
                        behaviorStores.get(Behavior).containsKey(entity)).forEach(withGivenBehaviors::add));

        return withGivenBehaviors;
    }

    @NotNull
    public Integer behaviorCount() {
        int behaviorCount = 0;
        List<Integer> behaviorStoreSizes = new ArrayList<>();

        behaviorStores.forEach((aClass, BehaviorStore) -> behaviorStoreSizes.add(BehaviorStore.size()));

        for (Integer size : behaviorStoreSizes)
            behaviorCount += size;

        return behaviorCount;
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
        behaviorStores.values().forEach(store -> {
            if (store.containsKey(entity))
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