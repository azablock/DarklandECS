package dl.game_world;

import dl.subsystem.Subsystem;
import dl.subsystem.SubsystemManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameLoop {

    @Autowired
    private SubsystemManager subsystemManager;

    @NotNull
    private final Timeline timeline;

    public GameLoop() {
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(1000.0 / 60.0),
                event -> subsystemManager.subsystems.forEach(Subsystem::update))
        );
    }

    public void start() {
        timeline.play();
    }
}
