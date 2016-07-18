package dl.subsystem;

import com.google.common.collect.ImmutableList;
import dl.subsystem.movement.SMovement;
import dl.subsystem.player_input.SPlayerInput;
import dl.subsystem.render.SRender;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Component
public class SubsystemManager {

    @Autowired
    private SPlayerInput sPlayerInput;

    @Autowired
    private SMovement sMovement;

    @Autowired
    private SRender sRender;

    @NotNull
    private final List<Subsystem> subsystems;

    public SubsystemManager() {
        subsystems = new ArrayList<>();
    }

    @PostConstruct
    private void init() {
        // TODO: 6/19/2016 tymczasowe rozwizanie
        subsystems.addAll(asList(
                sPlayerInput,
                sMovement,
                sRender
        ));
    }

    @NotNull
    public List<Subsystem> subsystems() {
        return ImmutableList.copyOf(subsystems);
    }
}
