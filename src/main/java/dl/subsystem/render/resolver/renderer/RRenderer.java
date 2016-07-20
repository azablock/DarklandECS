package dl.subsystem.render.resolver.renderer;

import dl.behavior.BGraphics;
import dl.subsystem.ResolverAbstract;
import dl.subsystem.render.resolver.renderer.helper.TextByPosition;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RRenderer extends ResolverAbstract {

    @Autowired
    private TextByPosition textByPosition;

    @Override
    public void resolve(@NotNull UUID entity) {
        BGraphics bSprite = em.getBehavior(entity, BGraphics.class);

//        textByPosition.convertPositionToText(bSprite.text, entity);
    }
}
