package game_world;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;
import subsystem.Subsystem;

import static subsystem.SubsystemManager.*;


public class GameLoop {

    @NotNull
    private final Timeline timeline;

    @NotNull
    public final static GameLoop GAME_LOOP = new GameLoop();

    private GameLoop() {
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(1000.0 / 2.0),
                event -> SUBSYSTEM_MANAGER.subsystems.forEach(Subsystem::update))
        );
    }

    public void start() {
        timeline.play();
    }
}
