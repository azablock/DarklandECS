package dl.entity;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class EntityProviderService {

    @Autowired
    private EPPlayer epPlayer;

    @NotNull
    private final Map<String, EntityProvider> entityProviders;

    public EntityProviderService() {
        entityProviders = new HashMap<>();
    }

    @PostConstruct
    private void init() {
        entityProviders.put(epPlayer.of(), epPlayer);
    }

    @NotNull
    public UUID newInstanceOf(@NotNull final String entityType) {
        return entityProviders.get(entityType).newInstance();
    }
}
