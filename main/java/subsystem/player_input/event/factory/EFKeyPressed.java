package subsystem.player_input.event.factory;

import component.CPlayerInput;
import event.ComponentDataTransformer;
import event.EventFactory;
import org.jetbrains.annotations.NotNull;

public class EFKeyPressed implements EventFactory<CPlayerInput> {

    @NotNull
    @Override
    public String eventName() {
        return "KeyPressed";
    }

    @NotNull
    @Override
    public ComponentDataTransformer<CPlayerInput> componentDataTransformer() {
        return component -> component.keyboardEvents.getFirst().getCode().toString();
    }
}
