package event;

import game_world.GameObject;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

public class EventManager {

    @NotNull
    public final static EventManager EVENT_MANAGER = new EventManager();

    @NotNull
    private final Map<UUID, Map<String, LinkedList<String>>> eventsContainer;

    private EventManager() {
        eventsContainer = new HashMap<>();
        //fixme: iteracja dla kazdego TYPU eventu???
//        SUBSYSTEM_MANAGER.subsystems.forEach(subsystem -> eventsContainer.put(subsystem.getClass(), new HashMap<>()));
    }

    public void receiveEvent(@NotNull final GameObject gameObject,
                             @NotNull final Event event) {
        UUID entity = gameObject.entity();
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
//
//    @NotNull
//    public String nextEventFor(@NotNull final Class<? extends Subsystem> subsystemClass,
//                               @NotNull final UUID entity) {
//        LinkedList<String> events = eventsContainer.get(subsystemClass).get(entity);
//        String event = events.getFirst();
//
//        events.removeFirst();
//
//        return event;
//    }
//
//    @Deprecated
//    public boolean hasEventFor(@NotNull final Class<? extends Subsystem> subsystemClass,
//                               @NotNull final UUID entity) {
//        LinkedList<String> events = eventsContainer.get(subsystemClass).get(entity);
//
//        return events != null && !events.isEmpty();
//    }
}
