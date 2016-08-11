package dl.subsystem.player_input.resolver.key_pressed.helper;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

@Component
public class VelocityMagnitudeHelper {

    private final HashMap<KeyCode, Point2D> velocityMagnitudes;

    public VelocityMagnitudeHelper() {
        velocityMagnitudes = new HashMap<>();

        velocityMagnitudes.put(KeyCode.UP, new Point2D(0.0, -1.0));
        velocityMagnitudes.put(KeyCode.RIGHT, new Point2D(1.0, 0.0));
        velocityMagnitudes.put(KeyCode.DOWN, new Point2D(0.0, 1.0));
        velocityMagnitudes.put(KeyCode.LEFT, new Point2D(-1.0, 0.0));
    }

    @NotNull
    public Set<KeyCode> properKeyCodes() {
        return velocityMagnitudes.keySet();
    }

    @NotNull
    public Point2D velocityFor(@NotNull final KeyCode keyCode) {
        return velocityMagnitudes.get(keyCode);
    }
}
