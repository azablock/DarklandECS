package dl.game_world;

import dl.Behavior.BPlayerInput;
import dl.Behavior.BPosition;
import dl.Behavior.BSprite;
import dl.Behavior.BVelocity;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import static dl.game_world.GameLoop.GAME_LOOP;

public class GameWorld {

    public final static GameWorld GAME_WORLD = new GameWorld();

    public final Scene scene;

    public final Group parentGroup;

    private final GameObject playerGameObject;

    private GameWorld() {
        parentGroup = new Group();
        scene = new Scene(parentGroup, 800, 600, Color.DARKRED);
        playerGameObject = new GameObject("Dzielny RHycerz",
                new BPosition(new Point2D(10.0, 10.0)),
                new BVelocity(),
                new BPlayerInput(),
                new BSprite());
        setInitialGameWorldState();
        GAME_LOOP.start();
    }

    private void setInitialGameWorldState() {
        parentGroup.getChildren().add(playerGameObject.get(BSprite.class).sprite);

        scene.setOnKeyPressed(event -> {
            BPlayerInput playerInput = playerGameObject.get(BPlayerInput.class);

            if(!playerInput.keyAlreadyPressed) {
                playerInput.keyboardEvents.addLast(event);
                playerInput.keyAlreadyPressed = true;
            }
        });

        scene.setOnKeyReleased(event -> {
            BPlayerInput playerInput = playerGameObject.get(BPlayerInput.class);

            playerInput.keyAlreadyPressed = false;
        });
    }
}
