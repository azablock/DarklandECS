package dl.entity.factory;

import dl.behavior.BPlayerInput;
import dl.behavior.BPosition;
import dl.behavior.BVelocity;
import dl.behavior.Behavior;
import dl.behavior.factory.graphics.PlayerBGraphicsFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class EFPlayer extends EntityFactory {

    @Autowired
    private PlayerBGraphicsFactory bGraphicsFactory;

    @NotNull
    @Override
    public Set<Behavior> behaviorSignature() {
        return new HashSet<>(Arrays.asList(
                new BPlayerInput(),
                new BPosition(),
                bGraphicsFactory.newInstance(),
                new BVelocity()
        ));
    }

    @NotNull
    @Override
    public String of() {
        return "player";
    }
}
