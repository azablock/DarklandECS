package subsystem.player_input.resolver.key_pressed;

import com.google.common.collect.ImmutableList;
import component.CPlayerInput;
import component.CVelocity;
import javafx.geometry.Point2D;
import subsystem.Resolver;
import subsystem.Validator;
import game_world.GameObject;
import javafx.scene.input.KeyEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import subsystem.player_input.resolver.key_pressed.validator.VHasKeyEvents;
import subsystem.player_input.resolver.key_pressed.validator.VProperKeyCode;

import java.util.ArrayList;
import java.util.List;

import static subsystem.player_input.resolver.key_pressed.helper.HVelocityMagnitude.H_VELOCITY_MAGNITUDE;

public class RKeyPressed implements Resolver {

    private final List<Validator> validators;

    public RKeyPressed() {
        validators = new ArrayList<>();

        validators.add(new VHasKeyEvents());
        validators.add(new VProperKeyCode());
    }

    @Nullable
    @Override
    public List<Validator> validators() {
        return ImmutableList.copyOf(validators);
    }

    @Override
    public void resolve(@NotNull GameObject gameObject) {
        CPlayerInput cPlayerInput = gameObject.get(CPlayerInput.class);
        CVelocity cVelocity = gameObject.get(CVelocity.class);

        KeyEvent keyEvent = cPlayerInput.keyboardEvents.getFirst();
        Point2D movementSpeedDelta = cVelocity.movementSpeedDelta;

        cPlayerInput.keyboardEvents.removeFirst();
        cVelocity.movementSpeedDelta = movementSpeedDelta.add(H_VELOCITY_MAGNITUDE.velocityFor(keyEvent.getCode()));

        System.out.println("RKeyPressed");
    }
}

