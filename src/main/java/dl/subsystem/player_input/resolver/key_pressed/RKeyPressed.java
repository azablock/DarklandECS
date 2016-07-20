package dl.subsystem.player_input.resolver.key_pressed;

import dl.behavior.BPlayerInput;
import dl.behavior.BVelocity;
import dl.subsystem.ResolverAbstract;
import dl.subsystem.player_input.resolver.key_pressed.validator.VHasKeyEvents;
import dl.subsystem.player_input.resolver.key_pressed.validator.VProperKeyCode;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.UUID;

import static dl.subsystem.player_input.resolver.key_pressed.helper.HVelocityMagnitude.H_VELOCITY_MAGNITUDE;

@Component
public class RKeyPressed extends ResolverAbstract {

    @NotNull
    private static final Logger LOG = LoggerFactory.getLogger(RKeyPressed.class);

    @Autowired
    private VHasKeyEvents vHasKeyEvents;

    @Autowired
    private VProperKeyCode vProperKeyCode;

    @PostConstruct
    private void init() {
        validators.add(vHasKeyEvents);
        validators.add(vProperKeyCode);
    }

    @Override
    public void resolve(@NotNull UUID entity) {
        BPlayerInput bPlayerInput = em.getBehavior(entity, BPlayerInput.class);
        BVelocity bVelocity = em.getBehavior(entity, BVelocity.class);

        KeyEvent keyEvent = bPlayerInput.keyboardEvents.getFirst();
        Point2D movementSpeedDelta = bVelocity.movementSpeedDelta;

        bPlayerInput.keyboardEvents.removeFirst();
        bVelocity.movementSpeedDelta = movementSpeedDelta.add(H_VELOCITY_MAGNITUDE.velocityFor(keyEvent.getCode()));
    }

    @Override
    public void reject(@NotNull UUID entity) {
        LinkedList<KeyEvent> keyboardEvents = em.getBehavior(entity, BPlayerInput.class).keyboardEvents;

        if (!keyboardEvents.isEmpty()) {
            KeyEvent keyEvent = keyboardEvents.removeFirst();
            LOG.debug("invalid keycode: " +keyEvent.getCode());
        }
    }
}

