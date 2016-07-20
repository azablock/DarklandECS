package dl.subsystem.render;

import dl.behavior.BGraphics;
import dl.behavior.BPosition;
import dl.subsystem.Subsystem;
import dl.subsystem.render.resolver.renderer.RRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class SRender extends Subsystem {

    @Autowired
    private RRenderer rRenderer;

    @PostConstruct
    private void init() {
        this.resolvers.add(rRenderer);

        this.requiredBehaviorTypes.addAll(Arrays.asList(
                BPosition.class,
                BGraphics.class
        ));
    }
}
