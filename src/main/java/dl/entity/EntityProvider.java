package dl.entity;

import dl.entity.factory.EFGoblin;
import dl.entity.factory.EFPlayer;
import dl.entity.factory.EntityFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class EntityProvider {

    @NotNull
    private final Map<String, EntityFactory> entityFactories;

    @Autowired
    private EFPlayer efPlayer;

    @Autowired
    private EFGoblin efGoblin;

    public EntityProvider() {
        entityFactories = new HashMap<>();
    }

    @PostConstruct
    private void init() {
        entityFactories.put(efPlayer.of(), efPlayer);
        entityFactories.put(efGoblin.of(), efGoblin);
    }

    @NotNull
    public UUID newInstanceOf(@NotNull final String entityType) {
        return entityFactories.get(entityType).newInstance();
    }
}
