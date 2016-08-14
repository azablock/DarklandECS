package dl.behavior;

import dl.behavior.container.IntelligenceAction;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Intelligence extends Behavior {

    @NotNull
    public final HashMap<String, IntelligenceAction> actions = new HashMap<>();
}
