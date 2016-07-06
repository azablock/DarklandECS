package dl.subsystem.render.resolver.renderer.helper;

import dl.Behavior.BPosition;
import dl.game_world.GameObject;
import javafx.scene.text.Text;
import org.jetbrains.annotations.NotNull;

public class TextByPosition {

    public static void convertPositionToText(@NotNull Text text, @NotNull GameObject gameObject) {
        BPosition cPosition = gameObject.get(BPosition.class);

        text.setText(gameObject.humanReadableName() + ": Position" + cPosition.position.toString());
    }
}
