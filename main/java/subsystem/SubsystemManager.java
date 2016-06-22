package subsystem;

import org.jetbrains.annotations.NotNull;
import subsystem.movement.SMovement;
import subsystem.player_input.SPlayerInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsystemManager {

    @NotNull
    public final static SubsystemManager SUBSYSTEM_MANAGER = new SubsystemManager();

    @NotNull
    public final List<Subsystem> subsystems;

    private SubsystemManager() {
        subsystems = new ArrayList<>();

        // TODO: 6/19/2016 tymczasowe rozwizanie
        subsystems.addAll(Arrays.asList(
                new SPlayerInput(),
                new SMovement()
        ));
    }
}
