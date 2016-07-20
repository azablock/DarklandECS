package dl.game_world;

import dl.behavior.BGraphics;
import dl.behavior.BPlayerInput;
import dl.entity.EntityManager;
import dl.entity.EntityProvider;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Component
public class GameWorld {

    @NotNull
    public final Scene gameScene;

    @NotNull
    private final Group rootGroup;

    @Autowired
    private EntityManager em;

    @Autowired
    private EntityProvider ep;

    @Autowired
    private GameLoop gameLoop;

    private UUID playerEntity;

    public GameWorld() {
        rootGroup = new Group();
        gameScene = new Scene(rootGroup, 800, 600, Color.DARKRED);
    }

    @PostConstruct
    private void init() {
        playerEntity = ep.newInstanceOf("player");



        ep.newInstanceOf("goblin");


        rootGroup.getChildren().add(em.getBehavior(playerEntity, BGraphics.class).parentGroup);

        gameScene.setOnKeyPressed(event -> {
            BPlayerInput playerInput = em.getBehavior(playerEntity, BPlayerInput.class);

            if (!playerInput.isKeyPressed) {
                playerInput.keyboardEvents.addLast(event);
                playerInput.isKeyPressed = true;
            }
        });

        gameScene.setOnKeyReleased(event -> {
            BPlayerInput playerInput = em.getBehavior(playerEntity, BPlayerInput.class);

            playerInput.isKeyPressed = false;
        });

        gameLoop.start();
    }
}