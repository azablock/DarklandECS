package dl.entity.factory;

import dl.behavior.AI;
import dl.behavior.Behavior;
import dl.behavior.factory.graphics.GoblinBGraphicsFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class GoblinFactory extends EntityFactory {

    @Autowired
    private GoblinBGraphicsFactory bGraphicsFactory;

    @NotNull
    @Override
    public Set<Behavior> behaviorSignature() {
        return new HashSet<>(Arrays.asList(
                new AI(),
                bGraphicsFactory.newInstance()
        ));

    }

    @NotNull
    @Override
    public String of() {
        return "goblin";
    }
}
