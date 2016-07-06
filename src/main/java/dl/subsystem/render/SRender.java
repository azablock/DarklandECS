package dl.subsystem.render;

import dl.Behavior.BPosition;
import dl.Behavior.BSprite;
import dl.subsystem.Subsystem;
import dl.subsystem.render.resolver.renderer.RRenderer;

import java.util.Arrays;

public class SRender extends Subsystem {

    @Override
    public void initialize() {
        this.resolvers.add(new RRenderer());

        this.requiredBehaviorTypes.addAll(Arrays.asList(
                BPosition.class,
                BSprite.class
        ));
    }
}
