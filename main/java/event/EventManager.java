package event;

import org.jetbrains.annotations.NotNull;
import system.Subsystem;
import system.SubsystemManager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

import static system.SubsystemManager.*;

public class EventManager {

    @NotNull
    public final static EventManager EVENT_MANAGER = new EventManager();

    @NotNull
    private final Map<Class<? extends Subsystem>, Map<UUID, LinkedList<String>>> eventsContainer;

    private EventManager() {
        eventsContainer = new HashMap<>();
        SUBSYSTEM_MANAGER.subsystems.forEach(subsystem -> eventsContainer.put(subsystem.getClass(), new HashMap<>()));
    }

    public void receiveEvent(@NotNull final Class<? extends Subsystem> subsystemClass,
                             @NotNull final UUID entity,
                             @NotNull final String event) {
        Map<UUID, LinkedList<String>> eventsForSubsystem = eventsContainer.get(subsystemClass);
        LinkedList<String> events = eventsForSubsystem.get(entity);

        if(events == null) {
            events = new LinkedList<>();
            eventsForSubsystem.put(entity, events);
        }

        events.addLast(event);
    }

    @NotNull
    public String nextEventFor(@NotNull final Class<? extends Subsystem> subsystemClass,
                               @NotNull final UUID entity) {
        LinkedList<String> events = eventsContainer.get(subsystemClass).get(entity);
        String event = events.getFirst();

        events.removeFirst();

        // TODO: 6/19/2016 tutaj chyba parsowanie?
        return event;
    }

    @Deprecated
    public boolean hasEventFor(@NotNull final Class<? extends Subsystem> subsystemClass,
                               @NotNull final UUID entity) {
        LinkedList<String> events = eventsContainer.get(subsystemClass).get(entity);

        return events != null && !events.isEmpty();
    }
}
