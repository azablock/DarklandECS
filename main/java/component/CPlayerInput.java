package component;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class CPlayerInput implements Component {

    @NotNull
    public final LinkedList<MouseEvent> mouseEvents;

    @NotNull
    public final LinkedList<KeyEvent> keyboardEvents;

    public CPlayerInput() {
        mouseEvents = new LinkedList<>();
        keyboardEvents = new LinkedList<>();
    }

    @NotNull
    @Override
    public String simpleName() {
        return "PlayerInput";
    }
}
