package dl.subsystem.ai.resolver.speak.validator;

import dl.behavior.AI;
import dl.subsystem.Validator;
import javafx.animation.Animation;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StartedSpeakingValidator extends Validator {

    @Override
    public boolean validate(@NotNull UUID entity) {
        AI bAI = entityManager.getBehavior(entity, AI.class);

        return bAI.timeline.getStatus().equals(Animation.Status.RUNNING);
    }
}
