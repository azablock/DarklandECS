package dl.subsystem.render.resolver.renderer.helper;

import dl.behavior.BPosition;
import dl.entity.EntityManager;
import javafx.scene.text.Text;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TextByPosition {

    @Autowired
    private EntityManager em;

    public void convertPositionToText(@NotNull Text text, @NotNull UUID entity) {
        BPosition cPosition = em.getBehavior(entity, BPosition.class);

        text.setText(em.nameFor(entity) + ": Position" + cPosition.position.toString());
    }
}
