package dl.subsystem;

import dl.game_world.GameObject;
import org.jetbrains.annotations.NotNull;

public interface Validator {

    //default
    boolean validate(@NotNull final GameObject gameObject);
}
