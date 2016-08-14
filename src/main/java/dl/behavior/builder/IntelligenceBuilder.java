package dl.behavior.builder;

import dl.behavior.Intelligence;
import dl.behavior.container.IntelligenceAction;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class IntelligenceBuilder implements BehaviorBuilder<Intelligence> {

    private Intelligence intelligence = new Intelligence();

    public IntelligenceBuilder action(String actionName,
                                      Double reactionTimeMillis) {

        IntelligenceAction intelligenceAction = new IntelligenceAction(
                actionName,
                reactionTimeMillis);

        intelligence.actions.put(
                actionName,
                intelligenceAction);

        return this;
    }

    @NotNull
    @Override
    public Intelligence build() {
        return intelligence;
    }
}
