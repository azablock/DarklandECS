package component;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.jetbrains.annotations.NotNull;

import java.security.Key;
import java.util.LinkedList;
import java.util.List;

public class CPlayerInput implements Component {

    @NotNull
    public final LinkedList<MouseEvent> mouseEvents;

    @NotNull
    public final LinkedList<KeyEvent> keyboardEvents;

    public CPlayerInput() {
        mouseEvents = new LinkedList<>();
        keyboardEvents = new LinkedList<>();
    }

    public boolean hasKeyEvent() {
        return !keyboardEvents.isEmpty();
    }

    @NotNull
    public KeyEvent nextKeyEvent() {
        KeyEvent keyEvent = keyboardEvents.getFirst();

        keyboardEvents.removeFirst();

        return keyEvent;
    }

    @NotNull
    @Override
    public String simpleName() {
        return "PlayerInput";
    }
}
