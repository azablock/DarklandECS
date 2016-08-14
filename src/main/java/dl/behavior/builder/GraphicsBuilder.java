package dl.behavior.builder;

import dl.behavior.Graphics;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GraphicsBuilder implements BehaviorBuilder<Graphics> {

    private String spriteName;

    @Value("64")
    private Integer fitSize;

    @NotNull
    @Override
    public Graphics build() {
        Graphics bGraphics = new Graphics();
        ImageView imageView = new ImageView(new Image(spritePath()));

        imageView.setFitHeight(fitSize);
        imageView.setFitWidth(fitSize);
        bGraphics.parentGroup.getChildren().add(imageView);

        return bGraphics;
    }

    @NotNull
    public GraphicsBuilder spriteName(@NotNull String spriteName) {
        this.spriteName = spriteName;

        return this;
    }

    private String spritePath() {
        return "dl/assets/sprites/" + spriteName + ".png";
    }
}
