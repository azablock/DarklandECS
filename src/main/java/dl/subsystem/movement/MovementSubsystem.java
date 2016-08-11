package dl.subsystem.movement;

import dl.behavior.Position;
import dl.behavior.Velocity;
import dl.subsystem.Subsystem;
import dl.subsystem.movement.resolver.MovementResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class MovementSubsystem extends Subsystem {

    @Autowired
    private MovementResolver movementResolver;

    @PostConstruct
    public void initialize() {
        resolvers.addAll(Arrays.asList(
              movementResolver
        ));

        requiredBehaviorTypes.addAll(Arrays.asList(
              Position.class,
              Velocity.class
        ));
    }
}