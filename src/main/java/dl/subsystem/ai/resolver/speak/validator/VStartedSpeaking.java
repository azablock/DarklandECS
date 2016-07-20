package dl.subsystem.ai.resolver.speak.validator;

import dl.behavior.BAI;
import dl.subsystem.ValidatorAbstract;
import javafx.animation.Animation;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class VStartedSpeaking extends ValidatorAbstract {

    @Override
    public boolean validate(@NotNull UUID entity) {
        BAI bAI = em.getBehavior(entity, BAI.class);

        return bAI.timeline.getStatus().equals(Animation.Status.RUNNING);
    }
}
