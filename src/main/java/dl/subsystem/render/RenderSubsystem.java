package dl.subsystem.render;

import dl.behavior.Graphics;
import dl.behavior.Position;
import dl.subsystem.Subsystem;
import dl.subsystem.render.resolver.renderer.SpriteRenderResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class RenderSubsystem extends Subsystem {

    @Autowired
    private SpriteRenderResolver spriteRenderResolver;

    @PostConstruct
    private void init() {
        resolvers.addAll(Arrays.asList(
                spriteRenderResolver
        ));

        this.requiredBehaviorTypes.addAll(Arrays.asList(
                Position.class,
                Graphics.class
        ));
    }
}
