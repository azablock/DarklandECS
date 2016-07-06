package dl.game_world;

import dl.Behavior.Behavior;
import dl.entity.EntityManager;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;


public class GameObject {

    @Autowired
    private EntityManager entityManager;

    @NotNull
    private final UUID entity;

    private GameObject(@NotNull final UUID entity) {
        this.entity = entity;
    }

    public GameObject(@NotNull final String humanReadableName) {
        entity = entityManager.createEntity(humanReadableName);
    }

    public GameObject(@NotNull final Behavior... Behaviors) {
        entity = entityManager.createEntity();

        for (Behavior Behavior : Behaviors)
            this.add(Behavior);
    }

    public GameObject(@NotNull final String humanReadableName, @NotNull final Behavior... Behaviors) {
        entity = entityManager.createEntity(humanReadableName);

        for (Behavior Behavior : Behaviors)
            this.add(Behavior);
    }

    @NotNull
    public static GameObject load(@NotNull final UUID entity) {
        return new GameObject(entity);
    }

    public void add(@NotNull final Behavior Behavior) {
        entityManager.addBehavior(entity, Behavior);
    }

    public void addAll(@NotNull final Behavior... Behaviors) {
        for (Behavior Behavior : Behaviors)
            entityManager.addBehavior(entity, Behavior);
    }

    @NotNull
    public <T extends Behavior> T get(@NotNull final Class<T> BehaviorType) {
        return entityManager.getBehavior(entity, BehaviorType);
    }

    public <T extends Behavior> boolean has(@NotNull final Class<T> BehaviorType) {
        return entityManager.hasBehavior(entity, BehaviorType);
    }

    public void remove(@NotNull final Behavior Behavior) {
        entityManager.removeBehavior(entity, Behavior);
    }

    public <T extends Behavior> void remove(@NotNull final Class<T> BehaviorType) {
        entityManager.removeBehavior(entity, BehaviorType);
    }

    @NotNull
    public List<? extends Behavior> getAll() {
        return entityManager.allBehaviorsOfEntity(entity);
    }

    public void removeAll() {
        getAll().forEach(this::remove);
    }

    public void kill() {
        entityManager.killEntity(entity);
    }

    @NotNull
    public UUID entity() {
        return entity;
    }

    @NotNull
    public String humanReadableName() {
        String humanReadableName = entityManager.nameFor(entity);
        return humanReadableName != null ? humanReadableName : "no humanReadableName";
    }
}