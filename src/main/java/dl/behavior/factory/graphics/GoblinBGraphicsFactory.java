package dl.behavior.factory.graphics;

import dl.behavior.Graphics;
import dl.behavior.factory.BehaviorFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GoblinBGraphicsFactory implements BehaviorFactory<Graphics> {

    @Value("dl/assets/sprites/goblin.png")
    private String spritePath;

    @NotNull
    @Override
    public Graphics newInstance() {
        Graphics bGraphics = new Graphics();
        ImageView imageView = new ImageView(new Image(spritePath));

        imageView.setFitHeight(64);
        imageView.setFitWidth(64);
        bGraphics.parentGroup.getChildren().add(imageView);

        return bGraphics;
    }
}
