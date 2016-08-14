package dl.subsystem.render.resolver.renderer;

import dl.behavior.Behavior;
import dl.behavior.Graphics;
import dl.behavior.Position;
import dl.subsystem.Resolver;
import dl.subsystem.render.resolver.renderer.helper.TextByPositionHelper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
public class SpriteRenderResolver extends Resolver {

    @Autowired
    private TextByPositionHelper textByPositionHelper;

    @Override
    public void resolve(@NotNull UUID entity) {
        Graphics graphics = entityManager.getBehavior(entity, Graphics.class);

//        textByPositionHelper.convertPositionToText(bSprite.text, entity);
    }

    @Override
    protected Set<Class<? extends Behavior>> ownRequiredBehaviorTypes() {
        return new HashSet<>(Arrays.asList(
                Position.class,
                Graphics.class
        ));
    }
}
