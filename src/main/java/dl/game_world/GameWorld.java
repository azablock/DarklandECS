package dl.game_world;

import dl.behavior.Graphics;
import dl.behavior.PlayerInput;
import dl.entity.EntityManager;
import dl.entity.EntityProvider;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.of;

@Component
public class GameWorld {

    public final Optional<Scene> gameScene;

    @NotNull
    private final Group rootGroup;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private EntityProvider entityProvider;

    @Autowired
    private GameLoop gameLoop;

    private UUID playerEntity;

    public GameWorld() {
        rootGroup = new Group();
        gameScene = of(new Scene(rootGroup, 800, 600, Color.DARKRED));
    }

    @PostConstruct
    private void init() {
        playerEntity = entityProvider.newInstanceOf("player");
        rootGroup.getChildren().add(entityManager.getBehavior(playerEntity, Graphics.class).parentGroup);

        UUID goblinEntity = entityProvider.newInstanceOf("goblin");
        rootGroup.getChildren().add(entityManager.getBehavior(goblinEntity, Graphics.class).parentGroup);

        gameScene.get().setOnKeyPressed(event -> {
            PlayerInput playerInput = entityManager.getBehavior(playerEntity, PlayerInput.class);

            if (!playerInput.isKeyPressed) {
                playerInput.keyboardEvents.addLast(event);
                playerInput.isKeyPressed = true;
            }
        });

        gameScene.get().setOnKeyReleased(event -> {
            PlayerInput playerInput = entityManager.getBehavior(playerEntity, PlayerInput.class);

            playerInput.isKeyPressed = false;
        });

        gameLoop.start();
    }
}