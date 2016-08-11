package dl.subsystem.render.resolver.renderer.helper;

import dl.behavior.Position;
import dl.entity.EntityManager;
import javafx.scene.text.Text;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TextByPositionHelper {

    @Autowired
    private EntityManager em;

    public void positionToText(@NotNull Text text, @NotNull UUID entity) {
        Position cPosition = em.getBehavior(entity, Position.class);

        text.setText(em.nameFor(entity) + ": Position" + cPosition.position.toString());
    }
}
