package dl.behavior;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class PlayerInput implements Behavior {

    @NotNull
    public final LinkedList<MouseEvent> mouseEvents;

    @NotNull
    public final LinkedList<KeyEvent> keyboardEvents;

    public boolean isKeyPressed;

    public PlayerInput() {
        mouseEvents = new LinkedList<>();
        keyboardEvents = new LinkedList<>();
        isKeyPressed = false;
    }

    @NotNull
    @Override
    public String simpleName() {
        return "PlayerInput";
    }
}
