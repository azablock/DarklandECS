package dl.game_world;

import dl.behavior.BPlayerInput;
import dl.behavior.BPosition;
import dl.behavior.BSprite;
import dl.behavior.BVelocity;
import dl.entity.EntityManager;
import dl.entity.EntityProviderService;
import javafx.geometry.Point2D;
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

    @Autowired
    private EntityManager em;

    @Autowired
    private EntityProviderService eps;

    @Autowired
    private GameLoop gameLoop;

    @NotNull
    private final Group parentGroup;

    private UUID playerEntity;

    public GameWorld() {
        parentGroup = new Group();
        gameScene = new Scene(parentGroup, 800, 600, Color.DARKRED);
    }

    @PostConstruct
    private void init() {
        playerEntity = eps.newInstanceOf("Player");

        gameLoop.start();

        parentGroup.getChildren().add(em.getBehavior(playerEntity, BSprite.class).sprite);

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
    }
}