package dl.subsystem.ai;

import dl.subsystem.Subsystem;
import dl.subsystem.ai.resolver.speak.SpeakResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class IntelligenceSubsystem extends Subsystem {

    @Autowired
    private SpeakResolver speakResolver;

    @PostConstruct
    private void init() {
        resolvers.addAll(Arrays.asList(
                speakResolver
        ));
    }
}
