package system.player_input;

import component.Component;
import component.CPlayerInput;
import org.jetbrains.annotations.NotNull;
import system.Subsystem;

import java.util.UUID;

import static entity.EntityManager.ENTITY_MANAGER;
import static event.EventManager.EVENT_MANAGER;

public class SPlayerInput extends Subsystem {

    public SPlayerInput(@NotNull final Class<? extends Component>... componentTypes) {
        super(componentTypes);
    }

    @Override
    public void process(@NotNull UUID entity) {
        // TODO: 6/18/2016 do wywalenia oczywiscie
        CPlayerInput component = ENTITY_MANAGER.getComponent(entity, CPlayerInput.class);

        if(component.hasKeyEvent()) {
            EVENT_MANAGER.receiveEvent(this.getClass(), entity, "Movement" + "[" + component.nextKeyEvent().getCode() + "]");
        }
    }
}
