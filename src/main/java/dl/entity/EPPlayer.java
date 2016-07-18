package dl.entity;

import dl.behavior.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class EPPlayer extends EntityProvider {

    @NotNull
    @Override
    public Set<Behavior> behaviorSignature() {
        return new HashSet<>(Arrays.asList(
                new BPlayerInput(),
                new BPosition(),
                new BSprite(),
                new BVelocity()
        ));
    }

    @NotNull
    @Override
    public String of() {
        return "Player";
    }
}
