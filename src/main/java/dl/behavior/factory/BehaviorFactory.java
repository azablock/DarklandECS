package dl.behavior.factory;

import dl.behavior.Behavior;
import org.jetbrains.annotations.NotNull;

public interface BehaviorFactory<T extends Behavior> {

    @NotNull
    T newInstance();
}
