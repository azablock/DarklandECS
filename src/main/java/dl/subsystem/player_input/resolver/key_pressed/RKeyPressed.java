package dl.subsystem.player_input.resolver.key_pressed;

import com.google.common.collect.ImmutableList;
import dl.behavior.BPlayerInput;
import dl.behavior.BVelocity;
import dl.entity.EntityManager;
import javafx.geometry.Point2D;
import dl.subsystem.Resolver;
import dl.subsystem.Validator;
import javafx.scene.input.KeyEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import dl.subsystem.player_input.resolver.key_pressed.validator.VHasKeyEvents;
import dl.subsystem.player_input.resolver.key_pressed.validator.VProperKeyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static dl.subsystem.player_input.resolver.key_pressed.helper.HVelocityMagnitude.H_VELOCITY_MAGNITUDE;

@Component
public class RKeyPressed implements Resolver {

    @Autowired
    private EntityManager em;

    @Autowired
    private VHasKeyEvents vHasKeyEvents;

    @Autowired
    private VProperKeyCode vProperKeyCode;

    private List<Validator> validators;

    @PostConstruct
    public void initialize() {
        validators = new ArrayList<>();

        validators.add(vHasKeyEvents);
        validators.add(vProperKeyCode);
    }

    @Override
    public void resolve(@NotNull UUID entity) {
        BPlayerInput cPlayerInput = em.getBehavior(entity, BPlayerInput.class);
        BVelocity cVelocity = em.getBehavior(entity, BVelocity.class);

        KeyEvent keyEvent = cPlayerInput.keyboardEvents.getFirst();
        Point2D movementSpeedDelta = cVelocity.movementSpeedDelta;

        cPlayerInput.keyboardEvents.removeFirst();
        cVelocity.movementSpeedDelta = movementSpeedDelta.add(H_VELOCITY_MAGNITUDE.velocityFor(keyEvent.getCode()));

        System.out.println("RKeyPressed");
    }

    @Nullable
    @Override
    public List<Validator> validators() {
        return ImmutableList.copyOf(validators);
    }
}

