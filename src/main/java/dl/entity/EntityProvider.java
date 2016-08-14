package dl.entity;

import dl.entity.factory.EntityFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class EntityProvider {

    @Autowired
    private Map<String, EntityFactory> entityFactories;

    @NotNull
    public UUID newInstanceOf(@NotNull final String id) {
        return entityFactories.get(id + "Factory").newInstance();
    }
}
