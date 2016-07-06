package dl.subsystem.player_input.resolver.key_pressed;

import com.google.common.collect.ImmutableList;
import dl.Behavior.BPlayerInput;
import dl.Behavior.BVelocity;
import javafx.geometry.Point2D;
import dl.subsystem.Resolver;
import dl.subsystem.Validator;
import dl.game_world.GameObject;
import javafx.scene.input.KeyEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import dl.subsystem.player_input.resolver.key_pressed.validator.VHasKeyEvents;
import dl.subsystem.player_input.resolver.key_pressed.validator.VProperKeyCode;

import java.util.ArrayList;
import java.util.List;

import static dl.subsystem.player_input.resolver.key_pressed.helper.HVelocityMagnitude.H_VELOCITY_MAGNITUDE;

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
        BPlayerInput cPlayerInput = gameObject.get(BPlayerInput.class);
        BVelocity cVelocity = gameObject.get(BVelocity.class);

        KeyEvent keyEvent = cPlayerInput.keyboardEvents.getFirst();
        Point2D movementSpeedDelta = cVelocity.movementSpeedDelta;

        cPlayerInput.keyboardEvents.removeFirst();
        cVelocity.movementSpeedDelta = movementSpeedDelta.add(H_VELOCITY_MAGNITUDE.velocityFor(keyEvent.getCode()));

        System.out.println("RKeyPressed");
    }
}

