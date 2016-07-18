package dl.game_world;

import dl.behavior.BPlayerInput;
import dl.behavior.BPosition;
import dl.behavior.BVelocity;
import dl.entity.EntityManager;
import javafx.geometry.Point2D;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class GameWorld {

//    @Autowired
//    private EntityManager em;
//
//    @Autowired
//    private GameLoop gameLoop;
//
//    private UUID playerEntity;
//
//    public GameWorld() {
//        playerEntity = em.createEntity("Rycerzyk");
//
//        em.addBehavior(playerEntity, new BPosition(new Point2D(10.0, 10.0)));
//        em.addBehavior(playerEntity, new BVelocity());
//        em.addBehavior(playerEntity, new BPlayerInput());
////        em.addBehavior(playerEntity, new BSprite());
//
//        setInitialGameWorldState();
//        gameLoop.start();
//    }

//    private void setInitialGameWorldState() {
//        parentGroup.getChildren().add(em.getBehavior(playerEntity, BSprite.class).sprite);

//        scene.setOnKeyPressed(event -> {
//            BPlayerInput playerInput = em.getBehavior(playerEntity, BPlayerInput.class);
//
//            if(!playerInput.isKeyPressed) {
//                playerInput.keyboardEvents.addLast(event);
//                playerInput.isKeyPressed = true;
//            }
//        });
//
//        scene.setOnKeyReleased(event -> {
//            BPlayerInput playerInput = em.getBehavior(playerEntity, BPlayerInput.class);
//
//            playerInput.isKeyPressed = false;
//        });
//    }
}
