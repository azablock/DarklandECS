package subsystem.render.resolver.renderer;

import component.CSprite;
import game_world.GameObject;
import org.jetbrains.annotations.NotNull;
import subsystem.Resolver;
import subsystem.render.resolver.renderer.helper.TextByPosition;

public class RRenderer implements Resolver {

    @Override
    public void resolve(@NotNull GameObject gameObject) {
        CSprite cSprite = gameObject.get(CSprite.class);

        TextByPosition.convertPositionToText(cSprite.text, gameObject);
    }
}
