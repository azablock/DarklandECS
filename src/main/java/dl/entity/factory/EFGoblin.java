package dl.entity.factory;

import dl.behavior.BAI;
import dl.behavior.Behavior;
import dl.behavior.factory.graphics.GoblinBGraphicsFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class EFGoblin extends EntityFactory {

    @Autowired
    private GoblinBGraphicsFactory bGraphicsFactory;

    @NotNull
    @Override
    public Set<Behavior> behaviorSignature() {
        return new HashSet<>(Arrays.asList(
                new BAI(),
                bGraphicsFactory.newInstance()
        ));

    }

    @NotNull
    @Override
    public String of() {
        return "goblin";
    }
}
