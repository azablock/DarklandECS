package dl.subsystem;

import dl.behavior.Behavior;
import dl.entity.EntityManager;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
public abstract class Validator {

    @Autowired
    protected EntityManager entityManager;

    public abstract boolean validate(@NotNull final UUID entity);

    public abstract Set<Class<? extends Behavior>> requiredBehaviorTypes();
}
