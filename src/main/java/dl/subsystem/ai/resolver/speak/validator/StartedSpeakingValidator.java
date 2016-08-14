package dl.subsystem.ai.resolver.speak.validator;

import dl.behavior.Behavior;
import dl.behavior.Intelligence;
import dl.subsystem.Validator;
import javafx.animation.Animation;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StartedSpeakingValidator extends Validator {

    @Override
    public boolean validate(@NotNull UUID entity) {
//        Intelligence intelligence = entityManager.getBehavior(entity, Intelligence.class);
//
//        return intelligence
//                .actions.get("speak")
//                .timeline.getStatus().equals(Animation.Status.RUNNING);
        return true;
    }

    @Override
    public Set<Class<? extends Behavior>> requiredBehaviorTypes() {
        return new HashSet<>(Arrays.asList(
                Intelligence.class
        ));
    }
}
