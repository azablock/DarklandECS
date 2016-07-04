package subsystem.render.resolver.renderer.helper;

import component.CPosition;
import game_world.GameObject;
import javafx.scene.text.Text;
import org.jetbrains.annotations.NotNull;

public class TextByPosition {

    public static void convertPositionToText(@NotNull Text text, @NotNull GameObject gameObject) {
        CPosition cPosition = gameObject.get(CPosition.class);

        text.setText(gameObject.humanReadableName() + ": Position" + cPosition.position.toString());
    }
}
