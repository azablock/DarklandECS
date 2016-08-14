package dl.subsystem.ai.resolver.speak.validator;

import dl.behavior.Behavior;
import dl.behavior.Intelligence;
import dl.subsystem.Validator;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class HasActionsToPerformValidator extends Validator {

    @Override
    public boolean validate(@NotNull UUID entity) {
//        AI bAI = entityManager.getBehavior(entity, AI.class);
//
//        return !bAI.actions.isEmpty();
        return true;
    }

    @Override
    public Set<Class<? extends Behavior>> requiredBehaviorTypes() {
        return new HashSet<>(Arrays.asList(
                Intelligence.class
        ));
    }
}
