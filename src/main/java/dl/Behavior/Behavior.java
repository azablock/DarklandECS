package dl.behavior;

import org.jetbrains.annotations.NotNull;

public abstract class Behavior {

    @NotNull
    public final String simpleName() {
        return getClass().getSimpleName();
    }
}
