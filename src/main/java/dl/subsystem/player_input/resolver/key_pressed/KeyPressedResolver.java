package dl.subsystem.player_input.resolver.key_pressed;

import dl.behavior.PlayerInput;
import dl.behavior.Velocity;
import dl.subsystem.Resolver;
import dl.subsystem.player_input.resolver.key_pressed.helper.VelocityMagnitudeHelper;
import dl.subsystem.player_input.resolver.key_pressed.validator.HasKeyEventsValidator;
import dl.subsystem.player_input.resolver.key_pressed.validator.ProperKeyCodeValidator;
import javafx.geometry.Point2D;
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
public class KeyPressedResolver extends Resolver {

    @NotNull
    private static final Logger LOG = LoggerFactory.getLogger(KeyPressedResolver.class);

    @Autowired
    private HasKeyEventsValidator hasKeyEventsValidator;

    @Autowired
    private ProperKeyCodeValidator properKeyCodeValidator;

    @Autowired
    private VelocityMagnitudeHelper velocityMagnitudeHelper;

    @PostConstruct
    private void init() {
        validators.get().addAll(Arrays.asList(
                hasKeyEventsValidator,
                properKeyCodeValidator
        ));
    }

    @Override
    public void resolve(@NotNull UUID entity) {
        PlayerInput bPlayerInput = entityManager.getBehavior(entity, PlayerInput.class);
        Velocity velocity = entityManager.getBehavior(entity, Velocity.class);

        KeyEvent keyEvent = bPlayerInput.keyboardEvents.getFirst();
        Point2D movementSpeedDelta = velocity.movementSpeedDelta;

        bPlayerInput.keyboardEvents.removeFirst();
        velocity.movementSpeedDelta = movementSpeedDelta.add(velocityMagnitudeHelper.velocityFor(keyEvent.getCode()));

        LOG.debug(entityManager.nameFor(entity) + "has pressed " + keyEvent.getCode());
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

