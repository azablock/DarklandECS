package dl.behavior.container;

import javafx.animation.Animation;
import javafx.animation.Timeline;
import org.jetbrains.annotations.NotNull;

import java.beans.EventHandler;
import java.util.HashSet;
import java.util.Set;

public class IntelligenceAction {

    public final String name;

    public Integer actionCount;

    public final Timeline timeline;

    public final Set<EventHandler> reactionDefinitions;

    public final Double reactionTimeMillis;

    public IntelligenceAction(
            @NotNull String name,
            @NotNull Double reactionTimeMillis) {

        this.name = name;
        this.actionCount = 0;
        this.timeline = new Timeline();
        this.reactionDefinitions = new HashSet<>();
        this.reactionTimeMillis = reactionTimeMillis;

        this.timeline.setCycleCount(Animation.INDEFINITE);
    }
}
