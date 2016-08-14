package dl.behavior;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class PlayerInput extends Behavior {

    @NotNull
    public final LinkedList<MouseEvent> mouseEvents = new LinkedList<>();

    @NotNull
    public final LinkedList<KeyEvent> keyboardEvents = new LinkedList<>();

    public boolean isKeyPressed = false;
}
