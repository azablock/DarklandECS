package game_world;

import component.CPlayerInput;
import component.CPosition;
import component.CVelocity;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import static game_world.GameLoop.*;

public class GameWorld {

    public final Scene scene;

    public final Group parentGroup;

    private final GameObject playerGameObject;

    public final static GameWorld GAME_WORLD = new GameWorld();

    private GameWorld() {
        parentGroup = new Group();
        scene = new Scene(parentGroup, 800, 600, Color.DARKGREY);
        playerGameObject = new GameObject("Player");
        setInitialGameWorldState();
        GAME_LOOP.start();
    }

    private void setInitialGameWorldState() {
        playerGameObject.add(new CPosition(10, 10));
        playerGameObject.add(new CVelocity());
        playerGameObject.add(new CPlayerInput());

        // TODO: 6/19/2016 do usuniecia cala metoda
        scene.setOnKeyPressed(event -> {
            CPlayerInput playerInput = playerGameObject.get(CPlayerInput.class);
            playerInput.keyboardEvents.addLast(event);
        });
    }
}
