package dl.subsystem.render.resolver.renderer;

import dl.Behavior.BSprite;
import dl.game_world.GameObject;
import org.jetbrains.annotations.NotNull;
import dl.subsystem.Resolver;
import dl.subsystem.render.resolver.renderer.helper.TextByPosition;

public class RRenderer implements Resolver {

    @Override
    public void resolve(@NotNull GameObject gameObject) {
        BSprite bSprite = gameObject.get(BSprite.class);

        TextByPosition.convertPositionToText(bSprite.text, gameObject);
    }
}
