package dl.subsystem;

import com.google.common.collect.ImmutableList;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubsystemManager {

    @Autowired
    private final List<Subsystem> subsystems;

    public SubsystemManager() {
        subsystems = new ArrayList<>();
    }

    @NotNull
    public List<Subsystem> subsystems() {
        return ImmutableList.copyOf(subsystems);
    }
}
