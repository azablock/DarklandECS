package dl.entity.factory;

import dl.behavior.PlayerInput;
import dl.behavior.Position;
import dl.behavior.Velocity;
import dl.behavior.Behavior;
import dl.behavior.factory.graphics.PlayerBGraphicsFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class PlayerFactory extends EntityFactory {

    @Autowired
    private PlayerBGraphicsFactory bGraphicsFactory;

    @NotNull
    @Override
    public Set<Behavior> behaviorSignature() {
        return new HashSet<>(Arrays.asList(
                new PlayerInput(),
                new Position(),
                bGraphicsFactory.newInstance(),
                new Velocity()
        ));
    }

    @NotNull
    @Override
    public String of() {
        return "player";
    }
}
