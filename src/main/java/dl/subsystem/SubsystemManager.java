package dl.subsystem;

import dl.subsystem.movement.SMovement;
import dl.subsystem.player_input.SPlayerInput;
import dl.subsystem.render.SRender;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Component
public class SubsystemManager {

    @NotNull
    public final List<Subsystem> subsystems;

    @Autowired
    private SPlayerInput sPlayerInput;

    @Autowired
    private SMovement sMovement;

    @Autowired
    private SRender sRender;

    public SubsystemManager() {
        subsystems = new ArrayList<>();

        // TODO: 6/19/2016 tymczasowe rozwizanie
        subsystems.addAll(asList(
                sPlayerInput,
                sMovement,
                sRender
        ));
    }
}
