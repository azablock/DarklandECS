package dl.behavior;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class AI implements Behavior {

    @NotNull
    public final Double reactionMillis;

    @NotNull
    public final Timeline timeline;

    @NotNull
    public final LinkedList<String> actions;

    public AI() {
        actions = new LinkedList<>();
        reactionMillis = 1500.0;
        timeline = new Timeline();

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(
            Duration.millis(reactionMillis),
            event -> actions.addLast("speaking")));
    }

    @NotNull
    @Override
    public String simpleName() {
        return "AI";
    }
}
