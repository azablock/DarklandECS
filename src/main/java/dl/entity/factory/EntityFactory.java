package dl.entity.factory;

import dl.behavior.Behavior;
import dl.entity.EntityManager;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
public abstract class EntityFactory {

    @Autowired
    protected EntityManager em;

    public final UUID newInstance() {
        UUID entity = em.createEntity(of());
        behaviorSignature()
                .forEach(behavior -> em.addBehavior(entity, behavior));

        return entity;
    }

    @NotNull
    public abstract Set<Behavior> behaviorSignature();

    @NotNull
    public abstract String of();
}
