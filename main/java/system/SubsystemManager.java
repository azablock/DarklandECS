package system;

import component.CPlayerInput;
import component.CPosition;
import component.CVelocity;
import org.jetbrains.annotations.NotNull;
import system.movement.SMovement;
import system.player_input.SPlayerInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsystemManager {

    @NotNull
    public final List<Subsystem> subsystems;

    @NotNull
    public final static SubsystemManager SUBSYSTEM_MANAGER = new SubsystemManager();

    private SubsystemManager() {
        subsystems = new ArrayList<>();

        // TODO: 6/19/2016 tymczasowe rozwizanie
        subsystems.addAll(Arrays.asList(
                new SPlayerInput(CPlayerInput.class),
                new SMovement(CPosition.class, CVelocity.class)
        ));
    }
}
