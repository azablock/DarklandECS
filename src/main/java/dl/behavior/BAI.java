package dl.behavior;

import javafx.animation.Timeline;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class BAI implements Behavior {

    @NotNull
    public final Double reactionMillis;

    @NotNull
    public final Timeline timeline;

    @NotNull
    public final LinkedList<String> actions;

    public BAI() {
        reactionMillis = 1500.0;
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        actions = new LinkedList<>();
    }

    @NotNull
    @Override
    public String simpleName() {
        return "AI";
    }
}
