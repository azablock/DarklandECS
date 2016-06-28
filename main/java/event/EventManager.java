package event;

import game_world.GameObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

@Deprecated
public class EventManager {

    @NotNull
    public final static EventManager EVENT_MANAGER = new EventManager();

    @NotNull
    private final Map<UUID, Map<String, LinkedList<String>>> eventsContainer;

    private EventManager() {
        eventsContainer = new HashMap<>();
    }

    public void receiveEvent(@NotNull final Event event) {
        UUID entity = event.entity();
        Map<String, LinkedList<String>> eventsForEntity = eventsContainer.get(entity);

        if (eventsForEntity == null) {
            eventsForEntity = new HashMap<>();
            eventsContainer.put(entity, eventsForEntity);
        }
        LinkedList<String> events = eventsContainer.get(entity).get(event.name());

        if (events == null) {
            events = new LinkedList<>();
            eventsForEntity.put(event.name(), events);
        }

        events.addLast(event.description());
    }

    @Nullable
    public String nextEventFor(@NotNull final UUID entity, @NotNull final String eventName) {
        LinkedList<String> events = eventsContainer.get(entity).get(eventName);
        String event = events.getFirst();

        events.removeFirst();
        return event;
    }

    public boolean hasEventFor(@NotNull final UUID entity, @NotNull final String eventName) {
        Map<String, LinkedList<String>> eventsForEntity = eventsContainer.get(entity);

        if(eventsForEntity == null) {
            return false;
        }
        
        LinkedList<String> events = eventsForEntity.get(eventName);

        return events != null && !events.isEmpty();
    }
}
