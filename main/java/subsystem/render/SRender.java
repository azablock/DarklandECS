package subsystem.render;

import component.CPosition;
import component.CSprite;
import subsystem.Subsystem;
import subsystem.render.resolver.renderer.RRenderer;

import java.util.Arrays;

public class SRender extends Subsystem {

    @Override
    public void initialize() {
        this.resolvers.add(new RRenderer());

        this.requiredComponentTypes.addAll(Arrays.asList(
                CPosition.class,
                CSprite.class
        ));
    }
}
