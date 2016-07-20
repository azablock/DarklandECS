package dl.subsystem.ai.resolver.speak;

import dl.behavior.BAI;
import dl.subsystem.ResolverAbstract;
import dl.subsystem.ai.resolver.speak.validator.VHasActionsToPerform;
import dl.subsystem.ai.resolver.speak.validator.VStartedSpeaking;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Component
public class RSpeak extends ResolverAbstract {

    @NotNull
    private static final Logger LOG = LoggerFactory.getLogger(RSpeak.class);

    @Autowired
    private VStartedSpeaking vStartedSpeaking;

    @Autowired
    private VHasActionsToPerform vHasActionsToPerform;

    @PostConstruct
    private void init() {
        validators.add(vStartedSpeaking);
        validators.add(vHasActionsToPerform);
    }

    @Override
    public void resolve(@NotNull UUID entity) {
        BAI bAI = em.getBehavior(entity, BAI.class);

        LOG.debug(em.nameFor(entity) + " is performing action <" + bAI.actions.removeFirst() + ">");
    }

    @Override
    public void reject(@NotNull UUID entity) {
        BAI bAI = em.getBehavior(entity, BAI.class);

        bAI.timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(bAI.reactionMillis),
                event -> bAI.actions.addLast("speaking")));

        bAI.timeline.play();
    }
}
