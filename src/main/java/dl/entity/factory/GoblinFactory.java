package dl.entity.factory;

import dl.behavior.Behavior;
import dl.behavior.builder.GraphicsBuilder;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class GoblinFactory extends EntityFactory {

    @Autowired
    private GraphicsBuilder graphicsBuilder;

    @NotNull
    @Override
    public Set<Behavior> behaviorSignature() {
        return new HashSet<>(Arrays.asList(
                graphicsBuilder.spriteName("goblin").build()
        ));

    }
}
