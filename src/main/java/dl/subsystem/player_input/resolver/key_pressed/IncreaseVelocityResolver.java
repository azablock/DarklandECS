package dl.subsystem.player_input.resolver.key_pressed;

import dl.behavior.Intelligence;
import dl.behavior.PlayerInput;
import dl.subsystem.Resolver;
import dl.subsystem.player_input.resolver.key_pressed.helper.DirectionByEventCodeHelper;
import dl.subsystem.player_input.resolver.key_pressed.validator.HasKeyEventsValidator;
import dl.subsystem.player_input.resolver.key_pressed.validator.ProperKeyCodeValidator;
import javafx.scene.input.KeyEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.UUID;

@Component
public class IncreaseVelocityResolver extends Resolver {

    @NotNull
    private static final Logger LOG = LoggerFactory.getLogger(IncreaseVelocityResolver.class);

    @Autowired
    private HasKeyEventsValidator hasKeyEventsValidator;

    @Autowired
    private ProperKeyCodeValidator properKeyCodeValidator;

    @Autowired
    private DirectionByEventCodeHelper directionByEventCodeHelper;

    @PostConstruct
    private void init() {
        validators.get().addAll(Arrays.asList(
                hasKeyEventsValidator,
                properKeyCodeValidator
        ));
    }

    @Override
    public void resolve(@NotNull UUID entity) {
        PlayerInput playerInput = entityManager.getBehavior(entity, PlayerInput.class);
        Intelligence intelligence = entityManager.getBehavior(entity, Intelligence.class);
        KeyEvent keyEvent = playerInput.keyboardEvents.removeFirst();

        //fixme nie wiem czy to dorbe jest
        intelligence.actions.get("keyPressed").actionCount++;

        LOG.debug(entityManager.nameFor(entity) + " pressed " + keyEvent.getCode());
    }

    @Override
    public void reject(@NotNull UUID entity) {
        LinkedList<KeyEvent> keyboardEvents = entityManager.getBehavior(entity, PlayerInput.class).keyboardEvents;

        if (!keyboardEvents.isEmpty()) {
            KeyEvent keyEvent = keyboardEvents.removeFirst();
            LOG.debug("invalid keycode: " + keyEvent.getCode());
        }
    }
}

