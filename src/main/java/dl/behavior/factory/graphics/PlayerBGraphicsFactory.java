package dl.behavior.factory.graphics;

import dl.behavior.BGraphics;
import dl.behavior.factory.BehaviorFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PlayerBGraphicsFactory implements BehaviorFactory<BGraphics> {

    @Value("dl/assets/sprites/player.png")
    private String spritePath;

    @NotNull
    @Override
    public BGraphics newInstance() {
        BGraphics bGraphics = new BGraphics();
        ImageView imageView = new ImageView(new Image(spritePath));

        imageView.setFitHeight(64);
        imageView.setFitWidth(64);
        bGraphics.parentGroup.getChildren().add(imageView);

        return bGraphics;
    }
}
