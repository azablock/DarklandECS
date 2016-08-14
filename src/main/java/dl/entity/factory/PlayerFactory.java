package dl.entity.factory;

import dl.behavior.Behavior;
import dl.behavior.PlayerInput;
import dl.behavior.Position;
import dl.behavior.Velocity;
import dl.behavior.builder.GraphicsBuilder;
import dl.behavior.builder.IntelligenceBuilder;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class PlayerFactory extends EntityFactory {

    @Autowired
    private GraphicsBuilder graphicsBuilder;

    @Autowired
    private IntelligenceBuilder intelligenceBuilder;

    @NotNull
    @Override
    public Set<Behavior> behaviorSignature() {
        return new HashSet<>(Arrays.asList(
                new PlayerInput(),
                new Position(),
                new Velocity(),
                graphicsBuilder
                        .spriteName("player")
                        .build(),
                intelligenceBuilder
                        .action("keyPressed", 1000.0)
                        .build()
        ));
    }
}
