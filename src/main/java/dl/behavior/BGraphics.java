package dl.behavior;

import javafx.scene.Group;
import org.jetbrains.annotations.NotNull;

public class BGraphics implements Behavior {

    @NotNull
    public final Group parentGroup;

    public BGraphics() {
        parentGroup = new Group();
    }

    @NotNull
    @Override
    public String simpleName() {
        return "Sprite";
    }
}
