package dl.behavior.builder;

import dl.behavior.Behavior;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public interface BehaviorBuilder<T extends Behavior> {

    @NotNull
    T build();
}
