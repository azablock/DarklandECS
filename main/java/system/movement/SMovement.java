package system.movement;

import component.Component;
import org.jetbrains.annotations.NotNull;
import system.Subsystem;
import system.player_input.SPlayerInput;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static entity.EntityManager.*;
import static event.EventManager.*;

public class SMovement extends Subsystem {

    public SMovement(@NotNull final Class<? extends Component>... componentTypes) {
        super(componentTypes);
    }

    @Override
    public void process(@NotNull final UUID entity) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        System.out.println(dateFormat.format(cal.getTime()) + ": SMovement: " + ENTITY_MANAGER.nameFor(entity));

        //todo na pewno nie tak ale narazie dla testu
        if(EVENT_MANAGER.hasEventFor(SPlayerInput.class, entity)) {
            String event = EVENT_MANAGER.nextEventFor(SPlayerInput.class, entity);
            System.out.println("SMovement: Event '[" + event + "]' received");
        }
    }
}