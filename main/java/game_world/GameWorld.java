package game_world;

import component.CPlayerInput;
import component.CPosition;
import component.CSprite;
import component.CVelocity;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import static game_world.GameLoop.GAME_LOOP;

public class GameWorld {

    public final static GameWorld GAME_WORLD = new GameWorld();

    public final Scene scene;

    public final Group parentGroup;

    private final GameObject playerGameObject;

    private GameWorld() {
        parentGroup = new Group();
        scene = new Scene(parentGroup, 800, 600, Color.DARKRED);
        playerGameObject = new GameObject("Dzielny RHycerz",
                new CPosition(new Point2D(10.0, 10.0)),
                new CVelocity(),
                new CPlayerInput(),
                new CSprite());
        setInitialGameWorldState();
        GAME_LOOP.start();
    }

    private void setInitialGameWorldState() {
        parentGroup.getChildren().add(playerGameObject.get(CSprite.class).sprite);

        scene.setOnKeyPressed(event -> {
            CPlayerInput playerInput = playerGameObject.get(CPlayerInput.class);

            if(!playerInput.keyAlreadyPressed) {
                playerInput.keyboardEvents.addLast(event);
                playerInput.keyAlreadyPressed = true;
            }
        });

        scene.setOnKeyReleased(event -> {
            CPlayerInput playerInput = playerGameObject.get(CPlayerInput.class);

            playerInput.keyAlreadyPressed = false;
        });
    }
}
