package dl.subsystem.ai.resolver.speak;

import dl.subsystem.Resolver;
import dl.subsystem.ai.resolver.speak.validator.HasActionsToPerformValidator;
import dl.subsystem.ai.resolver.speak.validator.StartedSpeakingValidator;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.UUID;

@Component
public class SpeakResolver extends Resolver {

    @NotNull
    private static final Logger LOG = LoggerFactory.getLogger(SpeakResolver.class);

    @Autowired
    private StartedSpeakingValidator startedSpeakingValidator;

    @Autowired
    private HasActionsToPerformValidator hasActionsToPerformValidator;

    @PostConstruct
    private void init() {
        validators.get().addAll(Arrays.asList(
                startedSpeakingValidator,
                hasActionsToPerformValidator
        ));
    }

    @Override
    public void resolve(@NotNull UUID entity) {
//        AI bAI = entityManager.getBehavior(entity, AI.class);
//
//        LOG.debug(entityManager.nameFor(entity) + " is performing action <" + bAI.actions.removeFirst() + ">");
    }

    @Override
    public void reject(@NotNull UUID entity) {
//        AI bAI = entityManager.getBehavior(entity, AI.class);
//
//        bAI.timeline.play();
    }
}
