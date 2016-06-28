package subsystem.player_input.handler;

import com.google.common.collect.ImmutableList;
import component.CPlayerInput;
import component.CVelocity;
import event.Resolver;
import event.Validator;
import game_world.GameObject;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class RKeyPressed implements Resolver {

    private final List<Validator> validators;

    private HashMap<KeyCode, Point2D> velocityMagnitudes;

    public RKeyPressed() {

        //todo wyniesienie do validatora z key eventami
        velocityMagnitudes = new HashMap<>();
        velocityMagnitudes.put(KeyCode.UP, new Point2D(0.0, -1.0));
        velocityMagnitudes.put(KeyCode.RIGHT, new Point2D(1.0, 0.0));
        velocityMagnitudes.put(KeyCode.DOWN, new Point2D(0.0, 1.0));
        velocityMagnitudes.put(KeyCode.LEFT, new Point2D(-1.0, 0.0));

        validators = new ArrayList<>();

        //czy ma key eventy
        validators.add(new Validator() {
            @Override
            public boolean validate(@NotNull GameObject gameObject) {
                CPlayerInput cPlayerInput = gameObject.get(CPlayerInput.class);
                return !cPlayerInput.keyboardEvents.isEmpty();
            }
        });


        //keyCode
        validators.add(new Validator() {
            @Override
            public boolean validate(@NotNull GameObject gameObject) {
                CPlayerInput cPlayerInput = gameObject.get(CPlayerInput.class);
                KeyEvent keyEvent = cPlayerInput.keyboardEvents.getFirst();

                return velocityMagnitudes.containsKey(keyEvent.getCode());
            }
        });

        //maxSpeed
        validators.add(new Validator() {
            @Override
            public boolean validate(@NotNull GameObject gameObject) {
                CPlayerInput cPlayerInput = gameObject.get(CPlayerInput.class);
                CVelocity cVelocity = gameObject.get(CVelocity.class);
                KeyEvent keyEvent = cPlayerInput.keyboardEvents.getFirst();
                Point2D additionalMagnitude = velocityMagnitudes.get(keyEvent.getCode());
                Point2D currentSpeed = cVelocity.movementSpeedVector;
                Point2D newVelocityMagnitude = new Point2D(
                        currentSpeed.getX() + additionalMagnitude.getX(),
                        currentSpeed.getY() + additionalMagnitude.getY());

                return newVelocityMagnitude.magnitude() <= cVelocity.maxSpeed;
            }
        });
    }

    @Nullable
    @Override
    public List<Validator> validators() {
        return ImmutableList.copyOf(validators);
    }

    @Override
    public void resolve(@NotNull GameObject gameObject) {
        CPlayerInput cPlayerInput = gameObject.get(CPlayerInput.class);
        KeyEvent keyEvent = cPlayerInput.keyboardEvents.getFirst();

        cPlayerInput.keyboardEvents.removeFirst();
        gameObject.get(CVelocity.class).movementSpeedVector.add(velocityMagnitudes.get(keyEvent.getCode()));
    }
}

