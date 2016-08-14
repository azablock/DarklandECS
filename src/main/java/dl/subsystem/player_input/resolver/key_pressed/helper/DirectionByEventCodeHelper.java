package dl.subsystem.player_input.resolver.key_pressed.helper;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

@Component
public class DirectionByEventCodeHelper {

    private final HashMap<KeyCode, Point2D> directionsByKeyCode;

    public DirectionByEventCodeHelper() {
        directionsByKeyCode = new HashMap<>();

        directionsByKeyCode.put(KeyCode.UP, new Point2D(0.0, -1.0));
        directionsByKeyCode.put(KeyCode.RIGHT, new Point2D(1.0, 0.0));
        directionsByKeyCode.put(KeyCode.DOWN, new Point2D(0.0, 1.0));
        directionsByKeyCode.put(KeyCode.LEFT, new Point2D(-1.0, 0.0));
    }

    @NotNull
    public Set<KeyCode> properKeyCodes() {
        return directionsByKeyCode.keySet();
    }

    @NotNull
    public Point2D directionFor(@NotNull final KeyCode keyCode) {
        return directionsByKeyCode.get(keyCode);
    }
}
