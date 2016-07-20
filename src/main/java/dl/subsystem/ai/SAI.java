package dl.subsystem.ai;

import dl.behavior.BAI;
import dl.subsystem.Subsystem;
import dl.subsystem.ai.resolver.speak.RSpeak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SAI extends Subsystem {

    @Autowired
    private RSpeak rSpeak;

    @PostConstruct
    private void init() {
        resolvers.add(rSpeak);

        requiredBehaviorTypes.add(BAI.class);
    }
}
