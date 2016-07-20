package dl.subsystem.ai.resolver.speak.validator;

import dl.behavior.BAI;
import dl.subsystem.ValidatorAbstract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class VHasActionsToPerform extends ValidatorAbstract {

    @Override
    public boolean validate(@NotNull UUID entity) {
        BAI bAI = em.getBehavior(entity, BAI.class);

        return !bAI.actions.isEmpty();
    }
}
