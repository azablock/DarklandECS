package dl.subsystem;

import com.google.common.collect.ImmutableList;
import dl.entity.EntityManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public abstract class ResolverAbstract implements Resolver {

    @NotNull
    protected final List<Validator> validators;

    @Autowired
    protected EntityManager em;

    protected ResolverAbstract() {
        validators = new ArrayList<>();
    }

    @Nullable
    @Override
    public final List<Validator> validators() {
        return ImmutableList.copyOf(validators);
    }
}
