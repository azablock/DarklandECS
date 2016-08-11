package dl.behavior;

import javafx.scene.Group;
import org.jetbrains.annotations.NotNull;

public class Graphics implements Behavior {

    @NotNull
    public final Group parentGroup;

    public Graphics() {
        parentGroup = new Group();
    }

    @NotNull
    @Override
    public String simpleName() {
        return "Sprite";
    }
}
