package dl.subsystem.player_input.resolver.key_pressed.helper;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Set;

@Component
public class HVelocityMagnitude {

    private static HashMap<KeyCode, Point2D> velocityMagnitudes;

    @NotNull
    public static final HVelocityMagnitude H_VELOCITY_MAGNITUDE = new HVelocityMagnitude();

    private HVelocityMagnitude() {
        velocityMagnitudes = new HashMap<>();
        initialize();
    }

    @PostConstruct
    public void initialize() {
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
