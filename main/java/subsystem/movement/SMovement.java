package subsystem.movement;

import component.CPosition;
import component.CVelocity;
import game_world.GameObject;
import org.jetbrains.annotations.NotNull;
import subsystem.Subsystem;

public class SMovement extends Subsystem {

    public SMovement() {
        super();
        this.requiredComponentTypes.add(CPosition.class);
        this.requiredComponentTypes.add(CVelocity.class);
    }

    @Override
    public void process(@NotNull GameObject gameObject) {

    }
}


/*

//        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//        Calendar cal = Calendar.getInstance();
//
//        System.out.println(dateFormat.format(cal.getTime()) + ": SMovement: " + ENTITY_MANAGER.nameFor(entity));

//        todo na pewno nie tak ale narazie dla testu
//        if(EVENT_MANAGER.hasEventFor(SPlayerInput.class, entity)) {
//            String event = EVENT_MANAGER.nextEventFor(SPlayerInput.class, entity);
//            System.out.println("SMovement: Event '[" + event + "]' received");
//        }

 */